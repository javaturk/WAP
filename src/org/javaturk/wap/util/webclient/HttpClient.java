/*
 * HttpClient.java
 */

package org.javaturk.wap.util.webclient;

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class HttpClient extends NetworkClient {
    private String requestLine;
    private String[] requestHeaders;
    private JTextArea outputArea;
    private JEditorPane htmlPane;
    private Interruptible app;
    private URL url;
    public HttpClient(JTextArea outputArea, JEditorPane htmlPane, Interruptible app) {   
        super(outputArea);
        this.outputArea = outputArea;
        this.htmlPane = htmlPane;
        this.app = app;
    }
    
    public void connect(String host, int port, String requestLine, String[] requestHeaders) {
        this.requestHeaders = requestHeaders;
        this.requestLine = requestLine;
        constructURL(host, port, requestLine);
        if (checkHost(host))
            super.connect(host, port, requestLine, requestHeaders);
    }
    
    protected void handleConnection(Socket uriSocket)
    throws IOException {
        try {
            PrintWriter out = SocketUtil.getWriter(uriSocket);
            BufferedReader in = SocketUtil.getReader(uriSocket);
            out.println(requestLine);
            for(int i=0; i<requestHeaders.length; i++) {
                if (requestHeaders[i] == null)
                    break;
                else
                    out.println(requestHeaders[i]);
            }
            out.println();
            String line;
            int lineNo = 0;
            boolean startAppend = false;
            while ((line = in.readLine()) != null && !app.isInterrupted()){
                outputArea.append(line + "\n");
                //if(line.startsWith("</html>"))   break;
            }
            if (app.isInterrupted())
                outputArea.append("---- Download Interrupted ----");
            htmlPane.setPage(url);
        } catch(Exception e) {
            outputArea.append("Error: " + e);
        }
    }
    
    private boolean checkHost(String host) {
        try {
            InetAddress.getByName(host);
            return(true);
        } catch(UnknownHostException uhe) {
            outputArea.setText("Bogus host: " + host);
            return(false);
        }
    }
    
    public void constructURL(String host, int port, String requestLine){
        StringTokenizer st = new StringTokenizer(requestLine);
        st.nextToken();
        String urlString = "http://" + host + ":" + port + st.nextToken();        
        try {
            url = new URL(urlString);
        } catch(MalformedURLException uhe) {
            outputArea.setText("Malformed URL: " + url);
        }
    }
}

class NetworkClient {
    protected String host;
    protected int port;
    private JTextArea outputArea;

    public NetworkClient(JTextArea outputArea) {
        this.outputArea = outputArea;
    }
    
    public void connect(String host, int port, String requestLine, String[] requestHeaders) {
        try {
            Socket client = new Socket(host, port);
            handleConnection(client);
        } catch(UnknownHostException e) {
            outputArea.setText("Unknown host: " + host);
        } catch(IOException e) {
            outputArea.setText("IOException: " + e);
        }
    }
    
    protected void handleConnection(Socket client) throws IOException {
        PrintWriter out = SocketUtil.getWriter(client);
        BufferedReader in = SocketUtil.getReader(client);
        out.println("Generic Network Client");
        System.out.println("Generic Network Client:\n" + "Made connection to " + host + " and got �" + in.readLine() + "� in response");
        client.close();
    }
    
    public String getHost() {
        return(host);
    }
    
    public int getPort() {
        return(port);
    }
}
