package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ATMServlet2
 */

public class ATMServlet2 extends HttpServlet implements SingleThreadModel{
	private Account account;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		account = new Account();
		account.setBalance(0);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		printHeader(out);
		printForm(out);
	}

	public  void dPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		int amount = 0;
		try {
			amount = Integer.parseInt(req.getParameter("AMOUNT"));
		} catch (NullPointerException e) {
			printError(out, "Please enter an amount!");
			return;
		} catch (NumberFormatException e) {
			printError(out, "Amount must be numeric!");
			return;
		}
		if (amount < 0)
			printError(out, "Amount can not be negative!");
		else if (amount >= 0) {

			if ((req.getParameter("WITHDRAW") != null)) {
				if (amount <= account.getBalance()) {
					simulateDelay(out, 5000);
					account.withdraw(amount);
					printHeader(out);
					printForm(out);
				} else
					printError(out, "You don't have sufficient balance!");

			} else if ((req.getParameter("DEPOSIT") != null)) {
				simulateDelay(out, 5000);
				account.deposit(amount);
				printHeader(out);
				printForm(out);
			}
		}
	}

	private void printHeader(PrintWriter out) {
		out.println("<HTML><BODY>");
		out.println("<h1 align=\"center\">ATMServlet2</h1>");
		out.println("<H2>Bank of Ayvalik ATM</H2>");
		out.println("Current Balance: <B>" + account.getBalance() + "</B><BR>");
	}

	private void printForm(PrintWriter out) {
		out.println("<FORM METHOD=POST ACTION=ATMServlet2>");
		out.println("Amount: <INPUT TYPE=TEXT NAME=AMOUNT SIZE=5><BR>");
		out.println("<INPUT TYPE=SUBMIT NAME=DEPOSIT VALUE=\"Deposit\">");
		out.println("<INPUT TYPE=SUBMIT NAME=WITHDRAW VALUE=\"Withdraw\">");
		out.println("</FORM>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.ATMServlet2\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
	}

	private void printError(PrintWriter out, String string) {
		printHeader(out);
		out.println("<H2>Error</H2>");
		out.println("<B>" + string + "</B><BR>");
		printForm(out);
	}

	public void simulateDelay(PrintWriter out, int delay) {
		Thread thread = Thread.currentThread();
		try {
			thread.sleep(delay);
		} catch (InterruptedException e) {
			printError(out, "Problem with threads!");
		}
	}
}

