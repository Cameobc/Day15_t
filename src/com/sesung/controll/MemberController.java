package com.sesung.controll;

import java.util.Scanner;

import com.sesung.member.MemberDAO;
import com.sesung.member.MemberService;
import com.sesung.util.Session;
import com.sesung.view.View;

public class MemberController {
	private MemberService memberService;
	private View view;
	private BankController bankController;
	private Scanner sc;

	public MemberController() {
		memberService = new MemberService();
		bankController = new BankController();
		view = new View();
		sc = new Scanner(System.in);
	}

	public void start() {
		boolean check = true;
		String message=null;
		while(check) {
			if(Session.member!=null) {
				System.out.println("1. MyPage");
				System.out.println("2. Logout");
				System.out.println("3. 계좌관리");
				int select = sc.nextInt();
				if(select==1) {
					view.view();
				}else if(select==2){
					Session.member=null;
				}else {
					bankController.start();
				}
			}else {
			System.out.println("1. 회원가입");
			System.out.println("2. 로 그 인");
			System.out.println("3. 종    료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				message = memberService.insert();
				view.view(message);
				break;
			case 2: 
				message = memberService.login();
				view.view(message);
				break;
			default:
				check=!check;
			}
			}
		}

	}
}
