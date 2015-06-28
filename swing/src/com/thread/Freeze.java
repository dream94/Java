package com.thread;

import com.dao.UserDao;

public class Freeze extends Thread {
	private String username;
	public Freeze(String username){
		this.username = username;
	}
	
	@Override
	public void run() {
		UserDao.freeze(username);
		try{
			Thread.sleep(1000*30);
		}catch(Exception e){			
		}
		UserDao.free(username);
	}
}
