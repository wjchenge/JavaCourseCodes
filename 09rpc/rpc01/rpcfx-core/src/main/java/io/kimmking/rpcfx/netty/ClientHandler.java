package io.kimmking.rpcfx.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import okhttp3.MediaType;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wj
 * @Date 2021/11/23 11:16
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    private final String msg;

    private final URI uri;

    private final String host;

    private final CountDownLatch countDownLatch;

    private String respJson;

    public ClientHandler(String msg, URI uri, String host, CountDownLatch countDownLatch) {
        this.msg = msg;
        this.uri = uri;
        this.host = host;
        this.countDownLatch = countDownLatch;
    }

    public String getRespJson() {
        return respJson;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        sendHttpResponse(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof DefaultHttpContent) {
            DefaultHttpContent content = (DefaultHttpContent) msg;
            this.respJson = content.content().toString(CharsetUtil.UTF_8);
            countDownLatch.countDown();
        }
        ctx.close();

    }

    private void sendHttpResponse(ChannelHandlerContext ctx) {

        FullHttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_1, HttpMethod.POST, this.uri.getRawPath(), Unpooled.wrappedBuffer(this.msg.getBytes()));
        request.headers().set(HttpHeaderNames.CONTENT_TYPE, JSONTYPE);
        request.headers().set(HttpHeaderNames.HOST, this.host);
        request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
        request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
//        request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);

        ctx.channel().writeAndFlush(request);
    }
}
