package xilalu.netty.io;

import java.io.IOException;
import java.net.Socket;

/**
 * @author lds
 * @date 2021/5/20 23:25
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        System.out.println("客户端往服务器写数据...");
        socket.getOutputStream().write("Hellow Server".getBytes());
        System.out.println("客户端往服务器写数据结束...");

        byte[] bytes = new byte[1024];
        System.out.println("客户端准备从服务器读数据...");
        int read = socket.getInputStream().read(bytes);
        if (read != -1) {
            System.out.println(new String(bytes, 0, read));
        }
        System.out.println("客户端从服务器读取数据结束...");
    }
}
