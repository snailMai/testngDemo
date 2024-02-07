package com.test.testng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpConnect {
    private static final ReporterLogger logger = new ReporterLogger(HttpConnect.class);


    public static HttpResponse httpGet(String url, String... args){
        // 以下三行是为了删除多余标注
//        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
//        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
//        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
        HttpResponse response = null;
        HttpClient httpClient = HttpClients.createDefault();
        url = url + "/" + args[0];
        for (int i = 1; i < args.length; i++) {
            url += "&" + args[i];
        }
        url = "http://129.226.174.57:8081/myBlog/testuser/testng";
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            try {
                logger.info("httpGet请求：" + url);
                response = httpClient.execute(httpGet);
                logger.info("httpGet返回码：" + response.getStatusLine().getStatusCode());
                HttpEntity entity = response.getEntity();
                String bodyResult = EntityUtils.toString(entity, "utf-8");
                logger.info("httpGet返回内容：" + bodyResult);
                return response;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }


    public static void main(String[] args) {
        new HttpConnect().httpGet(null, "testng");

    }
}
