# JavaCourseCodes
java进阶训练营作业


## week08作业

### 作业2.（必做）设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github

1. 根据 `id % 2` 规则分库, 根据 `user_id % 16` 规则分表
2. [多数据源配置文件](08shardingsphere/src/main/resources/application-homework2.properties)
3. [数据库初始脚本](08shardingsphere/src/main/resources/homework2-init.sql)
4. [测试类](08shardingsphere/src/test/java/com/wjchenge/HomeWork2.java)

### 作业6.（必做）基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一），提交到 Github。

基于 ShardingSphere 的 Atomikos XA 实现的demo

1. [事务管理器配置](08shardingsphere/src/main/java/com/wjchenge/TransactionConfiguration.java)
2. [多数据配置文件](08shardingsphere/src/main/resources/application-homework6.properties)
3. [测试类](08shardingsphere/src/test/java/com/wjchenge/HomeWork6.java)

测试总结:
1. 使用 shardingsphere 版本 `5.0.0` 和 `5.0.alpha` 测试返回 TransactionType 为 `LOCAL`, 但测试提交成功\失败数据库数据符合预期
2. 使用 shardingsphere 版本 `5.0.beta` 测试返回 TransactionType 为 `XA`, 数据库数据结果符合预期
3. 使用 shardingsphere 版本 `5.0.0` 和 `5.0.alpha` 使用事务注解类 `ShardingSphereTransactionType`
4. 使用 shardingsphere 版本 `5.0.beta`             使用事务注解类 `ShardingTransactionType`

---
---

## week07作业

### 作业2.（必做）按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率

1. 使用 PreparedStatement 逐条提交插入
2. 使用 PreparedStatement 批量提交插入
3. 使用 PreparedStatement 分批次批量提交(`每次提交10000条`)插入
4. 使用 PreparedStatement 多线程批量提交插入(`使用最大线程数为16的线程池,每个线程操作5000条数据`)
5. 使用 PreparedStatement 拼接为1条sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...)
6. 使用 PreparedStatement 多线程拼接sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...) (`使用最大线程数为16的线程池,每个线程操作5000条数据`)
7. 使用 PreparedStatement 使用`数据库线程池`多线程拼接sql语句插入,(INSERT INTO TABLE () VALUES (),(),()...) (`使用最大线程数为16的线程池,每个线程操作5000条数据`)

####执行效率如下:


|  方式   | 执行时间  |
|  :----  | ----:  |
| 1  | 2124064 ms |
| 2  | 2030671 ms |
| 3  | 1979680 ms |
| 4  |  167804 ms |
| 5  |    12190ms |
| 6  |     7556ms |
| 7  |     5009ms |

### 作业9.（必做）读写分离 - 动态切换数据源版本 1.0

[作业9](07db/src/main/java/com/wjchenge/homework9) 实现思路如下:
1. [数据源上下文枚举类](07db/src/main/java/com/wjchenge/homework9/DataSource.java)
2. [数据源上下文持有者](07db/src/main/java/com/wjchenge/homework9/DataSourceContextHolder.java)
3. [数据源路由](07db/src/main/java/com/wjchenge/homework9/MyRoutingDataSource.java)
4. [配置类](07db/src/main/java/com/wjchenge/homework9/RoutingConfiguration.java)
5. [多数据源配置文件](07db/src/main/resources/application.properties)
6. [数据库初始脚本](07db/src/main/resources/init.sql)
7. [测试类](07db/src/test/java/com/wjchenge/ApplicationTests.java)

### 作业10.（必做）读写分离 - 数据库框架版本 2.0

[作业10](07shardingsphere) 实现思路如下:

根据`name`字段插入的内容,如果内容为`master`插入`master`库, 内容为`slave`插入`slave`库

1. [多数据源配置文件](07shardingsphere/src/main/resources/application.properties)
2. [数据库初始脚本](07db/src/main/resources/init.sql)
3. [测试类](07shardingsphere/src/test/java/com/wjchenge/shardingsphere/ApplicationTests.java)



---
---

## week06作业

### 作业6.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。

[init.sql](06db/init.sql)

---
---

## week05作业

### 作业2.（必做）写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）, 提交到 GitHub。

1. 使用 xml 装配Bean
2. 使用注解 @Component 和 @Autowired 装配Bean
3. 使用注解 @Bean 和 @Autowired 装配Bean

### 作业8.（必做）给前面课程提供的 Student/Klass/School 实现自动配置和 Starter。

[自定义Starter](05customer-starter) 两个主要类:

1. [CustomerProperties](05customer-starter/src/main/java/com/wjchenge/customerstarter/properties/CustomerProperties.java)
解析`customer`开头的配置文件属性
2. [AutoConfiguration](05customer-starter/src/main/java/com/wjchenge/customerstarter/auto/AutoConfiguration.java)
自动装配类触发条件:配置文件包含:`customer.id`
3. [spring.factories](05customer-starter/src/main/resources/META-INF/spring.factories)
Spring Boot 启动扫描需要自动装配的文件配置

[测试类](05spring/src/test/java/com/wjchenge/ApplicationTests.java)运行效果: `Class1 have 1 students and one is Student(id=1000, name=KK102)`


### 作业10.（必做）研究一下 JDBC 接口和数据库连接池，掌握它们的设计和用法：

[init.sql](05spring/src/main/java/com/wjchenge/homework10/init.sql)

1）使用 JDBC 原生接口，实现数据库的增删改查操作。 

[JDBCDemo1](05spring/src/main/java/com/wjchenge/homework10/JDBCDemo1.java)

2）使用事务，PrepareStatement 方式，批处理方式，改进上述操作。  
[JDBCDemo2](05spring/src/main/java/com/wjchenge/homework10/JDBCDemo2.java)

3）配置 Hikari 连接池，改进上述操作。提交代码到 GitHub。  

[JDBCDemo3](05spring/src/main/java/com/wjchenge/homework10/JDBCDemo3.java)

1. 添加依赖:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

2. 配置连接池:[application.properties](05spring/src/main/resources/application.properties)
```
spring.datasource.type=com.zaxxer.hikari.HikariDataSource
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/wjchenge_test?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
spring.datasource.hikari.username=root
spring.datasource.hikari.password=root
```

---
---

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