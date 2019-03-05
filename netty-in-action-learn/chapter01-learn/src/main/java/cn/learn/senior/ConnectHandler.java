package cn.learn.senior;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty-in-action-learn-cn.learn.senior
 * <p>Discription:[]</p >
 * Created on 2019/3/5 15:41
 * @author [Fly365]
 */
//被回调触发的ChannelHandler
public class ConnectHandler extends ChannelInboundHandlerAdapter {


    @Override
    // 当一个新的连接建立时，channelActive(ChannelHandlerContext)将会被调用
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("client " + ctx.channel() .remoteAddress() + " connected!");
    }
}
