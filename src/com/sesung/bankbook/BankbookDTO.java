package com.sesung.bankbook;

import java.sql.Date;

public class BankbookDTO {
	private String account;
	private int bNum;
	private int b_Action;
	private Date b_Day;
	private int standard;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getB_Action() {
		return b_Action;
	}
	public void setB_Action(int b_Action) {
		this.b_Action = b_Action;
	}

	public Date getB_Day() {
		return b_Day;
	}
	public void setB_Day(Date b_Day) {
		this.b_Day = b_Day;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	

}
