package com.test.testng.src.main.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.testng.logic.HttpResponseVo;
import com.test.testng.logic.HttpUtils;
import com.test.testng.utils.HttpConnect;
import com.test.testng.utils.ReporterLogger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class TC_test {
    private static final ReporterLogger logger = new ReporterLogger(TC_test.class);
    @Test
    public void test(){
//        String body = "{\"abc\":\"123\"}";
//        JSONObject jsonObject = JSON.parseObject(body);
//
//        HttpClient httpClient = HttpClients.createDefault();
//
//        String url = "http://129.226.174.57:8081/myBlog/testuser/testng";
//        try {
//            URIBuilder uriBuilder = new URIBuilder(url);
//            HttpGet httpGet = new HttpGet(uriBuilder.build());
//            try {
//                HttpResponse response = httpClient.execute(httpGet);
//                if (response.getEntity() != null) {
//                    System.out.println("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
//                    HttpEntity entity = response.getEntity();
//                    String bodyResult = EntityUtils.toString(entity, "utf-8");
//                    System.out.println("bodyResult = " + bodyResult);
//                } else {
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
        logger.info("test LOG");
    }

    @Test
    public void test002() throws IOException {
        // 以下三行是为了删除多余标注
//        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
//        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
//        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
        HttpResponse response = null;
        HttpClient httpClient = HttpClients.createDefault();
//        String url = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=0&type=all&web_location=333.934&w_rid=313ddb5bd49cf3ef91ce7d5e2bf182e4&wts=1705810091";
        String url = "https://www.baidu.com";
//        url = url + "/" + args[0];
//        for (int i = 1; i < args.length; i++) {
//            url += "&" + args[i];
//        }
//        url = "http://129.226.174.57:8081/myBlog/testuser/testng";
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test003() throws IOException {
//        String url = "https://api.bilibili.com/x/web-interface/ranking/v2?rid=0&type=all&web_location=333.934&w_rid=313ddb5bd49cf3ef91ce7d5e2bf182e4&wts=1705810091";
        String url = "http://localhost:8081/testuser/all";
        HttpResponseVo httpResponseVo = HttpUtils.httpGet(url);
        System.out.println(httpResponseVo.getBody());
    }
}
