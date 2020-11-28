package org.javaturk.wap.jsp.ch05;

import java.io.*;

public class MyBean  implements Serializable{
    private String myAttribute = "An attribute of MyBean";
    private int i;

    public MyBean() {
    		System.out.println("Constructor of MyBean");
        i++;
    }

    public void setMyAttribute(String myAttribute) {
        this.myAttribute = myAttribute;
    }

    public String getMyAttribute() {
        return myAttribute;
    }

    public int getI() {
    	System.out.println("get: " + i + " " + this);
        return i;
    }

    public void setI(int i) {
    	System.out.println("set: " + i + " " + this);
        this.i = i;
    }
}
