/*
 * URLExample.java
 */

package org.javaturk.wap.ch02;

import java.net.*;
import java.io.*;
import java.util.*;

public class URLExample {
    private URL url;
    private URLConnection connection;

    public URLExample(String urlString) {
	try {
	    url = new URL(urlString);
	} catch (MalformedURLException e) {
	    System.err.println("Problem with constructing the url " + e);
	}

	try {
	    connection = url.openConnection();
	} catch (IOException e) {
	    System.err.println("Problem with opening a connection " + e);
	}
    }

    public void printHeaders(){
        System.out.println("-----     Headers of " + url + "     -----");
        try {
            Map headers = connection.getHeaderFields();
            Set keys = headers.keySet();
            for(Object key: keys)
        	System.out.println(key + ": " + headers.get(key));
        	
            System.out.println(connection.getContent());
        }
        catch (IOException e)  {
            System.err.println("Problem with getting the content " + e);
        }
        System.out.println("-----     Headers of " + url + "     -----\n");
    }
    
    public void downloadContent1() {
	System.out.println("-----     Content of " + url + "     -----");
	try {
	    InputStream in = url.openStream();
	    int c;
	    while ((c = in.read()) != -1)
		System.out.write(c);
	} catch (IOException e) {
	    System.err.println("Problem with reading the content " + e);
	}
	System.out.println("-----     Content of " + url + "     -----\n");
    }

    public void downloadContent2() {
	System.out.println("-----     Content of " + url + "     -----");
	try {
	    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    String inputLine;

	    while ((inputLine = in.readLine()) != null)
		System.out.println(inputLine);
	    in.close();

	} catch (IOException e) {
	    System.err.println("Problem with reading the content " + e);
	}
	System.out.println("-----     Content of " + url + "     -----\n");
    }

    public static void main(String[] args) {
	String urlString = "http://localhost:8080/WAP3.0/index.html";
	URLExample example = new URLExample(urlString);
	example.printHeaders();
	example.downloadContent1();
	example.downloadContent2();
    }
}
