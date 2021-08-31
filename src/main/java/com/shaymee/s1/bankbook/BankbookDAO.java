package com.shaymee.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.util.DBConnector;

public class BankbookDAO {

private DBConnector dbConnector;
	
	public BankbookDAO() {
		dbConnector = new DBConnector();
	}
	
	//setInsert
	//DB에 insert하는 코드를 만들어주면 됨
	public int setInsert(BankbookDTO bankbookDTO) {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "INSERT INTO BANKBOOK (BOOKNUMBER, BOOKNAME, BOOKRATE, BOOKSALE) "
				+ "	VALUES (bankbook_seq.nextval, ?, ?, ?) ";
		
		try {
			st = con.prepareStatement(sql);

			st.setString(1, bankbookDTO.getBookName());
			st.setDouble(2, bankbookDTO.getBookRate());
			st.setInt(3, bankbookDTO.getBookSale());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(st, con); //오버로딩 활용	
		}
		
		return result;
	}
	
	
	
	public ArrayList<BankbookDTO> getList() {
		Connection con = dbConnector.getConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BANKBOOK";

		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		try {			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankbookDTO bankbookDTO = new BankbookDTO();
				
				bankbookDTO.setBookNumber(rs.getLong(1));
				bankbookDTO.setBookName(rs.getString(2));
				bankbookDTO.setBookRate(rs.getDouble(3));
				bankbookDTO.setBookSale(rs.getInt(4));
				
				ar.add(bankbookDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return ar;
	}
	
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		BankbookDTO bbDTO = null;
		
		try {
			con = dbConnector.getConnect();
			String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUMBER = ?";
			st = con.prepareStatement(sql);
			st.setLong(1, bankbookDTO.getBookNumber());
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				bbDTO = new BankbookDTO();
			
				bbDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
				bbDTO.setBookName(rs.getString("BOOKNAME"));
				bbDTO.setBookRate(rs.getDouble("BOOKRATE"));
				bbDTO.setBookSale(rs.getInt("BOOKSALE"));				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return bbDTO;
		
	}
}
