package com.teachercode.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

	public static void main (String[] args) throws Exception{
		
		byte[] buf = new byte[32];
		DatagramPacket p = new DatagramPacket(buf, 0,32);
		DatagramSocket sk = new DatagramSocket(4445);
		sk.receive(p);
		
		String s = new String(buf);
		System.out.println(s);

		
	}

}
