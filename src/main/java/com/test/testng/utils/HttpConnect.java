package com.test.testng.utils;

import com.test.testng.src.main.java.global.GLOBALPARAMETER;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;

public class HttpConnect {
    private static final ReporterLogger logger = new ReporterLogger(HttpConnect.class);






    /**
     * get方法中, 使用查询参数的, 预估使用很少, 先写上
     * @param url
     * @param parameters
     * @return
     */
    public static Response httpGet(String url, String parameters){
        OkHttpClient client = new OkHttpClient();

        url = url + parameters;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                System.out.println(responseData);
            } else {
                System.out.println("Request not successful: " + response.code());
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 常用get方法
     * @param url
     * @return
     */
    public static Response httpGet(String url){
        logger.info("get url: " + url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                logger.info("responseCode: " + response.code());
                logger.info("responseBody: " + responseData);
            } else {
                logger.error("responseCode: " + response.code());
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 常用httpPost方法
     * @param url
     * @param json
     * @return
     */
    public static Response httpPost(String url, String json){
        logger.info("post url: " + url);
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                logger.info("responseCode: " + response.code());
                logger.info("responseBody: " + responseData);
            } else {
                logger.error("responseCode: " + response.code());
            }
            return response;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * httpPost requestBody使用FormBody -- 还没写好, 使用时再写
     * @param url
     * @param map
     * @return
     */
    public static Response httpPost(String url, HashMap<String, Object> map){
        OkHttpClient client = new OkHttpClient();

//        String url = GLOBALPARAMETER.HOST + "/tools/encryption";

        RequestBody body = new FormBody.Builder()
                .add("key1", "value1")
                .add("key2", "value2")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseData = response.body().string();
                System.out.println(responseData);
            } else {
                System.out.println("Request not successful: " + response.code());
            }
            return response;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
//        new HttpConnect().httpGet(null, "testng");
        String url = GLOBALPARAMETER.HOST + "/tools/encryption";
        String json = "{\"key\":\"1\",\"pwd\":\"2\"}";
//        HttpConnect.httpPost(url, json);

        // get
        url = GLOBALPARAMETER.HOST + "/testuser/allTestUserVue/page/1";
        HttpConnect.httpGet(url);
    }


    private void feiQiCode() {
//    public static HttpResponse httpGet(String url, String... args){
//        // 以下三行是为了删除多余标注
////        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
////        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
////        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");
//        HttpResponse response = null;
//        HttpClient httpClient = HttpClients.createDefault();
//        url = url + "/" + args[0];
//        for (int i = 1; i < args.length; i++) {
//            url += "&" + args[i];
//        }
//        url = "http://129.226.174.57:8081/myBlog/testuser/testng";
//        try {
//            URIBuilder uriBuilder = new URIBuilder(url);
//            HttpGet httpGet = new HttpGet(uriBuilder.build());
//            try {
//                logger.info("httpGet请求：" + url);
//                response = httpClient.execute(httpGet);
//                logger.info("httpGet返回码：" + response.getStatusLine().getStatusCode());
//                HttpEntity entity = response.getEntity();
//                String bodyResult = EntityUtils.toString(entity, "utf-8");
//                logger.info("httpGet返回内容：" + bodyResult);
//                return response;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
//
//    public static HttpResponse httpPostExec(String url, String json){
//        HttpResponse response = null;
//        HttpClient httpClient = HttpClients.createDefault();
////        url = GLOBALPARAMETER.HOST + "/tools/encryption";
//        try {
//            URIBuilder uriBuilder = new URIBuilder(url);
//            HttpPost httpPost = new HttpPost(uriBuilder.build());
////            json = "{\"key\":\"1\",\"pwd\":\"2\"}";
//            StringEntity entityInput = new StringEntity(json);
//            httpPost.setEntity(entityInput);
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setHeader("Content-type", "application/json");
//
//            try {
//                response = httpClient.execute(httpPost);
//                if (response.getEntity() != null) {
//                    System.out.println("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
//                    HttpEntity entity = response.getEntity();
//                    String bodyResult = EntityUtils.toString(entity, "utf-8");
//                    System.out.println("bodyResult = " + bodyResult);
//                    return response;
//                } else {
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
    }
}
