package com.teachercode.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

	public static void main (String[] args) throws Exception{
		byte[] buf = "Hello".getBytes();
		InetAddress addr = InetAddress.getByAddress(new byte[]{127,0,0,1});
		DatagramPacket pakcet = new DatagramPacket(buf, 0,buf.length,addr,4445);

		DatagramSocket sk = new DatagramSocket();
		sk.send(pakcet);
		sk.close();
	}

}
