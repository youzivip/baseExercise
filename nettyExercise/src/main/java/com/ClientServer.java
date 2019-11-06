package com;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;

import java.net.InetSocketAddress;

/**
 * 使用Netty向Baidu请求下可以吗
 */
public class ClientServer {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        //第1步 定义线程组，处理读写和链接事件，没有了accept事件
        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group ).option(ChannelOption.SO_TIMEOUT, 500);
        //第2步 绑定客户端通道
        bootstrap.channel(NioSocketChannel.class);
        //第3步 给NIoSocketChannel初始化handler， 处理读写事件
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
            @Override
            protected void initChannel(NioSocketChannel channel) throws Exception {
                //字符串编码器，一定要加在SimpleClientHandler 的上面
//                ch.pipeline().addLast(new StringEncoder());
//                ch.pipeline().addLast(new DelimiterBasedFrameDecoder(
//                        Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
//                //找到他的管道 增加他的handler
//                ch.pipeline().addLast(new SimpleClientHandler());
                //包含编码器和解码器
                channel.pipeline().addLast(new HttpClientCodec());
                //聚合
                channel.pipeline().addLast(new HttpObjectAggregator(1024 * 10 * 1024));
                //解压
                channel.pipeline().addLast(new HttpContentDecompressor());
                channel.pipeline().addLast(new SimpleClientHandler());
            }
        });

        //连接服务器
//        ChannelFuture future = bootstrap.connect("localhost", 8080).sync();
        ChannelFuture future = bootstrap.connect(new InetSocketAddress("http://bizapi.jd.local/api/product/getDetail",80)).sync();

        //当通道关闭了，就继续往下走
        future.channel().closeFuture().sync();



    }
}
