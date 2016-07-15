package com.itatest.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

public class SocketHttpServer implements Runnable{
	private final static int PORT = 8889;
  private ServerSocket server = null;
  public static void main(String[] args) {
    new SocketHttpServer();
  }
  public SocketHttpServer() {
    try {
      server = new ServerSocket(PORT);
      if (server == null)
        System.exit(1);
      new Thread(this).start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void run() {
    while (true) {
      try {
        Socket client = null;
        client = server.accept();
        if (client != null) {
          try {
            System.out.println("连接服务器成功！！...");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            OutputStream out = client.getOutputStream();
            out.write("HTTP/1.0 200 OK\r\n".getBytes());
    				out.write("Content-Type:text/html;charset=utf8\r\n".getBytes());
    				out.write("\r\n".getBytes());
            // GET /test.jpg /HTTP1.1
            
            InputStream in = new FileInputStream("server.html");
            byte[] bs = new byte[in.available()];
    				in.read(bs);
    				out.write(bs);
    				
            String line = reader.readLine();
            System.out.println("line: " + line);
            
            if(line.contains("=")){
    					String key = line.split("=")[1].split(" ")[0];
//    					System.out.println(key);
    					if("start".equals(key)){
    						Server.main(null);
    					}
    				}
    				
    				
//    				String resource = line.substring(line.indexOf('/'),
//    				    line.lastIndexOf('/') - 5);
//    				  System.out.println("the resource you request is: "
//    				    + resource);
//    				  resource = URLDecoder.decode(resource, "UTF-8");
    				out.close();
    				client.close();
    				in.close();
//            String resource = line.substring(line.indexOf('/'),
//                line.lastIndexOf('/') - 5);
//
//            System.out.println("==========="+resource);
//            closeSocket(client);
          continue;

          } catch (Exception e) {
            System.out.println("HTTP服务器错误:"
                + e.getLocalizedMessage());
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  private void closeSocket(Socket socket) {
    try {
      socket.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    System.out.println(socket + "离开了HTTP服务器");
  }
  
  private void transferFileHandle(String path, Socket client) {
    File fileToSend = new File(path);
    if (fileToSend.exists() && !fileToSend.isDirectory()) {
      try {
        PrintStream writer = new PrintStream(client.getOutputStream());
        writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
        writer.println("Content-Type:application/binary");
        writer.println("Content-Length:" + fileToSend.length());// 返回内容字节数
        writer.println();// 根据 HTTP 协议, 空行将结束头信息

        FileInputStream fis = new FileInputStream(fileToSend);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        writer.write(buf);
        writer.close();
        fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
