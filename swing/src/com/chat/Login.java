package com.chat;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.BaseDao;
import com.entity.User;
import com.thread.Freeze;

public class Login extends JFrame {
	public static HashMap<String,Client> cmap = new HashMap<String,Client>();
	public static HashMap<String,Integer> loginuser = new HashMap<String,Integer>();
	private JPanel contentPane;
	private JLabel l1,l2,l3;
	private JTextField name;
	private JPasswordField pwd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		l1 = new JLabel("�û���¼");
		l1.setFont(new Font("΢���ź�", Font.PLAIN, 17));
		l1.setBounds(164, 21, 81, 20);
		contentPane.add(l1);
		
		l2 = new JLabel("�û���:");
		l2.setLocation(101, 73);
		l2.setSize(52, 20);
		contentPane.add(l2);
		l3 = new JLabel("\u5BC6 \u7801:");
		l3.setLocation(101, 118);
		l3.setSize(52, 20);
		contentPane.add(l3);
		
		name = new JTextField();
		name.setBounds(183, 73, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBounds(183, 118, 96, 21);
		contentPane.add(pwd);
		
		JButton b1 = new JButton("\u767B\u5F55");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = name.getText();
				String password = pwd.getText();
				if(check(new User(username,password))){
					Client k = new Client(username);
					skip();   //�ͷ���Դ
				}
			}
		});
		b1.setBounds(83, 185, 93, 23);
		contentPane.add(b1);
		
		JButton b2 = new JButton("\u6CE8\u518C");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reg().setVisible(true);
				skip();
			}
		});
		b2.setBounds(239, 185, 93, 23);
		contentPane.add(b2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);        //������ʾ
	}
	
	public boolean check(User user){   
		Connection con = BaseDao.getCon();
		String sql = "select id from userstate where name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name = user.getName();
		String pwd = user.getPwd();
		if(name.equals("")||pwd.equals("")){
			JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��!!!");
			return false;
		}
		int time;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				sql = "select state from userstate where name=? and password=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pwd);
				rs = ps.executeQuery();
				if(rs.next()){
					int state = rs.getInt(1);    //0��ʾδ��¼   1��ʾ�˺Ŷ���  2��ʾ�˺��ѵ�¼
					if(state==0){         
						if(loginuser.containsKey(name)){
							loginuser.remove(name);
						}
						return true;
					}else if(state==1){
						JOptionPane.showMessageDialog(null, "�˺ű�����");
					}else {
						JOptionPane.showMessageDialog(null, "�˺��ѵ�¼");
					}									
				}else{
					if(loginuser.containsKey(name)){
						time = loginuser.get(name);
					}else{
						time = 0;
					}
					time++;
					if(time==5){
						JOptionPane.showMessageDialog(null, "�˺ű�����,���30��");
						new Freeze(name).start();     //�����߳�
					}else if(time<5){
						JOptionPane.showMessageDialog(null, "�����������,��ʣ"+(5-time)+"��");		
					}else{
						JOptionPane.showMessageDialog(null, "�˺Ŷ�����");
					}
					loginuser.put(name, time);
				}
				
			}else{
				JOptionPane.showMessageDialog(null, "�û�������");
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			BaseDao.closeCon(con, ps, rs);
		}
		return false;
	}
	
	
	public void skip(){
		this.dispose();
	}
	
	
}
