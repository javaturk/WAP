package org.javaturk.wap.ch01;

import java.util.Scanner;
import java.net.*;

public class InetAdressExample {
    private InetAddress address;
    private String canonicalName;
    private InetAddress[] addresses;
    
    public static void main(String[] args) {
	InetAdressExample example = new InetAdressExample();
	try {
	    System.out.println("Local host: " + InetAddress.getLocalHost());
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
	example.getHostInfo();
    }

    public void getHostInfo(){
	Scanner sc = new Scanner(System.in);
	String host = null;
	while(true){
	    System.out.println("Host: ");
	    host = sc.nextLine();
	    if(host.equals(""))
		break;
	    try {
		address = InetAddress.getByName(host);
		canonicalName = address.getCanonicalHostName();
		addresses = InetAddress.getAllByName(host);
	    } catch (UnknownHostException e) {
		
		System.out.println("No such host: " + e.getMessage());
	    }
	    System.out.println("IP: " + address);
	    System.out.println("Canonical name: " + canonicalName);
	    for(InetAddress inetAddress: addresses)
		System.out.println("Name: " + inetAddress.getHostName());
	    System.out.println();
	}
	System.out.println("Exited...");
    }
}
