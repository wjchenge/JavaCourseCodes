package nio.wjchenge.netty.gateway.v3.inbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.Map;

public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {

	private Map<String, Integer> proxyServerUrlMap;

	public HttpInboundInitializer(Map<String, Integer> proxyServerUrlMap) {
		this.proxyServerUrlMap = proxyServerUrlMap;
	}

    @Override
	public void initChannel(SocketChannel ch) {
		ChannelPipeline p = ch.pipeline();
		p.addLast(new HttpServerCodec());
		//p.addLast(new HttpServerExpectContinueHandler());
		p.addLast(new HttpObjectAggregator(1024 * 1024));
		p.addLast(new HttpInboundHandler(this.proxyServerUrlMap));
	}
}
