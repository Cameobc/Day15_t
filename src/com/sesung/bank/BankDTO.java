package com.sesung.bank;

import java.sql.Date;

public class BankDTO {
	private String account;
	private String id;
	private Date o_Day;
	private String bName;
	private Long money;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getO_Day() {
		return o_Day;
	}
	public void setO_Day(Date o_Day) {
		this.o_Day = o_Day;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Long getMoney() {
		return money;
	}
	public void setMoney(Long money) {
		this.money = money;
	}
	
	
	

}
