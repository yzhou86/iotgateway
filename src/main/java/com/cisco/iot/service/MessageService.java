package com.cisco.iot.service;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yu on 16/3/31.
 */
public class MessageService {

    public static Map<String, DeviceStatus> deviceStatusMap = new HashMap<>();

    public static ReturnObject receiveMessage(String deviceId, String message, String jsonStr){
        try {

            if (!deviceStatusMap.containsKey(deviceId)){
                deviceStatusMap.put(deviceId, new DeviceStatus(deviceId));
            }
            deviceStatusMap.get(deviceId).receivedMessage(jsonStr);

            if (StringUtils.isBlank(message)){
                //do nothing
            }else{
                String plainPrivacyData = CryptoHandler.decrypt(deviceId, message);
                MessageProcessor.processMessage(deviceId, plainPrivacyData);
            }


            return new ReturnObject(false, null, null, "OKOKOK");
        }catch(Exception e){
            return new ReturnObject(true, e.getMessage(), null, "FAIL");
        }
    }

}
