package com.thread;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Iterator;

import com.chat.Server;

public class SendUser extends Thread {
	private Socket s;
	public SendUser(Socket s){
		this.s = s;
	}
	@Override
	public void run() {
		BufferedWriter bw = null;
		String str;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			boolean flag = true;
			while(flag){
				Iterator iter = Server.map.keySet().iterator();
				str = "@UserList:全部人;";
				while(iter.hasNext()){
					String name = (String)iter.next();
					str += name+";";
				}
				str = str.substring(0, str.length()-1);
				bw.write(str);
				bw.newLine();
				bw.flush();
				Thread.sleep(5000);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("socket关闭");
			return ;
			
		}finally{
			try {
				bw.close();
				System.out.println("掉线的用户bw关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
