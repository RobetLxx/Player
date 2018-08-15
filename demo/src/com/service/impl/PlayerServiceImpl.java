package com.service.impl;

import java.util.List;

import com.bean.Player;
import com.dao.PlayerDao;
import com.service.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	private PlayerDao playerdao;
	
	public PlayerDao getPlayerdao() {
		return playerdao;
	}

	public void setPlayerdao(PlayerDao playerdao) {
		this.playerdao = playerdao;
	}

	@Override
	public List<Player> list() {
		// TODO Auto-generated method stub
		return this.playerdao.list();
	}

}
