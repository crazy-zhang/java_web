package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dao.GameDao;
import com.dao.GameDaoImplement;

public class Regist {
	private JTextField name;
	private JTextField password;
	private JTextField code;
	private JFrame frame;
	public Regist(){
		frame=new RegistFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		JPanel grid_panel=new JPanel();
		JLabel name_label=new JLabel("用户名:");
		JLabel password_label=new JLabel("密码:");
		JLabel code_label=new JLabel("验证码");
		name_label.setFont(new Font("宋体",30,15));
		password_label.setForeground(Color.white);
		password_label.setFont(new Font("宋体",30,15));
		name_label.setForeground(Color.white);
		code_label.setFont(new Font("宋体",30,15));
		code_label.setForeground(Color.white);
		name=new JTextField("");
		name.setFont(new Font("宋体",30,30));
	    password=new JPasswordField("");
		password.setFont(new Font("宋体",30,30));
		code=new JTextField("");
		code.setFont(new Font("宋体",30,30));
		JButton regist_button=new JButton("注册");
		regist_button.setFont(new Font("宋体",30,30));
		ActionListener regist_action=new RegistAction();
		regist_button.addActionListener(regist_action);
		grid_panel.setLayout(new GridLayout(4,1));
		grid_panel.add(name);
		grid_panel.add(password);
		grid_panel.add(code);
		grid_panel.add(regist_button);
		grid_panel.setBounds(110,40,200,150);
		name_label.setBounds(10,40,80,20);
		password_label.setBounds(10,80,80,20);
		code_label.setBounds(10,120,80,20);
		frame.getContentPane().add(name_label);
		frame.getContentPane().add(password_label);
		frame.getContentPane().add(code_label);
		frame.add(grid_panel);
	}
	
	public class RegistFrame extends JFrame{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public RegistFrame(){
		    setSize(400,300);
			setUndecorated(false);
			setTitle("用户注册");
			setLocation(750,350);
			setLayout(null);
			setVisible(true);
	  }
	}
	public class RegistAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			GameDao game_dao=new GameDaoImplement();
			String str_name=name.getText();
			String str_password=password.getText();
			//String correct_code;
			//game_player.set_info("01");
			if(str_name.length()>2 && str_password.length()>=6){
			if(game_dao.regist(str_name, str_password)){
				
				JOptionPane.showMessageDialog(null, "成功注册");
			}
			else{
				JOptionPane.showMessageDialog(null, "用户名重复,注册失败");
			}
		}
			else{
				JOptionPane.showMessageDialog(null, "名字大于2位"+"\n"+"密码大于6位");
			}
		}
		
	}
}
