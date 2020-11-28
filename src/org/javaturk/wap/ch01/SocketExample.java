package org.javaturk.wap.ch01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketExample {
	private InetAddress address;
	private Socket socket;
	private String url;
	private int port;
	private String resource;

	public SocketExample(String url, String resource, int port) {
		this.url = url;
		this.resource = resource;
		this.port = port;

		try {
			address = InetAddress.getByName(url);
			socket = new Socket(address, port);
		} catch (UnknownHostException e) {
			System.out.println("Problem with creating address/socket: "
					+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem with creating socket: "
					+ e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Adress Resource Port: ");
		String host = sc.next();
		String resource = sc.next();
		int port = sc.nextInt();

		SocketExample example = new SocketExample(host, resource, port);
		example.download();
	}

	public void download() {
		System.out.println("Sending the request");

		try {
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter br = new BufferedWriter(osw);
			br.write("GET /SelamWebApp/selam HTTP/1.0");
			br.flush();
		} catch (IOException e) {
			System.out.println("Problem with writing to socket: "
					+ e.getMessage());
		}

		String line = null;
		System.out.println("Here is the content");
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isw = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isw);
			while ((line = br.readLine()) != null)
				System.out.println(line);
		} catch (IOException e) {
			System.out.println("Problem with reading from socket: "
					+ e.getMessage());
		}
	}

}
