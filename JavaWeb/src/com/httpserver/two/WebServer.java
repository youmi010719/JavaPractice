package com.httpserver.two;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @description: 使用socket 自己写一个web服务器 ---监听端口，获取socket 对象。
 * @version:v1.0
 * @author:w
 * @date：2018年6月6日上午11:03:36
 *
 */
public class WebServer {
    public void startServer(int port){
        try {
            @SuppressWarnings("resource")
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                new HttpServerFix(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}