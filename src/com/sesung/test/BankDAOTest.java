package com.sesung.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sesung.bank.BankDAO;
import com.sesung.bank.BankDTO;
import com.sesung.member.MemberDAO;
import com.sesung.util.DBConnector;

public class BankDAOTest {

	private BankDAO bdao;
	
	
	@Before
	public void makeDAO() {
		bdao = new BankDAO();
	}
	
	@Test
	public void test() throws Exception {
		Connection con = DBConnector.connector();
		BankDTO bdto = new BankDTO();
		bdto.setAccount("1");
		bdto.setbName("test");
		bdto.setId("iu");
		int result = bdao.insertBank(bdto, con);
		assertNotNull(bdto);
	}
	
	
}
