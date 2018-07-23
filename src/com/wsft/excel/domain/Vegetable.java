package com.wsft.excel.domain;

import java.sql.Date;

public class Vegetable {

	private Integer id;
	private Date testtm;
	private String manage;
	private String sampname;
	private String location;
	private String channels;
	private float testidx;
	private String result;
	private String testaddr;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getTesttm() {
		return testtm;
	}

	public void setTesttm(Date testtm) {
		this.testtm = testtm;
	}
	
	public void setManage(String manage) {
		this.manage = manage;
	}

	public String getManage() {
		return manage;
	}
	
	public void setSampName(String sampname) {
		this.sampname = sampname;
	}

	public String getSampName() {
		return sampname;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getChannels() {
		return channels;
	}
	
	public void setTestidx(float testidx) {
		this.testidx = testidx;
	}

	public float getTestidx() {
		return testidx;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}
	
	public void setTestaddr(String testaddr) {
		this.testaddr = testaddr;
	}

	public String getTestaddr() {
		return testaddr;
	}
}
