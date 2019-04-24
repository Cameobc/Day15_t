package com.sesung.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sesung.bank.BankDTO;
import com.sesung.util.DBConnector;

import oracle.jdbc.proxy.annotation.Pre;

public class MemberDAO {

	public MemberDTO selectOne(String id) throws Exception {
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		MemberDTO dto = null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
		}
		DBConnector.disconnector(con, st, rs);
		return dto;
	}
	//로그인
	public MemberDTO login(MemberDTO dto) throws Exception{
		Connection con = DBConnector.connector();
		String sql = "SELECT * FROM MEMBER WHERE ID =? AND PW =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
//			BankDTO bankDTO = new BankDTO();
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getNString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
//			bankDTO.setbName(rs.getString("BNAME"));
//			bankDTO.setAccount(rs.getString("ACCOUNT"));
//			bankDTO.setMoney(rs.getLong("MONEY"));
//			bankDTO.setO_Day(rs.getDate("O_DAY"));
//			dto.setBankDTO(bankDTO);
		}else {
			dto = null;
		}
		DBConnector.disconnector(con, st, rs);
		return dto;
	}

	public int insertMember(MemberDTO dto) throws Exception {
		int result =0;
		Connection con = DBConnector.connector();
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setString(4, dto.getPhone());
		st.setString(5, dto.getEmail());
		result = st.executeUpdate();
		DBConnector.disconnector(con, st);
		return result;
	}
}
