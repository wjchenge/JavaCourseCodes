# JavaCourseCodes
java进阶训练营作业

## week03作业

### 作业1（必做）整合你上次作业的 httpclient/okhttp  

[整合httpclient版本](03nio/src/main/java/nio/wjchenge/netty/gateway/v1)

访问 http://localhost:8808/test 运行结果如下:

    Executing request GET http://127.0.0.1:8801/test
    ----------------------------------------
    hello,nio1
    Executing request GET http://127.0.0.1:8801/favicon.ico
    ----------------------------------------
    hello,nio1

### 作业3（必做）实现过滤器。

[实现过滤器版本](03nio/src/main/java/nio/wjchenge/netty/gateway/v2)

大体思路利用Java SPI扩展机制进行过滤器的扩展实现:

#### 1、定义过滤器接口规范
[HttpRequestFilter](03nio/src/main/java/nio/wjchenge/netty/gateway/v2/filter/HttpRequestFilter.java)

#### 2、过滤器具体扩展实现
[HeaderHttpRequestFilter](03nio/src/main/java/nio/wjchenge/netty/gateway/v2/filter/HeaderHttpRequestFilter.java)

#### 3、扩展类加载器
[ExtensionLoader](03nio/src/main/java/nio/wjchenge/netty/gateway/v2/extension/ExtensionLoader.java)

#### 4、特定配置文件
[META-INF/services/nio.wjchenge.netty.gateway.v2.filter.HttpRequestFilter](03nio/src/main/resources/META-INF/services/nio.wjchenge.netty.gateway.v2.filter.HttpRequestFilter)

访问 http://localhost:8808/test

gateway服务运行结果如下:

    Executing request GET http://127.0.0.1:8801/test
    ----------------------------------------
    hello,nio1
    Executing request GET http://127.0.0.1:8801/favicon.ico
    ----------------------------------------
    hello,nio1

HttpServer服务运行结果如下:

    打印请求体-------------------begin
    GET /test HTTP/1.1
    Host: localhost:8808
    Connection: keep-alive
    Cache-Control: max-age=0
    sec-ch-ua: "Google Chrome";v="93", " Not;A Brand";v="99", "Chromium";v="93"
    sec-ch-ua-mobile: ?0
    sec-ch-ua-platform: "Windows"
    Upgrade-Insecure-Requests: 1
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36
    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
    Sec-Fetch-Site: none
    Sec-Fetch-Mode: navigate
    Sec-Fetch-User: ?1
    Sec-Fetch-Dest: document
    Accept-Encoding: gzip, deflate, br
    Accept-Language: zh-CN,zh;q=0.9
    Cookie: _ga=GA1.1.1196342184.1629275253; _gid=GA1.1.2046123892.1633932950
    mao: soul
    打印请求体-------------------end
    打印请求体-------------------begin
    GET /favicon.ico HTTP/1.1
    Host: localhost:8808
    Connection: keep-alive
    Pragma: no-cache
    Cache-Control: no-cache
    sec-ch-ua: "Google Chrome";v="93", " Not;A Brand";v="99", "Chromium";v="93"
    sec-ch-ua-mobile: ?0
    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36
    sec-ch-ua-platform: "Windows"
    Accept: image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8
    Sec-Fetch-Site: same-origin
    Sec-Fetch-Mode: no-cors
    Sec-Fetch-Dest: image
    Referer: http://localhost:8808/test
    Accept-Encoding: gzip, deflate, br
    Accept-Language: zh-CN,zh;q=0.9
    Cookie: _ga=GA1.1.1196342184.1629275253; _gid=GA1.1.2046123892.1633932950
    mao: soul
    打印请求体-------------------end

### 作业4（选做）实现路由。


## week02作业

### 作业1 （选做）

[作业1](02nio/作业1.md)

### 作业2 （选做）

[作业2](02nio/作业2.md)

### 作业4 （必做）

[作业4](02nio/作业4.md)

### 作业6 （必做）写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub

[HttpClientHelper.java](02nio/src/main/java/client/HttpClientHelper.java)

运行结果

    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
    Executing request GET http://127.0.0.1:8801/
    ----------------------------------------
    hello,nio1


## week01作业

### 作业2 （必做）

[XlassLoader.java](01jvm/src/XlassLoader.java)

### 作业3 （必做）

[jvm内存参数.png](01jvm/jvm内存参数.png)