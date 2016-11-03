package com.cisco.iot.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yu on 16/3/31.
 */
public class Message {

    private String text = "";

    private String receiveTime = "";

    public Message(String text){
        this.text = text;
        this.receiveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

}
