package com.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {
	public static String[] Userlist;
	private JPanel contentPane;
	private JScrollPane content;
	private JTextField getter;
	private ClientCl client;
	private JTextArea text,text1;
	private JScrollPane onlineuser;
	private JScrollPane sc1;
	private JList list;
	private String name1;
	/**
	 * Launch the application.
	 */
	
	public Client(String username) {
		Login.cmap.put(username, this);
		this.name1 = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel userlist = new JLabel("\u5728\u7EBF\u7528\u6237\u5217\u8868");
		userlist.setBounds(345, 5, 86, 15);
		contentPane.add(userlist);
		
		
		text1 = new JTextArea();
		content = new JScrollPane(text1);		
		content.setBounds(15, 30, 300, 150);
		contentPane.add(content);
		onlineuser = new JScrollPane();
		onlineuser.setBounds(330, 27, 104, 225);
		contentPane.add(onlineuser);
		
		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()>=2){    //双击两次以上
					int index = list.locationToIndex(e.getPoint());
					String name = Userlist[index];
					getter.setText(name);
				}
			}
		});
		onlineuser.setViewportView(list);
		
		JLabel label = new JLabel("\u53D1\u9001\u7ED9\uFF1A");
		label.setBounds(10, 198, 54, 15);
		contentPane.add(label);
		
		getter = new JTextField();
		getter.setBounds(4, 223, 66, 21);
		contentPane.add(getter);
		getter.setColumns(10);
		
		JButton send = new JButton("send");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check(getter.getText(),name1,text.getText())){
					text1.append("我对"+getter.getText()+"说:"+text.getText()+"\n");
					client.sendMsg(getter.getText(),text.getText(),name1);
				}
			}
		});
		send.setBounds(254, 222, 73, 23);
		contentPane.add(send);		
		
		JLabel name = new JLabel("用户名:"+username);
		name.setBounds(15, 5, 144, 15);
		contentPane.add(name);
		
		text = new JTextArea();
		sc1 = new JScrollPane(text);
		sc1.setBounds(74, 198, 177, 64);
		contentPane.add(sc1);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		client = new ClientCl();
		client.ClientMain(username);		
	}

	public boolean check(String s1, String s2, String s3){
		if(s1.equals(s2)){
			JOptionPane.showMessageDialog(null, "接收者不能是自己!!!");
			return false;
		}
		else if(s1.equals("")||s3.equals("")){
			JOptionPane.showMessageDialog(null, "接收者或内容不能为空");
			return false;
		}else {
			return true;
		}
	}
	/**
	 * @return the getter
	 */
	public JTextField getGetter() {
		return getter;
	}

	/**
	 * @param getter the getter to set
	 */
	public void setGetter(JTextField getter) {
		this.getter = getter;
	}

	/**
	 * @return the content
	 */
	public JScrollPane getContent() {
		return content;
	}


	/**
	 * @return the text1
	 */
	public JTextArea getText1() {
		return text1;
	}

	/**
	 * @param text1 the text1 to set
	 */
	public void setText1(JTextArea text1) {
		this.text1 = text1;
	}
	/**
	 * @return the list
	 */
	public JList getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(JList list) {
		this.list = list;
	}

	
}
