package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


import com.dao.GameDao;
import com.dao.GameDaoImplement;

public class RankASC {
	public RankASC(){
		JFrame frame=new RankASCFrame();
	    JLabel label=new JLabel("…˝–Ú≈≈––∞Ò");
	    label.setFont(new Font("ÀŒÃÂ",200,40));
	    label.setForeground(Color.white);
	    JLabel rank=new JLabel();
	    rank.setFont(new Font("ÀŒÃÂ",200,28));
	    rank.setForeground(Color.red);
	    GameDao game_dao=new GameDaoImplement();
	    rank.setText("<html>"+game_dao.GetRankAsc().toString()+"<html>");
	    frame.getContentPane().setLayout(null);
	    label.setBounds(140,400,300,50);
	    frame.getContentPane().add(label,BorderLayout.SOUTH);
	    rank.setBounds(120,20,350,351);
	    frame.getContentPane().add(rank);
	}
	
	public class RankASCFrame extends JFrame{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RankASCFrame(){
			setBounds(750,310,500,500);
			getContentPane().setBackground(Color.cyan);
			setTitle("…˝–Ú≈≈––∞Ò");
		    setVisible(true);
		}
	}
}

