package com.shaymee.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shaymee.s1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	@Test
	public void setDeleteTest() {
		int result = bankbookDAO.setDelete(69L);
		assertEquals(68, result);
	}
	
	
//	@Test
	public void setInsertTest() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookName("Spring");
		bankbookDTO.setBookRate(4.45);
		bankbookDTO.setBookSale(0);
		int result = bankbookDAO.setInsert(bankbookDTO);
		assertEquals(1, result);
		
	}
	
//	@Test
	public void getSelectTest() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(7);
		bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
		//System.out.println(bankbookDTO.getBookName());
		
		assertNotNull(bankbookDTO);
	}
	
//	@Test
	public void getListTest() {
		List<BankbookDTO> ar = bankbookDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
}
