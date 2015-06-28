package com.chat;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JList;
import javax.swing.JOptionPane;

import com.thread.ClientListener;

public class ClientCl {
	private Socket s;
	public void ClientMain(String username){
		try {
			s = new Socket("localhost",10086);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			bw.write(username);
			bw.newLine();
			bw.flush();
			System.out.println(Login.cmap.size());
			new ClientListener(s,username).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "服务器未开启，请联系相关负责人");
			Login.cmap.get(username).dispose();
		}
	}
	
	public void sendMsg(String getter,String content,String username){
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			String[] s1= Client.Userlist;
			if(getter.equals("全部人")){
				for(int t=1; t<s1.length; ++t){
					if(s1[t].equals(username)){
						continue;
					}
					bw.write(s1[t]+":"+content);
					bw.newLine();
					bw.flush();
				}			
			}else{
				bw.write(getter+":"+content);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"服务器关闭，请联系相关负责人后重启程序");
			Login.cmap.get(username).dispose();
		}
	}
	
}
