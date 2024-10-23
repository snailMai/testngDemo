# 2024
### 2024-10-20
使用OKHttp

### 2024-10-20
1. 生成httpGet和HttpPost
2. 使用方式
```asp
post:
        String url = GLOBALPARAMETER.ENCRYPTION;
        String json = "{\"key\":\"1\",\"pwd\":\"2\"}";
        HttpConnect httpConnect = new HttpConnect();
//        Response response;
        HttpConnect.httpPost(url, json);
get:
        String url = GLOBALPARAMETER.GETTESTUSERBYPAGE.replace("{}", "1");
        HttpConnect httpConnect = new HttpConnect();
//        Response response;
        HttpConnect.httpGet(url);
```