package com.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.chat.Client;
import com.chat.Login;

public class ClientListener extends Thread {
	private Socket s;
	private String username;
	public ClientListener(Socket s,String username){
		this.s = s;
		this.username = username;
	}
	@Override
	public void run() {
		String str;
		Client k = Login.cmap.get(username);
		JTextArea text = k.getText1();
		JList list = k.getList();		
		BufferedReader br= null;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while((str=br.readLine())!=null){
				if(str.startsWith("@UserList:")){       //������û��б���				
					String []user = str.substring(10).split(";");
					list.setListData(user);
					Client.Userlist = user;
				}else if(str.startsWith("@null")){
					text.append("�Բ�����ʧ�ܣ��Է����߻򲻴���\n");
				}else if(str.startsWith("$close")){
					JOptionPane.showMessageDialog(null,"�������رգ����򼴽��˳�");
					k.dispose();
					return ;
				}
				else{
					System.out.println(str);
					text.append(str+"\n");             //�����content�Ĺ�������JTextArea��					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
