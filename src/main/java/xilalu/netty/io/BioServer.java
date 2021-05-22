package xilalu.netty.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lds
 * @date 2021/5/20 23:12
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            System.out.println("等待客户端连接...");
            Socket accept = socket.accept();
            System.out.println("客户端连接成功...");
            handler(accept);
        }
    }

    public static void handler(Socket socket) throws IOException {
        System.out.println("线程id:" + Thread.currentThread().getId());
        byte[] bytes = new byte[1024];
        System.out.println("服务器准备从客户端读取数据...");
        int read = socket.getInputStream().read(bytes);
        if (read != -1) {
            System.out.println("读取到的客户端数据:" + new String(bytes, 0, read));
        }
        System.out.println("服务器从客户端读取数据结束...");

        System.out.println("服务器准备往客户端写数据...");
        socket.getOutputStream().write("Hellow World".getBytes());
        socket.getOutputStream().flush();
        System.out.println("服务器往客户端写数据结束...");
    }
}
