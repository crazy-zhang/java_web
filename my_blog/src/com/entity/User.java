package com.entity;

public class User {
	private int Id;
	private String name;
	private String sex;
	private String pwd;
	private String home;
	private String info;
	public int GetId(){
		return Id;
	}
	public void SetId(int Id){
		this.Id=Id;
	}
	public String GetName(){
		return name;
	}
	public void SetName(String name){
		this.name=name;
	}
	public String GetSex(){
		return sex;
	}
	public void SetSex(String sex){
		this.sex=sex;
	}
	public String GetPwd(){
		return pwd;
	}
	public void SetPwd(String pwd){
		this.pwd=pwd;
	}
	public String GetHome (){
		return home;
	}
	public void SetHome  (String home){
		this.home=home;
	}
	public String GetInfo (){
		return info;
	}
	public void SetInfo  (String info){
		this.info=info;
	}

}
