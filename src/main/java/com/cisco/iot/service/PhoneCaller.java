package com.cisco.iot.service;

import com.sun.media.jfxmedia.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by yu on 16/3/31.
 */
public class PhoneCaller {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(PhoneCaller.class);

    public static String SIPGetUrl = "http://10.224.57.202:8001?cmd=CallOutReq&taskID=2d8dfa8c-aeb3-48fd-b71b-629a243361fd_19910&from=Spark&to=1-9910&destinationType=PSTN&referUri=sip%3A1234%4010.121.105.86&notifyUri=http%3A%2F%2F10.224.57.66%3A8080%2Fporos%2Fapi%2Fv1%2Fnotifications&requirePressOne=false&dtmfSequence=&userName=&userID=b9b17309-847e-4075-8cc5-0ff2f04db9fa&userType=Host&isPrivateTalk=false&notifyRouteUri=&privateTalkSponsorID=&Sponsor=spark&attendeeID=&wbxConfID=&meetingID=&meetingName=&subConfID=&languageCode=en_US&TrackingID=DSA_Locus-";

    public static HttpResponse call(String number) throws IOException {

        String trackId = UUID.randomUUID().toString();

        HttpClient hc = HttpClientBuilder.create().build();
        HttpGet getReq = new HttpGet(SIPGetUrl+trackId);
        HttpResponse res = hc.execute(getReq);
        logger.info("SIP call response="+res.getStatusLine().getStatusCode());
        return res;
    }


    public static void main(String[] args) throws IOException {
        HttpResponse res = PhoneCaller.call("80166666688");

    }
}
