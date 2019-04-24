package com.sesung.controll;

import java.util.Scanner;

import com.sesung.bank.BankService;
import com.sesung.bankbook.BookService;
import com.sesung.view.View;

public class BankController {
	private Scanner sc;
	private BankService bankService;
	private View view;
	private BookService bookService;
	
	public BankController() {
		bankService = new BankService();
		view = new View();
		bookService = new BookService();
		sc = new Scanner(System.in);
	}

	public void start() {
		boolean check = true;
		String message = null;
		while(check) {
			System.out.println("1. 계좌개설");
			System.out.println("2. 입     금");
			System.out.println("3. 출     금");
			System.out.println("4. 종     료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				message= bankService.insert();
				view.view(message);
				break;
			case 2:
				message = bookService.tran(0);
				view.view(message);
				break;
			case 3:
				message = bookService.tran(1);
				view.view(message);
				break;
			default:
				check=!check;
			}
		}
	}

}
