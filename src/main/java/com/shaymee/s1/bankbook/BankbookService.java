package com.shaymee.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaymee.s1.util.Pager;

@Service
public class BankbookService {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	///// setUpdate /////
	public int setUpdate(BankbookDTO bankbookDTO) {
		return bankbookDAO.setUpdate(bankbookDTO);
	}
	
	///// setDelete /////
	public int setDelete(Long bookNumber) {
		return bankbookDAO.setDelete(bookNumber);
	}
	
	///// getSelect /////
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		return bankbookDAO.getSelect(bankbookDTO);
	}
	
	///// getList /////
	public List<BankbookDTO> getList(Pager pager){ //service메서드의 역할 - 전처리and후처리 작업
		System.out.println("kind: "+pager.getKind());
		System.out.println("search: "+pager.getSearch());
		//totalCount 구해오기
		Long totalCount = bankbookDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return bankbookDAO.getList(pager);
	}
	
	///// setInsert /////
	public int setInsert(BankbookDTO bankbookDTO) {
		return bankbookDAO.setInsert(bankbookDTO);
	}
	
}
