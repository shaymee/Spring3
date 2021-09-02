package com.shaymee.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.shaymee.s1.bankbook.BankbookDAO.";
	
	///// setDelete /////
	public int setDelete(Long bookNumber) {
		return sqlSession.delete(NAMESPACE+"setDelete", bookNumber);
	}
	
	///// setInsert /////
	public int setInsert(BankbookDTO bankbookDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert", bankbookDTO);
	}
	
	///// getList /////
	public List<BankbookDTO> getList(){
		return sqlSession.selectList(NAMESPACE+"getList");	
	}
	
	///// getSelect /////
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {		
		return sqlSession.selectOne(NAMESPACE+"getSelect", bankbookDTO);		
	}
	
}
