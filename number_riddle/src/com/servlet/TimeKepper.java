package com.servlet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class TimeKepper extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int second=0;
	private boolean start=false;
	Timer timer = new Timer(1000, new TimerListener());
	public TimeKepper(){
		setFont(new Font("Courier",Font.BOLD,15));
	}
	public void PaintComponent(Graphics g){
		super.paintComponent(g);
		second++;
		String output;
		System.out.println("画出来了");
		if(start=true){
			output="已用时"+(second/3600)+":"+(second%3600/60)+":"+(second%60);
		}
		else{
			output="已用时0:0:0";
		}
		g.drawString(output,200, 15);
	}
	public void start(){
		start=true;
		if(start){
			timer.stop();
			timer.start();
		}
	}
	public void stop(){
		if(start){
			start=false;
			timer.stop();
			second=0;
			repaint();
		}
	}
	int get_second(){
		return second;
	}
	public void set_second(int second){
		this.second=second;
	}
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
		}
		
	}
}
