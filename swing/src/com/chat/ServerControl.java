package com.chat;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ServerControl extends JFrame {

	private JPanel contentPane;
	private JButton open,close;
	private Server server;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerControl frame = new ServerControl();
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
	public ServerControl() {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		open = new JButton("\u5F00\u542F\u670D\u52A1\u5668");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server=new Server();
				server.start();
				open.setEnabled(false);
				close.setEnabled(true);
			}
		});
		open.setBounds(52, 131, 123, 43);
		contentPane.add(open);
		
		close = new JButton("\u5173\u95ED\u670D\u52A1\u5668");
		close.setEnabled(false);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				try {
					Socket s = new Socket("localhost",10086);
					Server.flag=false;
					if(!s.isClosed()){
						s.close();				
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "服务器关闭成功");
				open.setEnabled(true);
				close.setEnabled(false);
			}
		});
		close.setBounds(237, 131, 123, 43);
		contentPane.add(close);
		
		JLabel lb = new JLabel("\u670D\u52A1\u5668");
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		lb.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lb.setBounds(132, 31, 132, 57);
		contentPane.add(lb);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
