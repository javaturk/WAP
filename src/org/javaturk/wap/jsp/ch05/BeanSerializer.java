package org.javaturk.wap.jsp.ch05;

import java.io.*;

public class BeanSerializer {

    public static void main(String args[]) throws IOException{
        MyBean myBean = new MyBean();
        myBean.setMyAttribute("Is this my attribute?");
        File outputFile = new File("C:\\", "mySerializedBean.ser");
        FileOutputStream out = new FileOutputStream(outputFile);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(myBean);
        oos.close();
    }
}