# JavaCourseCodes
java进阶训练营作业

## week04作业

### 作业2 （必做）思考有多少种方式，在main函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？

-  [不修改运行方法拿到运行结果](04concurrency/src/main/java/Homework.java)

1. 使用 sleep 等待线程执行完成拿到结果
2. 使用 join 等待线程执行完成拿到结果
3. 使用 自旋机制 拿到结果
4. 使用 Future 拿到结果
5. 使用 阻塞队列 拿到结果

-  [修改运行方法拿到运行结果](04concurrency/src/main/java/Homework.java)

1. 使用 sleep 等待线程执行完成拿到结果
2. 使用 join 等待线程执行完成拿到结果
3. 使用 自旋机制 拿到结果
4. 使用 Future 拿到结果
5. 使用 阻塞队列 拿到结果

### 作业4（必做）把多线程和并发相关知识梳理一遍，画一个脑图，截图上传到 GitHub 上

[多线程和并发](04concurrency/src/main/java/多线程和并发.png)


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

[实现路由版本](03nio/src/main/java/nio/wjchenge/netty/gateway/v3)

大体思路利用Java SPI扩展机制进行过滤器的扩展实现，与过滤器实现细节唯一不同的地方在于如果`不配置路由规则默认使用随机路由规则`，

如果`配置多个路由规则则使用系统最先读取到的规则`为准

#### 1、定义路由接口规范
[HttpEndpointRouter](03nio/src/main/java/nio/wjchenge/netty/gateway/v3/router/HttpEndpointRouter.java)

#### 2、路由具体扩展实现
目前实现了随机算法、轮询算法、随机权重算法路由规则

#### 3、扩展类加载器
[ExtensionLoader](03nio/src/main/java/nio/wjchenge/netty/gateway/v3/extension/ExtensionLoader.java)

#### 4、特定配置文件
[META-INF/services/nio.wjchenge.netty.gateway.v3.router.HttpEndpointRouter](03nio/src/main/resources/META-INF/services/nio.wjchenge.netty.gateway.v3.router.HttpEndpointRouter)


#### 随机路由算法

**实现思路**

先生成随机数,然后根据随机数下标取集合的值

[RandomHttpEndpointRouter](03nio/src/main/java/nio/wjchenge/netty/gateway/v3/router/RandomHttpEndpointRouter.java)

#### 轮询路由算法

**实现思路**

按顺序循环取集合的值

[RoundRibbonHttpEndpointRouter](03nio/src/main/java/nio/wjchenge/netty/gateway/v3/router/RoundRibbonHttpEndpointRouter.java)

#### 随机权重路由算法

**实现思路**

方案1：根据服务配置的权重进行服务集合重新赋值，配置多少权重集合中就存在多少条记录。该方案实现简单，但如果权重配置过大则比较耗费内存。

方案2：假设我们有一组服务[A, B, C], 他们对应的权重为[20, 30, 50], 权重总和为100。现在把这些权重值平铺在一维坐标上，分布情况[0, 20)  
属于服务A, [20, 50) 属于服务B, [50, 100) 属于服务C, 然后生成 [0, 100) 范围的随机数，接下来计算该随机数属于哪个区间。

方案2实现：[WeightRandomHttpEndpointRouter](03nio/src/main/java/nio/wjchenge/netty/gateway/v3/router/WeightRandomHttpEndpointRouter.java)


####各路由算法测试结果（`测试10次，每次模拟调用服务10000次`）如下：

- 随机路由算法

```
{server3=5377, server2=1839, server1=2784}
{server2=4483, server1=5517}
{server3=5503, server2=4497}
{server3=4176, server1=5824}
{server2=2809, server1=7191}
{server2=8429, server1=1571}
{server3=8889, server1=1111}
{server3=3465, server2=3509, server1=3026}
{server1=10000}
{server3=6027, server2=3598, server1=375}
```

- 轮询路由算法

```
{server3=3334, server2=3333, server1=3333}
{server3=3333, server2=3334, server1=3333}
{server3=3333, server2=3333, server1=3334}
{server3=3334, server2=3333, server1=3333}
{server3=3333, server2=3334, server1=3333}
{server3=3333, server2=3333, server1=3334}
{server3=3334, server2=3333, server1=3333}
{server3=3333, server2=3334, server1=3333}
{server3=3333, server2=3333, server1=3334}
{server3=3334, server2=3333, server1=3333}
```
- 随机权重路由算法

```
{server3=4951, server2=3120, server1=1929}
{server3=5029, server2=3028, server1=1943}
{server3=5128, server2=2915, server1=1957}
{server3=4935, server2=3093, server1=1972}
{server3=5069, server2=3003, server1=1928}
{server3=5076, server2=3016, server1=1908}
{server3=4975, server2=3090, server1=1935}
{server3=5167, server2=2937, server1=1896}
{server3=5038, server2=3051, server1=1911}
{server3=5072, server2=3038, server1=1890}
```

---
---


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


---
---

## week01作业

### 作业2 （必做）

[XlassLoader.java](01jvm/src/XlassLoader.java)

### 作业3 （必做）

[jvm内存参数.png](01jvm/jvm内存参数.png)