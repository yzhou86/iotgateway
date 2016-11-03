package com.cisco.iot.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yu on 16/3/31.
 */
public class DeviceStatus {

    public String id;

    public int messageCount=0;

    public List<Message> messageList = new ArrayList<>();

    public String toHtmlTable(){
        StringBuffer sb = new StringBuffer("");
        sb.append("<tr><td>" + this.id + "</td><td>" + this.messageCount + "</td><td>");
        for (Message msg : this.messageList){
            sb.append(msg.getReceiveTime()+"&nbsp;:&nbsp;"+msg.getText()+"<br/>");
        }
        sb.append("</td></tr>");
        return sb.toString();
    }

    public DeviceStatus(String id){
        this.id = id;
    }

    public void receivedMessage(String msg){
        this.messageList.add(new Message(msg));
        this.messageCount++;
    }
}
