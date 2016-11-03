package com.cisco.iot.service;

import sun.misc.BASE64Decoder;

/**
 * Created by yu on 16/3/31.
 */
public class CryptoHandler {

    private static AESencrp aes = new AESencrp();

    static {
        aes.setALGO("AES");
        aes.setKeyValue("5E2DD6B1C07B9F86".getBytes());
    }

    public static String decrypt(String deviceid, String cryptMessage){
        try{
            return new String((new BASE64Decoder()).decodeBuffer(cryptMessage));
        }catch(Exception e){
            return null;
        }
    }

    public static String serverEnc(String message) throws Exception {
        return aes.encrypt(message);

    }

    public static String serverDec(String serverEncedMsg) throws Exception {
        return aes.decrypt(serverEncedMsg);
    }

}
