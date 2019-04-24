package com.sesung.bankbook;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.sesung.bank.BankDAO;
import com.sesung.bank.BankDTO;
import com.sesung.member.MemberDTO;
import com.sesung.util.DBConnector;
import com.sesung.util.Session;

public class BookService {
	
	private Scanner sc;
	private BankbookDAO bankbookDAO;
	private BankDAO bankDAO;
	
	public BookService() {
		sc = new Scanner(System.in);
		bankbookDAO = new BankbookDAO();
		bankDAO = new BankDAO();
	}
	
	public String tran(int num) {
		//입금, 출금
		int kind=1;
		String message ="입금";
		if(num!=0) {
			message = "출금";
			kind=1;
		}
		System.out.println(message + " 금액을 입력하세요.");
		BankbookDTO bankbookDTO = new BankbookDTO();
		//account, standard, b_action
		bankbookDTO.setB_Action(sc.nextInt());
		bankbookDTO.setStandard(num);
		
		int result = 0;
		String id = ((MemberDTO)Session.member).getId();
		Connection con = null;
		try {
			con = DBConnector.connector();
			con.setAutoCommit(false);
			result = bankbookDAO.insertBook(con, bankbookDTO, id);
			
			if(result<1) {
				throw new Exception();
			}
			BankDTO bankDTO = new BankDTO();
			bankDTO.setMoney((long)(bankbookDTO.getB_Action()*kind));
			bankDTO.setId(id);
			
			result = bankDAO.update(con, bankDTO);
			if(result<1) {
				throw new Exception();
			}
			con.commit();
			message =message+ "성공";
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			message =message+"실패";
		}
		
		return message;
	}

}
