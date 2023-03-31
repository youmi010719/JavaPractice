package com.httpserver.two;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
/**
 * {@code @description:} 使用socket 实现 web服务器 --- 具体执行读写操作的。<br>
 * 	fix: 1、换行符写错误："/r/n" 调整为正确： "\r\n"。 <br>
 * 		 2、"HTTP /1.1 200 ok" 中,"HTTP"和"/1.1" 直接不能有空格，否则 Firefox无法解析。<br>
 * {@code @version:v1.1}
 * {@code @author:w}
 * {@code @date：2018年12月18日} 16:50:28
 */
public class HttpServerFix extends Thread {
    /**
     * web资源根路径
     */
    public static final String ROOT = "E:\\Code_File\\JAVA_CODE\\JavaPractice\\JavaWeb\\src\\html";

    /**
     * 输入流对象,读取浏览器请求
     */
    private InputStream input;

    /**
     * 输出流对象，响应内容给浏览器
     */
    private OutputStream out;

    /**
     * {@code @description:初始化socket对象,获取对应} 输入，输出流
     * @param socket
     */
    public HttpServerFix(Socket socket) {
        try {
            input = socket.getInputStream();
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 多线程方法调用
     */
    @Override
    public void run() {
        String filePath = read();
        response(filePath);
    }

    /**
     * {@code @description:} 读取资源文件，响应给浏览器。
     * {@code @param:@param} filePath
     *                   资源文件路径
     * {@code @return:void}
     * {@code @version:v1.0}
     * {@code @author:w}
     * {@code @date:2018年6月6日} 上午11:42:37
     *
     */
    private void response(String filePath) {
        File file = new File(ROOT + filePath);
        if (file.exists()) {
            // 1、资源存在，读取资源
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println("line:"+ line);
                    sb.append(line).append("\r\n");
                }
                StringBuffer result = new StringBuffer();
                /**
                 *
                 * 1、 换行符"/r/n"写错了，正确的是： "\r\n"
                 * 2、"HTTP /1.1 ..."之间不能有空格,否则Firfox不能解析
                 * 3、 关于换行符的补充：
                 * 	  a.windows:"\r\n"
                 *    b.linux:"\n"
                 *    c.mac:"\r"
                 **/
                //	result.append("HTTP /1.1 200 ok /r/n");
                result.append("HTTP/1.1 200 ok \r\n");
                result.append("Content-Language:zh-CN \r\n");
                // charset=UTF-8 解决中文乱码问题
                result.append("Content-Type:text/html;charset=UTF-8 \r\n").append("Content-Length:").append(file.length()).append("\r\n");
                result.append("\r\n").append(sb.toString());
                out.write(result.toString().getBytes());
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // 2、资源不存在，提示 file not found
            StringBuffer error = new StringBuffer();
            error.append("HTTP/1.1 400 file not found \r\n");
            error.append("Content-Type:text/html \r\n");
            error.append("Content-Length:20 \r\n").append("\r\n");
            error.append("<h1 >File Not Found..</h1>");
            try {
                out.write(error.toString().getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     *
     * {@code @description:解析资源文件路径}
     * {@code @example:} GET /index.html HTTP/1.1
     * {@code @param:@return}
     * {@code @return:String}
     * {@code @version:v1.0}
     * {@code @author:w}
     * {@code @date:2018年6月6日} 上午11:39:42
     *
     */
    private String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            // 读取请求头， 如：GET /index.html HTTP/1.1
            String readLine = reader.readLine();
            String[] split = readLine.split(" ");
            if (split.length != 3) {
                return null;
            }
            System.out.println(readLine);
            return split[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}