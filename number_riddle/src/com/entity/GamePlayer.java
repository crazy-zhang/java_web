package com.entity;

public class GamePlayer {
	private static String name;
	private String password;
	private String info;
	private String score;
	public void  set_name(String name){
		GamePlayer.name=name;
	}
	public void set_password(String password){
		this.password=password;
	}
	public void set_info(String info){
		this.info=info;
	}
	public void set_score(String score){
		this.score=score;
	}
	public String get_name(){
		return name;
	}
	public String get_password(){
		return password;
	}
	public String get_info(){
		return info;
	}
	public String get_score(){
		return score;
	}
}
