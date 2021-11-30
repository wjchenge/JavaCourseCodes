package io.kimmking.rpcfx.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wj
 * @Date 2021/11/23 11:00
 */
public class NettyClient {



    public static String send(final String url, final String msg) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            String tmpUrl = url.startsWith("http") ? url : "http://" + url;
            URI uri = new URI(tmpUrl);
            String host = uri.getHost() == null ? "127.0.0.1" : uri.getHost();
            int port = uri.getPort();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);

            ClientHandler handler = new ClientHandler(msg, uri, host, countDownLatch);

            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new HttpClientCodec(), handler);
                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            countDownLatch.await();
            f.channel().closeFuture().sync();
            return handler.getRespJson();
        } catch (InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
        return null;

    }

}
