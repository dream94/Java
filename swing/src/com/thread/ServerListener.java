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
					System.out.println("��������"+user+"��");
				}
			}catch(Exception e){
				return ;
			}
			boolean flag = true;		
			while(flag){
				try{
				str = br.readLine();    //�����û��������
				}catch(Exception e){
					System.out.println(user+"����");
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
								bw.write(user+"����˵:"+content);
								bw.newLine();
								bw.flush();
								System.out.println(user+"����˵:"+content);
								check = false;					
								break;
							}
						}*/
						if(Server.map.containsKey(getter)){
							Socket s1 = Server.map.get(getter);
							bw = new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
							bw.write(user+"����˵:"+content);
							bw.newLine();
							bw.flush();
							System.out.println(user+"����˵:"+content);
							check = false;					
						}
						if(check){           //��ʾת�������û������ڻ�������
							bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
							bw.write("@null");
							bw.newLine();
							bw.flush();
						}
					}catch(Exception e){      //��ʾ�������������ж��У���Ӧ��һ����
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
					bw=null;    //֮ǰ��֮�����������˺ŵ�socket���ܻ�û�����ߣ����ܹر�
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
