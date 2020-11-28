/*
 * ThreadedEchoServer.java
 */

package org.javaturk.wap.util.echoserver;

import java.net.*;
import java.io.*;

public class ThreadedEchoServer extends EchoServer implements Runnable {
    public static void main(String[] args) {
        int port = 8888;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch(NumberFormatException nfe) {}
        }
        ThreadedEchoServer echoServer = new ThreadedEchoServer(port, 0);
        echoServer.serverName = "Threaded Echo Server";
    }
    public ThreadedEchoServer(int port, int connections) {
        super(port, connections);
    }
    
    public void handleConnection(Socket server) {
        Connection connectionThread = new Connection(this, server);
        connectionThread.start();
    }
    
    public void run() {
        Connection currentThread = (Connection)Thread.currentThread();
        try {
            super.handleConnection(currentThread.serverSocket);
        } catch(IOException ioe) {
            System.out.println("IOException: " + ioe);
            ioe.printStackTrace();
        }
    }
}

class Connection extends Thread {
    protected Socket serverSocket;
    public Connection(Runnable serverObject,
    Socket serverSocket) {
        super(serverObject);
        this.serverSocket = serverSocket;
    }
}
