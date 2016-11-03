package com.cisco.iot.service;

import java.io.IOException;

/**
 * Created by yu on 16/3/31.
 */
public class MessageProcessor {

    public static ReturnObject processMessage(String deviceid, String message) throws IOException{
        ReturnObject ro = new ReturnObject();

        PhoneCaller.call(message);
        return ro;
    }

}
