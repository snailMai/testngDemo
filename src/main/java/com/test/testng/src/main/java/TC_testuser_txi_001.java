package com.test.testng.src.main.java;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

public class TC_testuser_txi_001 {
    @Test
    public void test(){
        String body = "{\"abc\":\"123\"}";
        JSONObject jsonObject = JSON.parseObject(body);

        HttpClient httpClient = HttpClients.createDefault();

        String url = "http://129.226.174.57:8081/myBlog/testuser/testng";
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            try {
                HttpResponse response = httpClient.execute(httpGet);
                if (response.getEntity() != null) {
                    System.out.println("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
                    HttpEntity entity = response.getEntity();
                    String bodyResult = EntityUtils.toString(entity, "utf-8");
                    System.out.println("bodyResult = " + bodyResult);
                } else {
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
