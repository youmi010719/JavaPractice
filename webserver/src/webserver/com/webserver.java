package webserver.com;

import java.io.*;
import java.net.*;

public class webserver{
    private static final int BUFFER_SIZE = 1024;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("--------服务端--------");
        ServerSocket server=new ServerSocket(111);  //服务端对象
        Socket client=server.accept();           //服务端等待监听，有请求时会返回一个客户端socket对象
        //建立输入输出流
        InputStream  is= client.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader in=new BufferedReader(isr);
        OutputStream os=client.getOutputStream();
        PrintStream out=new PrintStream(os);

        InputStreamReader sysin=new InputStreamReader(System.in);
        BufferedReader wt=new BufferedReader(sysin);
        //获取会话
        while (true){
            String str =in.readLine();
            out.println("Server received "+str);  //在client输入收到信息
            out.flush();         //flush强制刷新，输入out缓冲区内容
            if (str.equals("end")) break;   //若client输出end，结束连接

            if (str.startsWith("GET") || str.startsWith("POST")) {            //如果是这两种请求方式表示成功
                String[] str1 = str.split(" ");
                String filepath = "E:\\Code_File\\JAVA_CODE\\JavaPractice\\webserver\\src\\webserver\\com\\" + str1[1];           //获得请求的文件名或者url,存储在str1[1]中
                File f1 = new File(filepath);
                if (f1.exists()) {
                    System.out.println("yep");
                    byte[] bytes = new byte[BUFFER_SIZE];
                    FileInputStream fis = new FileInputStream(f1);
                    ServerSocket serverSocket = new ServerSocket(80);     //启动80端口用于传输HTTP报文
                    Socket client1 = serverSocket.accept();
                    OutputStream clientOutStream = client1.getOutputStream();

                    int ch = fis.read(bytes, 0, BUFFER_SIZE);
                    while (ch != -1) {                                    //read（）返回-1表示结束
                        clientOutStream.write(bytes, 0, ch);
                        ch = fis.read(bytes, 0, BUFFER_SIZE);
                    }
                    //不构建HTTP响应报文，直接调用浏览器打开请求文件
                    /*Runtime rTime = Runtime.getRuntime();
                    String url = filepath;
                    String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
                    Process pc = rTime.exec(browser + url);
                    pc.waitFor();*/
                    clientOutStream.flush();
                    clientOutStream.close();
                    client1.close();
                    serverSocket.close();

                } else {
                    System.out.println("no");
                    ServerSocket serverSocket = new ServerSocket(80);
                    Socket client2 = serverSocket.accept();
                    OutputStream clientOutStream = client2.getOutputStream();
                    clientOutStream.write(                  //另外一种方式构造404NotFound，也可以使用notfound.html
                            ("HTTP/1.1 200\n"
                                    + "Content-Type: text/html\n"
                                    + "\n"
                                    + "<h1>404  Not Found </h1>").getBytes()
                    );
                    clientOutStream.flush();
                    clientOutStream.close();
                    client2.close();
                    serverSocket.close();
                }
            }
        }
        client.close();//关闭
        server.close();
    }
}
