package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * UDPЭ��   �������ݱ���   ��������û�н��յ������ɿ��Ĵ��䣬ֻ�ܷ���ȥ����
 * @author Admin
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		byte b[] = new byte[1024];
		String msg = "�����";
		b = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(b, b.length, 
				InetAddress.getByName("192.168.191.3"), 8000); //��ʾ�������ݵĶ˿ںţ����Ҫ�������������˿ں�Ϊ8000
		DatagramSocket socket = new DatagramSocket(5000);     //��ʾ���ն˿ں�Ϊ5000�����ݱ�
		socket.send(dp);
		System.out.println("���ݷ��ͳɹ�");
	}

}
