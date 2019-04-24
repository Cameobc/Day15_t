package com.sesung.bank;

import java.util.Scanner;

import com.sesung.member.MemberDTO;
import com.sesung.util.DBConnector;
import com.sesung.util.Session;

public class BankService {

	private Scanner sc;
	private BankDAO bankDAO;
	public BankService() {
		sc = new Scanner(System.in);
		bankDAO = new BankDAO();
	}
	
	public String insert() {
		String message ="계좌개설 성공";
		BankDTO bankDTO = new BankDTO();
		System.out.println("계좌번호 입력");
		bankDTO.setAccount(sc.next());
		System.out.println("계좌명 입력");
		bankDTO.setbName(sc.next());
		bankDTO.setId(((MemberDTO)(Session.member)).getId());
		int result= 0;
		try {
			 result = bankDAO.insertBank(bankDTO, DBConnector.connector());
			 if(result<1) {
				 throw new Exception();
			 }
		} catch (Exception e) {
			e.printStackTrace();
			message = "계좌개설 실패";
		}
		return message;
	}
}
