package com.shaymee.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shaymee.s1.util.Pager;

@Repository
public class BankbookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.shaymee.s1.bankbook.BankbookDAO.";
	
	
	public int setUpdate(BankbookDTO bankbookDTO) {
		return sqlSession.update(NAMESPACE+"setUpdate", bankbookDTO);
		//" NAMESPACE주소의 setUpdate id를 가진 애를 실행하자. 그리고 parameter로 bankbookDTO를 보내주자" ((중요함))
	}
	
	///// setDelete /////
	public int setDelete(Long bookNumber) {
		return sqlSession.delete(NAMESPACE+"setDelete", bookNumber);
	}
	
	///// setInsert /////
	public int setInsert(BankbookDTO bankbookDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert", bankbookDTO);
	}
	
	///// getList /////
	public List<BankbookDTO> getList(Pager pager){
		return sqlSession.selectList(NAMESPACE+"getList", pager);	
	}
	
	///// getSelect /////
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {		
		return sqlSession.selectOne(NAMESPACE+"getSelect", bankbookDTO);		
	}
	
	//// totalCount 구해오기 ////
	public Long getTotalCount(Pager pager) { // Mapper의 id 속성은 DAO의 method명과 동일하게 설정
		Long result = sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
		
		return result;
	}
	
}
