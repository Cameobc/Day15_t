package com.sesung.view;

import com.sesung.member.MemberDTO;
import com.sesung.util.Session;

public class View {
	
	public void view() {
		//MYPAGE
		MemberDTO memberDTO = (MemberDTO)Session.member;
		System.out.println("ID : "+memberDTO.getId());
		System.out.println("NAME : "+ memberDTO.getName());
		System.out.println("PHONE : "+memberDTO.getPhone());
		System.out.println("EMAIL : "+memberDTO.getEmail());
//		System.out.println("AccountName : "+memberDTO.getBankDTO().getbName());
//		System.out.println("Account : "+memberDTO.getBankDTO().getAccount());
//		System.out.println("Money : "+memberDTO.getBankDTO().getMoney());
//		System.out.println("Date : "+memberDTO.getBankDTO().getO_Day());
	}
	
	public void view(String message) {
		System.out.println(message);
	}

}
