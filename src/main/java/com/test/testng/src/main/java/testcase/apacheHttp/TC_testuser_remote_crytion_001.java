package com.test.testng.src.main.java.testcase.apacheHttp;

import com.test.testng.src.main.java.global.GLOBALPARAMETER;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class TC_testuser_remote_crytion_001 {
    @Test
    public void test() {
//        String body = "{\"abc\":\"123\"}";
//        JSONObject jsonObject = JSON.parseObject(body);

        HttpClient httpClient = HttpClients.createDefault();

        String url = GLOBALPARAMETER.HOST + "/tools/encryption";
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            String json = "{\"key\":\"1\",\"pwd\":\"2\"}";
            StringEntity entityInput = new StringEntity(json);
            httpPost.setEntity(entityInput);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            try {
                HttpResponse response = httpClient.execute(httpPost);
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
