package nio.wjchenge.netty.gateway.v3.inbound;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.java.Log;
import nio.wjchenge.netty.gateway.v3.extension.ExtensionLoader;
import nio.wjchenge.netty.gateway.v3.filter.HttpRequestFilter;
import nio.wjchenge.netty.gateway.v3.outbound.httpclient5.HttpClientHelper;
import nio.wjchenge.netty.gateway.v3.router.HttpEndpointRouter;
import nio.wjchenge.netty.gateway.v3.router.RandomHttpEndpointRouter;

import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Log
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Integer> proxyServerUrlMap;

    private List<HttpRequestFilter> httpRequestFilters;

    private HttpEndpointRouter httpEndpointRouter;

    public HttpInboundHandler(Map<String, Integer> proxyServerUrlMap) {
        this.proxyServerUrlMap = proxyServerUrlMap;
        this.httpRequestFilters = ExtensionLoader.getExtension(HttpRequestFilter.class);
        this.httpEndpointRouter = ExtensionLoader.getExtension(HttpEndpointRouter.class, new RandomHttpEndpointRouter());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            //logger.info("channelRead????????????????????????????????????{}", startTime);
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            // ?????????
            if (httpRequestFilters != null && !httpRequestFilters.isEmpty()) {
                httpRequestFilters.forEach(httpRequestFilter -> httpRequestFilter.filter(fullRequest, ctx));
            }
            // ??????????????????
            handlerTest(fullRequest, ctx);

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        FullHttpResponse response = null;
        String uri = fullRequest.uri();
        //logger.info("??????????????????url???{}", uri);
        try {
            // ??????????????????????????????????????????
            String proxyServerUrl = httpEndpointRouter.route(this.proxyServerUrlMap);
            // ?????????????????????httpclient??????okhttp???????????????url???????????????
            String value = HttpClientHelper.help(fullRequest.headers(), proxyServerUrl + uri);

//            httpGet ...  http://localhost:8801
//            ??????????????????"hello,nio";
//            value = reponse....

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());

        } catch (Exception e) {
            System.out.println("????????????:"+e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
                ctx.flush();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
