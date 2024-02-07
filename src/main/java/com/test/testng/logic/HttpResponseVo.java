package com.test.testng.logic;

public class HttpResponseVo {
    int status;
    String body;
    String cookies;
    String header;

    public HttpResponseVo(int status, String body, String cookies, String header) {
        this.status = status;
        this.body = body;
        this.cookies = cookies;
        this.header = header;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
