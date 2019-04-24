package com.sesung.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sesung.util.DBConnector;

public class BankbookDAO {
	
	
	public int insertBook(Connection con, BankbookDTO kdto, String id) throws Exception {
		int result =0;
		//insert into TRANSACTIONINFO values(TRANSACTIONINFO_SEQ.nextval,(select accountnum from account where id=?), ?, ?, sysdate)"
		String sql = "INSERT INTO BANKBOOK VALUES ((select account from bank where id=?), BANKBOOK_SEQ.NEXTVAL, ?, sysdate, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, kdto.getAccount());
		st.setInt(2, kdto.getB_Action());
		st.setInt(3, kdto.getStandard());
		result = st.executeUpdate();
		return result;
	}

}
