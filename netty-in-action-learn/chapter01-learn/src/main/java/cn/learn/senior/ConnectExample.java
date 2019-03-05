package cn.learn.senior;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;


/**
 * netty-in-action-learn-cn.learn.senior
 * <p>Discription:[异步建立连接]</p >
 * Created on 2019/3/5 17:31
 * @author [Fly365]
 */
public class ConnectExample {

    private static final Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();

    public void connect(){
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        //异步连接远程节点
        ChannelFuture future = channel.connect(new InetSocketAddress("127.0.0.1", 25));
        //注册一个ChannelFutureListener，以便操作完成时获得通知
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                //检查channelFuture操作状态
                if(channelFuture.isSuccess()){
                    //如果操作成功，则创建一个 ByteBuf以持有数据
                    ByteBuf buffer = Unpooled.copiedBuffer("Hello", Charset.defaultCharset());
                    //将数据异步发送到远程节点，返回一个 ChannelFuture
                    ChannelFuture cf = future.channel().writeAndFlush(buffer);
                    // ...
                }else{
                    //如果发生错误，则访问描述错误原因的
                }
            }
        });
    }




}
