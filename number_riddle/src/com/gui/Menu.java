package com.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.option.OptionSkin;



   @SuppressWarnings("serial")
public class Menu extends JFrame{
	// private  String str_skin="img/water.jpg";
	 private static JPanel jpanel;
	 public static String skin="img/water.jpg";
	public Menu(){
		final JMenuBar menuBar=new JMenuBar();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen_size=kit.getScreenSize();
		int screen_width=screen_size.width;
		int screen_height=screen_size.height;
		
		setSize(screen_width/2,screen_height/2);
		System.out.println(screen_width/2);
		System.out.println(screen_height/2);
		setLocationRelativeTo(null);
		//setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("猜数字游戏");
		setJMenuBar(menuBar);
		//frame.setUndecorated(false);
		JMenu edit_menu_newgame=new JMenu("新游戏");
		menuBar.add(edit_menu_newgame);
		edit_menu_newgame.setMnemonic('Q');
		JMenuItem menu_item_start=new JMenuItem("开始游戏");
		//menu_item_start.setHorizontalTextPosition(SwingConstants.LEFT);
		edit_menu_newgame.add(menu_item_start);
		JMenuItem menu_item_stop=new JMenuItem("暂停游戏");
		edit_menu_newgame.add(menu_item_stop);
		final JMenuItem menu_item_save=new JMenuItem("保存游戏");
		menu_item_save.setAccelerator(KeyStroke.getKeyStroke("ctrl s"));
		edit_menu_newgame.add(menu_item_save);
		final JMenu menu_item_load=new JMenu("读取游戏");
		menu_item_load.setEnabled(false);
		edit_menu_newgame.add(menu_item_load);
		menu_item_save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub					
				menu_item_load.setEnabled(true);
			}
			
		});
		JRadioButtonMenuItem game_load01=new JRadioButtonMenuItem("游戏进度1");
		menu_item_load.add(game_load01);
		game_load01.setSelected(true);
		JRadioButtonMenuItem game_load02=new JRadioButtonMenuItem("游戏进度2");
		menu_item_load.add(game_load02);
		JRadioButtonMenuItem game_load03=new JRadioButtonMenuItem("游戏进度3");
		menu_item_load.add(game_load03);
		edit_menu_newgame.add(new AbstractAction("退出游戏"){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		edit_menu_newgame.addSeparator();
		JMenu edit_menu_rank=new JMenu("排行榜");
		menuBar.add(edit_menu_rank);
		JMenuItem menu_item_rank_desc=new JMenuItem("降序排列");
		edit_menu_rank.add(menu_item_rank_desc);
		JMenuItem menu_item_rank_asc=new JMenuItem("升序排列");
		ActionListener rank_asc_action=new Rank_ASC_Action();
		menu_item_rank_asc.addActionListener(rank_asc_action);
		edit_menu_rank.add(menu_item_rank_asc);
		JMenuItem menu_item_rank_myself=new JMenuItem("自己的位置");
		edit_menu_rank.add(menu_item_rank_myself);
		JMenu edit_menu_option=new JMenu("选项");
		menuBar.add(edit_menu_option);
		JMenuItem menu_item_skin=new JMenuItem("皮肤");
		menu_item_skin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				OptionSkin background=new OptionSkin();
				background.toString();
			}
			
		});
		edit_menu_option.add(menu_item_skin);
		JMenu edit_menu_help=new JMenu("帮助");
		menuBar.add(edit_menu_help);
		JMenuItem menu_item_news=new JMenuItem("关于");
		menu_item_news.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "作者：张永强 时间：2017-11-03");
			}
			
		});
		edit_menu_help.add(menu_item_news);
		JMenuItem menu_item_introduction=new JMenuItem("游戏说明");
		menu_item_introduction.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "这是一个猜数字的游戏，你最多猜5次，点击右键可以得到答案啊");
			}
			
		});
		edit_menu_help.add(menu_item_introduction);
	    
	    
	//    JToolBar tool_bar=new JToolBar("个性化选择");
		set_backimg(skin);
		Image icon=new ImageIcon("water.jpg").getImage();
		setIconImage(icon);
	}
   public void set_backimg(String str_skin){
	    if(jpanel!=null){
	    	System.out.println("132");
	    	//this.getLayeredPane().removeAll();
	    }
	   // jpanel=new JPanel();
	    jpanel=(JPanel)this.getContentPane();
	    jpanel.setOpaque(false);
	    ImageIcon background_img=new ImageIcon(str_skin);
	    JLabel label_background_img=new JLabel(background_img);
	    label_background_img.setBounds(0,0,2000,1000);
	    this.getLayeredPane().add(label_background_img,new Integer(Integer.MIN_VALUE));
   }
  class TestAction extends AbstractAction{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestAction(String name){
		  super(name);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
  }
  
  class Rank_ASC_Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		RankASC rank_asc=new RankASC();
		rank_asc.toString();
	}
	  
  }
   }
   
   
   
   
   
   
   
   
