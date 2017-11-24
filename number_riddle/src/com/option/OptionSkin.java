package com.option;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gui.Menu;

public class OptionSkin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OptionSkin(){
		setSize(550,340);
		setUndecorated(false);
		setTitle("¸ü»»Æ¤·ô");
		setVisible(true);
		setLocation(200,200);
		JPanel grid_panel=new JPanel();
		//grid_panel.setLayout(new GridLayout(2,3));
		ImageIcon img_butterfly=new ImageIcon("img/butterfly_label.jpg");
		JLabel label_buttery=new JLabel(img_butterfly);
		MouseAdapter butter_click=new ButterClick();
		label_buttery.addMouseListener(butter_click);
		ImageIcon img_city=new ImageIcon("img/city _label.jpg");
		JLabel label_city=new JLabel(img_city);
		ImageIcon img_night=new ImageIcon("img/night_label.jpg");
		JLabel label_night=new JLabel(img_night);
		ImageIcon img_flower=new ImageIcon("img/flower_label.jpg");
		JLabel label_flower=new JLabel(img_flower);
		grid_panel.add(label_buttery);
		grid_panel.add(label_city);
		grid_panel.add(label_night);
		grid_panel.add(label_flower);
		add(grid_panel);
	}
	
	class ButterClick extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
				/*try {
					Class<?> cl=Class.forName("com.gui.Menu");
					try {
						Field file=cl.getField("skin");
						file.setAccessible(true);
						try {
						    Object	obj =  cl.newInstance();
							file.set(obj, "img/butterfly.jpg");
							System.out.println(file.getName());
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			Menu background=new Menu();
			background.set_backimg("img/butterfly.jpg");
		}
	}
}
			
	
	










