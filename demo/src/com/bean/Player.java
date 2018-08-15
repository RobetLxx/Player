package com.bean;

public class Player {
	private int d_id;//主键
	private String d_name;//设备名
	private String d_location;//区域
	private int c_id;
	private int dt_id;
	private String d_mac;
	private int d_status;
	private int d_cycle;
	public Player() {}
	
	public Player(int d_id,int c_id,int dt_id,String d_name,String d_location,String d_mac,int d_status,int d_cycle) {
		this.d_id=d_id;
		this.c_id=c_id;
		this.dt_id=dt_id;
		this.d_name=d_name;
		this.d_location=d_location;
		this.d_mac=d_mac;
		this.d_status=d_status;
		this.d_cycle=d_cycle;
	}
	
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_location() {
		return d_location;
	}
	public void setD_location(String d_location) {
		this.d_location = d_location;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getDt_id() {
		return dt_id;
	}
	public void setDt_id(int dt_id) {
		this.dt_id = dt_id;
	}
	public String getD_mac() {
		return d_mac;
	}
	public void setD_mac(String d_mac) {
		this.d_mac = d_mac;
	}
	public int getD_status() {
		return d_status;
	}
	public void setD_status(int d_status) {
		this.d_status = d_status;
	}
	public int getD_cycle() {
		return d_cycle;
	}
	public void setD_cycle(int d_cycle) {
		this.d_cycle = d_cycle;
	}
}
