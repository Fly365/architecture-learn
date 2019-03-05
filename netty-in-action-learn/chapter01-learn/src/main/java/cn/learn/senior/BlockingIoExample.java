package cn.learn.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * netty-in-action-learn-cn.learn.senior
 * <p>Discription:[阻塞iO]</p >
 * Created on 2019/3/4 16:06
 * @author [Fly365]
 * @version 1.1
 */
public class BlockingIoExample {

    public void server(int portNum) throws IOException {
        // 创建 serverSocket，用以监听指定端口上的连接请求
        ServerSocket serverSocket = new ServerSocket(portNum);
        //对 accept()方法调用将被阻塞，直到一个连接建立
        Socket clientSocket = serverSocket.accept();
        // 流对象都派生于该套接字的流对象
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        String request,response;
        // readLine()方法将会阻塞，直到由换行符或回车符结尾的字符串被读取
        while ((request = in.readLine()) != null){
            if("exit".equals(request)){
                break;
            }
            response = processRequest(request);
            // 服务器响应发送给客户端
            out.println(response);
        }

    }

    private String processRequest(String request){
        return "processed";
    }
}
