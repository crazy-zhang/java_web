package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;

import com.dao.GameDao;
import com.dao.GameDaoImplement;
import com.entity.GamePlayer;
import com.guess.Guess;
import com.option.OptionMusic;
import com.servlet.*;

@SuppressWarnings("serial")
public class Module extends JFrame{
	private static JTextField input_num;
	private static JLabel label_tip;
//	private static String str_player;
	private static JFrame frame;
	private static JLabel label_player;
	static int count=0;
public static void main(String[] args){
	
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				/*Menu background=new Menu();
			 	background.set_backimg("img/water.jpg");*/
			 	frame=new Menu();	
			 	//reframe();	 	
			 	
				final Guess guess=new Guess();
			 	/*OptionMusic option_music=new OptionMusic();
			 	option_music.play_music();*/
				TimeKepper timer=new TimeKepper();	
				//timer.setPreferredSize(new Dimension(300,40));
				timer.setBounds(0,0,300,40);
			 	final JPanel grid_panel=new JPanel();
			 	grid_panel.setBounds(260,40,400,300);
			 	grid_panel.setBackground(Color.green);
				grid_panel.setLayout(new GridLayout(5,1));
				label_tip=new JLabel("请输入四个不重复的数字:");
				Font label_font=new Font("宋体",30, 30);
				label_tip.setFont(label_font);
				grid_panel.add(label_tip);
				grid_panel.add(input_num=new JTextField(""));
				input_num.setFont(new Font("宋体",30, 30));
				input_num.setText("例如输入1234");
				//String text=input_num.getText().trim();
				//System.out.println(text);
				final JButton show_button=new JButton("提交");
				show_button.setFont(new Font("宋体",30,30));
				input_num.addKeyListener(new KeyAdapter(){
					@SuppressWarnings("static-access")
					public void keyPressed(KeyEvent event){
						    if(event.getKeyCode()==event.VK_ENTER){
								if(count>5){
									System.exit(0);
								}
								
							show_button.doClick();
						    }
					}
				});
				final List<Integer> number=guess.flag_num_correct();
				show_button.addActionListener(new ActionListener(){
					@SuppressWarnings({ })
					public void actionPerformed(ActionEvent e){
						count++;
						String str_input_num=input_num.getText();
						//System.out.println(str_input_num);
						if(str_input_num.length()!=4){
							JOptionPane.showMessageDialog(null, 
									"<html><span >按要求输入4个0----9数字</span></html>");
							count--;
						}
						else if(!IsNum(str_input_num)){
							JOptionPane.showMessageDialog(null, "请输入数字");
							count--;
						}
						else if(!IsEquals(str_input_num)){
							JOptionPane.showMessageDialog(null, "请输入不同的数字");
							count--;
						}
						else{
						int[] input_num=new int[4];
						for(int i=0;i<4;i++){
							input_num[i]=Integer.parseInt(str_input_num.substring(i,i+1));
						}
						if(count>5){
							System.exit(0);
						}
						if(guess.Check(number, input_num).equals("4个A   0个B")){
						    JOptionPane.showMessageDialog(grid_panel, "你回答对了");
						    GameDao game_dao=new GameDaoImplement();
						    GamePlayer game_player=new GamePlayer();
						    String player_name = game_player.get_name();
						    System.out.println("132"+player_name);
						    if(game_dao.update(player_name)){
						    }
						  while(count>0){
							  count--;
						  }
					      run();
					      frame.getContentPane().add(label_player);
						}
						else{
							JOptionPane.showMessageDialog(null, guess.Check(number, input_num)+"\n"+"你还有"+(5-count)+"次机会");
						}
					}
					}
				});
				
				JPopupMenu popup=new JPopupMenu();
				JMenuItem popup_item_tip=new JMenuItem("提示");
				popup_item_tip.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, guess.Result(number));
					}
					
				});
				popup.add(popup_item_tip);
				grid_panel.setComponentPopupMenu(popup);
				SoftBevelBorder show_button_border=new SoftBevelBorder(0,Color.RED, Color.RED);
				show_button.setBorder(show_button_border);
				grid_panel.add(show_button,BorderLayout.SOUTH);
				BorderLayout lay=new BorderLayout();
				JPanel login_regist_panel=new JPanel();
				login_regist_panel.setBounds(800,400,120,50);
				JButton login_button=new JButton("登录");
				JButton regist_button=new JButton("注册");
				login_regist_panel.setLayout(lay);
				ActionListener login_action = new LoginAction();
				ActionListener regist_action=new RegistAction();
				login_button.addActionListener(login_action);
				regist_button.addActionListener(regist_action);
				login_regist_panel.add(login_button,"West");
				login_regist_panel.add(regist_button,"East");
				frame.setLayout(null);
				frame.add(timer);
				frame.add(grid_panel);
				frame.add(login_regist_panel);
				timer.start();
			}
		});
	}
public static void reframe(){}

public static boolean IsNum(String str){
	for(int i=0;i<str.length();i++){
		if(!Character.isDigit(str.charAt(i)))
            return false;
	}
	return true;
}

public static boolean IsEquals(String str){
	for(int i=0;i<str.length();i++){
		for(int j=i+1;j<str.length();j++){
			if(str.charAt(i) == str.charAt(j)){
				return false;
			}
		}
	}
	return true;
}
public void set_str_plarer(String str_player){
	//Module.str_player=str_player;
}

public JFrame get_frame(){
	return frame;
}

public JLabel get_label_player(){
	return label_player;
}
public JLabel label_player_name(String str_player){
	if(label_player!=null){
		frame.setSize(960,540);
		frame.getContentPane().remove(label_player);
	}
	label_player=new JLabel("用户名:"+str_player);
	label_player.setFont(new Font("宋体",50,20));
	label_player.setBounds(800,20,150,40);
	frame.getContentPane().add(label_player);
	frame.setVisible(true);
	frame.validate();
	return label_player;
}


}
class LoginAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login login=new Login();
		login.toString();
	}
	
}
class RegistAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Regist regist=new Regist();
		regist.toString();
	}
	
}
	






