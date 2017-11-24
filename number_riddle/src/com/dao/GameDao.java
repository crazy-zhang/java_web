package com.dao;
import java.util.*;

import com.entity.GamePlayer;

public interface GameDao {
	public String GetRankMyself(String info);
	public StringBuffer GetRankDesc();
	public StringBuffer GetRankAsc();
	public boolean longin(String name,String password);
	public boolean regist(String name,String password);
	public boolean delete(String info);
	public boolean update(String info);
	public List<GamePlayer> GetPlayerAll(GamePlayer game_player);
}
