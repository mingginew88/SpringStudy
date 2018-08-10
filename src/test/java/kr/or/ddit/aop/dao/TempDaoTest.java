package kr.or.ddit.aop.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								"classpath:kr/or/ddit/config/spring/datasource.xml",
								"classpath:kr/or/ddit/config/spring/transaction.xml"})
public class TempDaoTest {
	
	private Logger logger = LoggerFactory.getLogger(TempDaoTest.class);
	
	@Resource(name="tempDao")
	private TempDaoInf tempDao;

	@Test
	public void tempDaoTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(tempDao);
	}
	
	
	//getAllStudent테스트
	@Test
	public void getAllStudentTest(){
		/***Given***/

		/***When***/
		List<Map<String,String>> studentList = (List<Map<String,String>>) tempDao.getAllStudent();
		
		for (Map<String, String> map : studentList)
			logger.debug("{}", map);
		
		
		/***Then***/
		assertEquals(26, studentList.size());
	}
	
	
	//insertStudent 테스트
	@Test
	public void insertStudentTest(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "99");
		map.put("name", "brown");
		map.put("call_cnt", "0");
		
		/***When***/
		int insert = tempDao.insertStudent(map);
		
		/***Then***/
		assertEquals(1, insert);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
