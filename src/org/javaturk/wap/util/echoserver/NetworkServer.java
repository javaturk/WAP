/*
 * NetworkServer.java
 */

package org.javaturk.wap.util.echoserver;

import java.net.*;
import java.io.*;

import org.javaturk.wap.util.webclient.SocketUtil;

public class NetworkServer {
    private int port, maxConnections;
    
    public NetworkServer(int port, int maxConnections) {
        setPort(port);
        setMaxConnections(maxConnections);
    }
    
    public void listen() {
        int i=0;
        try {
            ServerSocket listener = new ServerSocket(port);
            Socket server;
            while((i++ < maxConnections) || (maxConnections == 0)) {
                server = listener.accept();
                handleConnection(server);
            }
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
            ioe.printStackTrace();
        }
    }
    
    protected void handleConnection(Socket server)
    throws IOException{
        BufferedReader in = SocketUtil.getReader(server);
        PrintWriter out = SocketUtil.getWriter(server);
        System.out.println("Generic Network Server: got connection from " +
        server.getInetAddress().getHostName() + "\n" +
        "with first line �" + in.readLine() + "�");
        out.println("Generic Network Server");
        server.close();
    }
    
    public int getMaxConnections() {
        return(maxConnections);
    }
    
    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }
    
    public int getPort() {
        return(port);
    }
    
    protected void setPort(int port) {
        this.port = port;
    }
}
