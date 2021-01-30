package org.lab11.controller;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDataTimeTag extends SimpleTagSupport {
    String color;
    String size;
    public void doTag() throws JspException, IOException {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        //System.out.println("Current Date: " + ft.format(dNow));
        String str = "<span style='";
        if(color != null){
            str += "color:" + color;
        }
        if(size != null){
            str += "; font-size:" + size;
        }
        str += "'>" + ft.format(dNow) + "</span>";

        JspWriter out = getJspContext().getOut();
        System.out.println(str);
        out.write(str);
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
