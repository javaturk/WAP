/*
 * SwingWebClient.java
 */

package org.javaturk.wap.util.webclient;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class WebClient extends JFrame implements Runnable, Interruptible, ActionListener {
	private Thread downloader;

	private Container contentPane;
//	private JSplitPane splitPane;
	private JPanel upperPanel, lowerPanel;
	private JTabbedPane tabbedPane;
	private JPanel textPanel, htmlPanel;
	private JEditorPane htmlPane;
	private JTextArea textArea;

	private JMenuBar menuBar;
	private JMenu fileMenu, helpMenu;
	private JMenuItem exitItem, aboutItem;

	private JButton submitButton, interruptButton;
	private JLabel hostLabel, portLabel, requestLabel, headerLabel, resultLabel;
	private JTextField hostField, portField, requestField;
	private JTextArea headerArea;

	private boolean isInterrupted = false;

	private Properties properties;
	private String propertiesFile = "C:\\Users\\Administrator\\Documents\\NetBeansProjects\\WAP3.1\\src\\java\\com\\thinkingJava\\wap\\util\\webclient\\webclient.properties";
	private boolean defaultProps = false;

	private String host, port, requestLine;
	private int portInt;
	private String[] requestHeaders = new String[100];

	private HttpClient httpClient;

	private Font boldFont = new Font("Calibri", Font.BOLD, 16);

	public WebClient(String title) {
		super(title);
		// addMenuBar();

		loadProperties();

		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		setPanels();

//		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upperPanel, lowerPanel);
//		splitPane.setOneTouchExpandable(true);
//		splitPane.setDividerLocation(200);

		contentPane.add(upperPanel, BorderLayout.NORTH);
		contentPane.add(lowerPanel, BorderLayout.CENTER);

		JPanel interruptPanel = new JPanel();
		interruptButton = new JButton("Interrupt Download");
		interruptButton.addActionListener(this);
		interruptPanel.add(interruptButton);
//		contentPane.add(interruptPanel, BorderLayout.SOUTH);
		
		httpClient = new HttpClient(textArea, htmlPane, this);
	}

	public void loadProperties() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File(propertiesFile)));
		} catch (FileNotFoundException nfe) {
			System.out.println("Properties file not found: " + propertiesFile);
			System.out.println("Using default properties");
			host = "localhost";
			port = "8080";
			requestLine = "GET / HTTP/1.0";
			defaultProps = true;
		} catch (IOException nfe) {
			report("Can not read properties file" + propertiesFile);
		}
		if (!defaultProps) {
			host = properties.getProperty("host");
			port = properties.getProperty("port");
			requestLine = properties.getProperty("requestLine");
		}
	}

	public void addMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);

		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About", KeyEvent.VK_A);
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);

		setJMenuBar(menuBar);
	}

	public void setPanels() {
		upperPanel = new JPanel(new BorderLayout());
		JPanel upperPanel1 = new JPanel(new GridLayout(2, 1));
		JPanel centerPanel = new JPanel(new GridLayout(3, 1));

		JPanel p1 = new JPanel();
		hostLabel = new JLabel("      Host:     ");
		hostLabel.setFont(boldFont);
		p1.add(hostLabel);
		hostField = new JTextField(host, 20);
		p1.add(hostField);
		centerPanel.add(p1);

		JPanel p2 = new JPanel();
		JPanel portPanel = new JPanel(new GridLayout(1, 5));
		portLabel = new JLabel(" Port:    ");
		portLabel.setFont(boldFont);
		portPanel.add(portLabel);
		portField = new JTextField(port, 4);
		portPanel.add(portField);
		portPanel.add(new JLabel("         "));
		portPanel.add(new JLabel("         "));
		portPanel.add(new JLabel("         "));
		p2.add(portPanel);
		centerPanel.add(p2);

		JPanel p3 = new JPanel();
		requestLabel = new JLabel("        Request: ");
		requestLabel.setFont(boldFont);
		p3.add(requestLabel);
		requestField = new JTextField(requestLine, 40);
		p3.add(requestField);
		centerPanel.add(p3);

		JPanel centerWarepperPanel = new JPanel(new BorderLayout());
		centerWarepperPanel.add(centerPanel, BorderLayout.WEST);

		upperPanel1.add(centerWarepperPanel);

		JPanel headerPanel = new JPanel(new BorderLayout());
		headerLabel = new JLabel(" Request Headers:");
		headerLabel.setFont(boldFont);
		headerPanel.add(headerLabel, BorderLayout.WEST);
		JPanel headerAreaPanel = new JPanel(new BorderLayout());
		headerArea = new JTextArea(4, 40);
		Border etched = BorderFactory.createEtchedBorder();
		headerArea.setBorder(etched);
		headerAreaPanel.add(headerArea, BorderLayout.WEST);
		headerPanel.add(headerAreaPanel, BorderLayout.CENTER);
		headerPanel.add(new JPanel(), BorderLayout.EAST);

		JPanel submitPanel = new JPanel();
		submitButton = new JButton("Submit Request");
		submitButton.addActionListener(this);
		submitPanel.add(submitButton);
		headerPanel.add(submitPanel, BorderLayout.SOUTH);

		upperPanel1.add(headerPanel);

		upperPanel.add(upperPanel1, BorderLayout.NORTH);

		// Lower part, below the split
		lowerPanel = new JPanel(new BorderLayout());
		tabbedPane = new JTabbedPane();

		textPanel = new JPanel(new BorderLayout());
		textArea = new JTextArea();
		JScrollPane textAreaScrollPane = new JScrollPane(textArea);
		textAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPanel.add(textAreaScrollPane);
		tabbedPane.add("Text", textPanel);

		htmlPanel = new JPanel(new BorderLayout());
		htmlPane = new JEditorPane();
		htmlPane.setEditable(false);
		htmlPane.setContentType("text/html ");
		JScrollPane htmlPaneScrollPane = new JScrollPane(htmlPane);
		htmlPaneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		htmlPaneScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		htmlPanel.add(htmlPaneScrollPane);

		tabbedPane.add("Html", htmlPanel);
		lowerPanel.add(tabbedPane, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submitButton) {
			textArea.setText("");
			downloader = new Thread(this);
			downloader.start();
		} else if (event.getSource() == interruptButton) {
			isInterrupted = true;
		}
	}

	public boolean isInterrupted() {
		return (isInterrupted);
	}

	public void run() {
		isInterrupted = false;
		if (hasLegalArgs())
			httpClient.connect(host, portInt, requestLine, requestHeaders);
	}

	private boolean hasLegalArgs() {
		host = hostField.getText().trim();
		if (host.length() == 0) {
			report("Missing hostname");
			return (false);
		}
		String portString = portField.getText().trim();
		if (portString.length() == 0) {
			report("Missing port number");
			return (false);
		}
		try {
			portInt = Integer.parseInt(portString);
		} catch (NumberFormatException nfe) {
			report("Illegal port number: " + portString);
			return (false);
		}
		requestLine = requestField.getText().trim();
		if (requestLine.length() == 0) {
			report("Missing request line");
			return (false);
		}
		getRequestHeaders();
		return (true);
	}

	private void getRequestHeaders() {
		for (int i = 0; i < requestHeaders.length; i++)
			requestHeaders[i] = null;
		int headerNum = 0;
		String header = headerArea.getText().trim();
		StringTokenizer tok = new StringTokenizer(header, "\r\n");
		while (tok.hasMoreTokens())
			requestHeaders[headerNum++] = tok.nextToken();
	}

	private void report(String s) {
		textArea.setText(s);
	}

	public static void main(String[] args) {
		WebClient frame = new WebClient("Web Client");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(800, 900);
		frame.show();
	}
}
