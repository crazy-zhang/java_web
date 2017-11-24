package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.GamePlayer;

public class GameDaoImplement implements GameDao{

	@Override
	public String GetRankMyself(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuffer GetRankDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuffer GetRankAsc() {
		// TODO Auto-generated method stub
		StringBuffer rank_asc=new StringBuffer(); 
		DBconnect.init();
		int count=0;
		ResultSet rs=DBconnect.sqlQuery("select  * from game_player order by score desc");
		try {
			while(rs.next()){
				if(count<=10){
					rank_asc.append("<p>"+rs.getString("name")+" ---------- "
				+rs.getString("score")+"</p>");
					count++;
					
				}
			}
			DBconnect.sqlClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rank_asc;
	}

	@Override
	public boolean longin(String name, String password) {
		// TODO Auto-generated method stub
		DBconnect.init();		
	    boolean flag=false;
		ResultSet rs=DBconnect.sqlQuery("select * from game_player where name='"+name+"' and password='"+password+"'");
		try {
			while(rs.next()){
				if(rs.getString("name").equals(name) && rs.getString("password").equals(password)){
					flag=true;
				}
			}
			DBconnect.sqlClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public boolean regist(String name, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBconnect.init();
		int count=0;
		ResultSet rs=DBconnect.sqlQuery("select * from game_player");
		try {
			while(rs.next()){
				count++;
				if(rs.getString("name").equals(name)){
					return false;
				}
			}
			String sql="insert into game_player(info,name,password,score)" +
					"values ('"+count+"','"+name+"','"+password+"','"+0+"')";
			int i=DBconnect.addDeleteUpdate(sql);
			if(i>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean delete(String info) {
		// TODO Auto-generated method stub
		 
		return false;
	}

	@Override
	public boolean update(String info) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBconnect.init();
		ResultSet rs=DBconnect.sqlQuery("select * from game_player  ");
		try {
			while(rs.next()){
				if(rs.getString("name").equals(info)){
					String sql="update game_player set score=score+1 where name='"+info+"'";
					int i=DBconnect.addDeleteUpdate(sql);
					if(i>0){
						flag=true;
					}
				}
			}
			DBconnect.sqlClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<GamePlayer> GetPlayerAll(GamePlayer game_player) {
		// TODO Auto-generated method stub
		return null;
	}

}