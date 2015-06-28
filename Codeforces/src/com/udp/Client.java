package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收UDP发过来的数据报
 * @author Admin
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8000);      //接收端口号为8000的数据报
		byte b[] = new byte[1024];
		DatagramPacket p = new DatagramPacket(b, b.length);
		System.out.println("客户端正在等待...");
		socket.receive(p);      //程序在这会阻塞，直到收到数据报
		System.out.println(new String(p.getData(), 0, p.getLength()));
	}

}
