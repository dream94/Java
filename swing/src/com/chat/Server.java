package com.chat;
		
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import oracle.net.aso.g;

import com.thread.SendUser;
import com.thread.ServerListener;

public class Server extends Thread{
	public static HashMap<String,Socket> map = new HashMap<String,Socket>();
	
	public static boolean flag = true;

	@Override
	public void run() {
		ServerSocket server = null;
		Socket s = null;
		try {
			server = new ServerSocket(10086);
			JOptionPane.showMessageDialog(null, "服务器启动成功");
			flag = true;
			while(flag){			
				s = server.accept();
				new ServerListener(s).start();
				new SendUser(s).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {	 
				Iterator iter = map.keySet().iterator();
				while(iter.hasNext()){
					String name = (String)iter.next();
					System.out.println("关闭"+name);
					Socket g = map.get(name);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(g.getOutputStream()));
					bw.write("$close");
					bw.newLine();
					bw.flush();
					iter.remove();           //注意这里要先移除，然后再关
					g.close();
				}
				server.close();	
				System.out.println("服务器关闭");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
