/*
 * SocketUtil.java
 */

package org.javaturk.wap.util.webclient;

import java.io.*;
import java.net.*;

public class SocketUtil {
    public static BufferedReader getReader(Socket s) throws IOException {
        return(new BufferedReader(new InputStreamReader(s.getInputStream())));
    }

    public static PrintWriter getWriter(Socket s) throws IOException {
        return(new PrintWriter(s.getOutputStream(), true));
    }
}
