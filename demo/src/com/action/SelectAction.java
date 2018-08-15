package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bean.Player;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PlayerService;

import freemarker.template.utility.Execute;
import net.sf.json.JSONArray;

public class SelectAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlayerService playerService;

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();  
		List<Player> vList=this.playerService.list();
		List<Integer> d_id=new ArrayList<Integer>();
		List<Integer> c_id=new ArrayList<Integer>();
		List<Integer> dt_id=new ArrayList<Integer>();
		List<String> d_name=new ArrayList<String>();
		List<String> d_location=new ArrayList<String>();
		List<String> d_mac=new ArrayList<String>();
		List <Integer>d_status=new ArrayList<Integer>();
		List<Integer>d_cycle=new ArrayList<Integer>();
		Iterator<Player> iterator=vList.iterator();
		
		while (iterator.hasNext()) {
			Player player = (Player) iterator.next();
			d_id.add(player.getD_id());
			c_id.add(player.getC_id());
			dt_id.add(player.getDt_id());
			d_name.add(player.getD_name());
			d_location.add(player.getD_location());
			d_mac.add(player.getD_mac());
			d_status.add(player.getD_status());
			d_cycle.add(player.getD_cycle());
		}
		//将获取来的数据用列表的方式添加入merge
		List<List> merge=new ArrayList();
		merge.add(d_id);
		merge.add(c_id);
		merge.add(dt_id);
		merge.add(d_name);
		merge.add(d_location);
		merge.add(d_mac);
		merge.add(d_status);
		merge.add(d_cycle);
		//封装成json对象
		JSONArray jsonArray=JSONArray.fromObject(merge);
		//传给前端
		try {
			response.setContentType("charset=UTF-8");
			response.getWriter().print(jsonArray); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		ActionContext ac=ActionContext.getContext();
//		JSONArray json = JSONArray.fromObject(vList);
//		System.out.println(json.toString());
//		ac.put("data_list", json);
		return "success";
	}
}
