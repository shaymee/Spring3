package com.shaymee.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shaymee.s1.MyJunitTest;
import com.shaymee.s1.util.Pager;

public class BankbookDAOTest extends MyJunitTest {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
//	@Test
	public void setUpdateTest() {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(4800L);
		bankbookDTO.setBookName("UpdateName");
		bankbookDTO.setBookRate(1.01);
		bankbookDTO.setBookSale(1);
		int result = bankbookDAO.setUpdate(bankbookDTO);
		
		assertNotEquals(0, result);
	}
	
	
//	@Test
	public void setDeleteTest() {
		int result = bankbookDAO.setDelete(69L);
		assertEquals(68, result);
	}
	
//	@Test - ?
	public void getListTest() {
		Pager pager = new Pager();
		pager.setPn(1L);
		pager.makeNum(null);
		pager.makeRow();
		List<BankbookDTO> ar = bankbookDAO.getList(pager);
		assertNotEquals(0, ar.size());
	}
	
	
	@Test
	public void setInsertTest() throws Exception {
		Random random = new Random();
		
		for(int i=0;i<200;i++) {		
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookName("BookName"+i);
		int rate = random.nextInt(400);  // 0이상~400미만의 정수를 랜덤하게 뽑아오겠다
		
		bankbookDTO.setBookRate(rate/100.0);
		bankbookDTO.setBookSale(random.nextInt(2));
		int result = bankbookDAO.setInsert(bankbookDTO);
		
		if(i%10==0) {
			Thread.sleep(500); //10번마다 한번씩 쉬면서 자라는 의미. 매개변수로는 Milliseconds. 10개 집어넣고 0.5초 기다렸다 다시 집어넣고.. (반복)
		}
		
		}
		System.out.println("======= F i n i s h ========");
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
//	public void getListTest() {
//		List<BankbookDTO> ar = bankbookDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
}
