package nio.wjchenge.netty.gateway.v2.service;

import com.sun.deploy.security.BrowserKeystore;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程的socket程序
public class HttpServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                // 打印请求信息
                printRequestMsg(socket);
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printRequestMsg(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        String msg;
        System.out.println("打印请求体-------------------begin");
        while ((msg = bufferedReader.readLine()) != null) {
            if (msg.length() == 0) break;
            System.out.println(msg);
        }
        System.out.println("打印请求体-------------------end");
    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio1";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}