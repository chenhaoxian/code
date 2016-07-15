package com.itatest.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8889);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
