package org.javaturk.wap.jsp.ch05;

import java.util.*;
import java.text.DateFormat;

public class DateAndTimeBean {
    private String time;
    private String date;

    public DateAndTimeBean() {
    	System.out.println("in DateAndTimeBean()");
    	String[] ids = TimeZone.getAvailableIDs(+2 * 60 * 60 * 1000);
        SimpleTimeZone stz = new SimpleTimeZone(+2 * 60 * 60 * 1000, ids[0]);
        
        Calendar calendar = new GregorianCalendar(stz);
        String hour = String.valueOf(calendar.get(Calendar.HOUR));
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        String second = String.valueOf(calendar.get(Calendar.SECOND));
        time = hour + ":" + minute + ":" + second;

        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        date = df.format(new Date());
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
