package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.entity.User;

public class UserDao {
	public static boolean addUser(User u){
		Connection con = BaseDao.getCon();
		String sql = "insert into userstate(id,name,password) values(user_seq.nextval,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPwd());
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}finally{
			BaseDao.closeCon(con, ps);
		}
	}
	

	public static void freeze(String username){
		Connection con = BaseDao.getCon();
		String sql = "update userstate set state=1 where name=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	public static void free(String username){
		Connection con = BaseDao.getCon();
		String sql = "update userstate set state=0 where name=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
	public static boolean checkUserName(String username){
		Connection con = BaseDao.getCon();
		String sql = "select id from userstate where name=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			if(ps.executeQuery().next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
