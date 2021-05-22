package xilalu.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 表示channel处于就绪状态.
     *
     * @param ctx
     */
    public void channelActive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端 " + channel.remoteAddress() + " 上线了 " + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
        System.out.println("客户端 " + channel.remoteAddress() + " 上线了 ");
    }

    /**
     * 表示channel处于不活动状态.
     *
     * @param ctx
     */
    public void channelInactive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(String.format("客户端 " + channel.remoteAddress() + " 下线了 " + sdf.format(new Date()) + "\n"));
        System.out.println("客户端 " + channel.remoteAddress() + " 下线了");
        System.out.println("在线用户数 " + channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(v -> {
            if (v != channel) {
                v.writeAndFlush("客户端 " + v.remoteAddress() + " 发送了消息 " + msg + "\n");
            } else {
                v.writeAndFlush("自己 " + v.remoteAddress() + " 发送了消息 " + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}