package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * UDP协议   发送数据报包   不管你有没有接收到，不可靠的传输，只管发过去而已
 * @author Admin
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		byte b[] = new byte[1024];
		String msg = "你好吗？";
		b = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(b, b.length, 
				InetAddress.getByName("192.168.191.3"), 8000); //表示发送数据的端口号，如果要接收这个数据则端口号为8000
		DatagramSocket socket = new DatagramSocket(5000);     //表示接收端口号为5000的数据报
		socket.send(dp);
		System.out.println("数据发送成功");
	}

}
