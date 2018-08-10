package kr.or.ddit.aop.service;

import static org.junit.Assert.*;

import java.util.HashMap;
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
public class TempServiceTest {
	
	private Logger logger = LoggerFactory.getLogger(TempServiceTest.class);
	
	@Resource(name="tempService")
	private TempServiceInf tempService;
	

	@Test
	public void tempServiceTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(tempService);
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
		int insert = tempService.insertStudent(map);
		
		/***Then***/
		assertEquals(1, insert);
	}
	
	
	
	
	

}
