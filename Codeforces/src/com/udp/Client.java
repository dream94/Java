package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ����UDP�����������ݱ�
 * @author Admin
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8000);      //���ն˿ں�Ϊ8000�����ݱ�
		byte b[] = new byte[1024];
		DatagramPacket p = new DatagramPacket(b, b.length);
		System.out.println("�ͻ������ڵȴ�...");
		socket.receive(p);      //���������������ֱ���յ����ݱ�
		System.out.println(new String(p.getData(), 0, p.getLength()));
	}

}
