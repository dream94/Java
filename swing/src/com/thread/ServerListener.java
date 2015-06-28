package com.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Iterator;

import com.chat.Server;

public class ServerListener extends Thread {
	private Socket s;
	public ServerListener(Socket s){
		this.s = s;
	}
	@Override
	public void run() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String user;
		boolean check = true;
		String str,name=null;
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));			
			try{
				user = br.readLine();
				if(user!=null){
					Server.map.put(user, s);
					System.out.println("服务器与"+user+"绑定");
				}
			}catch(Exception e){
				return ;
			}
			boolean flag = true;		
			while(flag){
				try{
				str = br.readLine();    //处理用户掉线情况
				}catch(Exception e){
					System.out.println(user+"掉线");
					Server.map.remove(user);
					return ;
				}
				if(str!=null){
					try{
						int k = str.indexOf(":");
						String getter = str.substring(0, k);
						String content = str.substring(k+1);
						Iterator iter = Server.map.keySet().iterator();
						check = true;
						/*while(iter.hasNext()){
							name = (String) iter.next();
							if(name.equals(getter)){
								Socket s1 = Server.map.get(name);
								bw = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
								bw.write(user+"对你说:"+content);
								bw.newLine();
								bw.flush();
								System.out.println(user+"对你说:"+content);
								check = false;					
								break;
							}
						}*/
						if(Server.map.containsKey(getter)){
							Socket s1 = Server.map.get(getter);
							bw = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
							bw.write(user+"对你说:"+content);
							bw.newLine();
							bw.flush();
							System.out.println(user+"对你说:"+content);
							check = false;					
						}
						if(check){           //表示转发给的用户不存在或下线了
							bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
							bw.write("@null");
							bw.newLine();
							bw.flush();
						}
					}catch(Exception e){      //表示传过来的内容有多行，对应上一个人
						if(!check){
							bw.write(str);
							bw.newLine();
							bw.flush();
						}
						
					}
					
				}						
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw=null;    //之前与之关联的其他账号的socket可能还没有下线，不能关闭
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
}
