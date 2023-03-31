package webserver.com;

import java.io.*;
import java.net.*;

public class webclient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------客户端--------");
        Socket server=new Socket("127.0.0.1",111);   //建立连接
        //获得输入输出流
        InputStream is= server.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader in=new BufferedReader(isr);
        OutputStream os=server.getOutputStream();
        PrintStream out=new PrintStream(os);

        InputStreamReader sysin=new InputStreamReader(System.in);
        BufferedReader wt=new BufferedReader(sysin);

        while (true){
            String str=wt.readLine();
            out.println(str);
            out.flush();               //获得服务端响应的信息，强制输出
            if (str.equals("end")) break;   //输入end结束连接
            System.out.println(in.readLine());
        }
        server.close();
    }
}