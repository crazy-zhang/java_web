package com.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.dao.GameDao;
import com.dao.GameDaoImplement;
import com.entity.GamePlayer;

public class Login {
	private JTextField name;
	private JTextField password;
	private JFrame frame;
	static int count=0;
	public Login(){
		frame=new LoginFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		JPanel grid_panel=new JPanel();
		//JPanel grid_panel1=new JPanel();
		JLabel name_label=new JLabel("用户名:");
		JLabel password_label=new JLabel("密码:");
		name_label.setFont(new Font("宋体",30,15));
		password_label.setForeground(Color.white);
		password_label.setFont(new Font("宋体",30,15));
		name_label.setForeground(Color.white);
		password_label.setFont(new Font("宋体",30,15));
		name=new JTextField("");
		name.setFont(new Font("宋体",30,30));
	    password=new JPasswordField("");
		password.setFont(new Font("宋体",30,30));
		JButton login_button=new JButton("登录");
		login_button.setFont(new Font("宋体",30,30));
		ActionListener login_action=new LoginAction();
		login_button.addActionListener(login_action);
		grid_panel.setLayout(new GridLayout(3,1));
		grid_panel.add(name);
		grid_panel.add(password);
		grid_panel.add(login_button);
		grid_panel.setBounds(110,40,200,100);
		name_label.setBounds(10,40,80,20);
		password_label.setBounds(10,70,80,20);	
		frame.getContentPane().add(name_label);
		frame.getContentPane().add(password_label);
		frame.add(grid_panel);
	}
	
	public class LoginFrame extends JFrame{
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public LoginFrame(){
		    setSize(400,300);
			setUndecorated(false);
			setTitle("用户登录");
			setLocation(750,350);
			setLayout(null);
			setVisible(true);
	  }
	}
	public class LoginAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Module module=new Module();
			JFrame frame_module=module.get_frame();
			JLabel label_module=module.get_label_player();
			GameDao game_dao=new GameDaoImplement();
			String str_name=name.getText();
			String str_password=password.getText();
			GamePlayer game_player=new GamePlayer();
			game_player.set_info("01");
			if(count>1){
				System.out.println("123");
				frame.getContentPane().remove(label_module);
			}
			game_player.set_name(str_name);
			if(game_dao.longin(str_name, str_password)){
				module.label_player_name(str_name);
				frame_module.setSize(961,541);
				frame_module.setVisible(true);
				count++;
				frame_module.validate();
				frame.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "输入正确的用户名和密码");
			}
		}
		
	}
}






