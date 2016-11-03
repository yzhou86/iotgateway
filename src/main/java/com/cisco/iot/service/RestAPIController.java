package com.cisco.iot.service;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.*;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yu on 16/3/30.
 */
@RestController
public class RestAPIController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RestAPIController.class);


    @RequestMapping(value="/privacy/status",method = RequestMethod.GET)
    public @ResponseBody Map<String,DeviceStatus> status() {
        return MessageService.deviceStatusMap;
    }

    @RequestMapping(value="/privacy/upload",method = RequestMethod.POST)
    public @ResponseBody ReturnObject uploadData(
            @RequestBody String body) {
        try {
            logger.info("receive privacy data from API body="+body);
            String jsonStr = java.net.URLDecoder.decode(body, "UTF-8");
            logger.info("receive privacy data from API jsonStr="+jsonStr);
            final JSONObject obj = new JSONObject(jsonStr);
            String message = null;
            try {
                message = obj.getJSONObject("data").getJSONArray("Records").getJSONObject(0).getString("Private");
            }catch(Exception e){}
            String deviceid = obj.getJSONObject("data").getJSONObject("header").getString("Deviceid");
            return MessageService.receiveMessage(deviceid, message, jsonStr);
        }catch(Exception e){
            logger.error("receive privacy data from API error:",e);
            return new ReturnObject(true, e.getMessage(), null, "Wrong Format");
        }

    }

}
