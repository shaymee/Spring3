package com.shaymee.s1;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DataSourceTest extends MyJunitTest {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSession sqlSession; 
	
	@Test
	public void test() throws Exception {
		assertNotNull(dataSource.getConnection());
	}
	
	@Test // @Test라는 annotation을 줘야 실행 됨
	public void sqlSessionTest() {
		assertNotNull(sqlSession);
	}

}
