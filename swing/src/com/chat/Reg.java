package com.chat;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.UserDao;
import com.entity.User;

public class Reg extends JFrame {

	private JPanel contentPane;
	private JLabel l1,l2,l3;
	private JTextField name;
	private JPasswordField pwd;
	private JLabel lblNewLabel;
	private JPasswordField pwd1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
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
	public Reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		int x = this.getWidth();
		int y = this.getHeight();
		contentPane.setLayout(null);
		
		
		l1 = new JLabel("\u7528\u6237\u6CE8\u518C");
		l1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		l1.setBounds(164, 21, 81, 20);
		contentPane.add(l1);
		
		l2 = new JLabel("用户名:");
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
		pwd.setEchoChar('*');
		pwd.setBounds(183, 118, 96, 21);
		contentPane.add(pwd);
		
		JButton b2 = new JButton("\u63D0\u4EA4");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = name.getText();
				String password = pwd.getText();
				String password1 = pwd1.getText();				
				User user = new User(username, password);				
				if(username.equals("")||password.equals("")){
					JOptionPane.showMessageDialog(Reg.this, "用户名或密码不能为空");
				}else if(!password.equals(password1)){
					JOptionPane.showMessageDialog(Reg.this, "密码与确认密码不同");
				}
				else if(UserDao.checkUserName(username)){
					JOptionPane.showMessageDialog(Reg.this, "用户名已存在");
				}else{
					JOptionPane.showMessageDialog(Reg.this, "注册成功");
					UserDao.addUser(user);
					skip();
				}
			}
		});
		b2.setBounds(164, 205, 93, 23);
		contentPane.add(b2);
		
		lblNewLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		lblNewLabel.setBounds(99, 159, 54, 15);
		contentPane.add(lblNewLabel);
		
		pwd1 = new JPasswordField();
		pwd1.setEchoChar('*');
		pwd1.setBounds(183, 156, 96, 21);
		contentPane.add(pwd1);
		
		
	}
	
	public void skip(){
		new Login().setVisible(true);
		this.dispose();
	}
}
