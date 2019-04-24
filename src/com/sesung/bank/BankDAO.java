package com.sesung.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sesung.bankbook.BankbookDTO;
import com.sesung.util.DBConnector;

public class BankDAO {

	public ArrayList<BankDTO> selectListBank() throws Exception {
		ArrayList<BankDTO> ar = new ArrayList<BankDTO>();
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM BANK";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankDTO bdto = new BankDTO();
			bdto.setAccount(rs.getString("ACCOUNT"));
			bdto.setId(rs.getString("ID"));
			st.setDate(3, bdto.getO_Day());
			st.setString(3, bdto.getbName());
			bdto.setMoney(rs.getLong("MONEY"));
			ar.add(bdto);
		}
		DBConnector.disconnector(con, st, rs);
		return ar;
	}
	
	public ArrayList<BankDTO> selectIdBank(String acc) throws Exception {
		ArrayList<BankDTO> ar = new ArrayList<BankDTO>();
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM BANK WHERE ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, acc);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankDTO bdto = new BankDTO();
			bdto.setAccount(rs.getString("ACCOUNT"));
			bdto.setId(rs.getString("ID"));
			st.setDate(3, bdto.getO_Day());
			st.setString(3, bdto.getbName());
			bdto.setMoney(rs.getLong("MONEY"));
			ar.add(bdto);
		}
		DBConnector.disconnector(con, st, rs);
		return ar;
	}

	public BankDTO selectOneBank(String acc) throws Exception {
		BankDTO bdto=null;
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM BANK WHERE ACCOUNT=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, acc);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bdto= new BankDTO();
			bdto.setAccount(rs.getString("ACCOUNT"));
			bdto.setId(rs.getString("ID"));
			st.setDate(3, bdto.getO_Day());
			st.setString(3, bdto.getbName());
			bdto.setMoney(rs.getLong("MONEY"));
		}
		DBConnector.disconnector(con, st, rs);
		return bdto;
	}


	public int update(Connection con, BankDTO bdto) throws Exception {
		String sql ="UPDATE BANK SET MONEY=(select money from bank where id=?)+? WHERE ACCOUNT=(select account from bank where id=?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bdto.getId());
		st.setLong(2, bdto.getMoney());
		st.setString(3, bdto.getId());
		int result = st.executeUpdate();
		st.close();
		return result;
	}

	public int insertBank(BankDTO bdto, Connection con) throws Exception {
		String sql ="INSERT INTO BANK VALUES (?, ?, sysdate, ?, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bdto.getAccount());
		st.setString(2, bdto.getId());
		st.setString(3, bdto.getbName());
		int result = st.executeUpdate();
		st.close();
		return result;
	}

}
