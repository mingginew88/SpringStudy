package kr.or.ddit.aop.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.aop.dao.TempDaoInf;

@Service("tempService")
public class TempService implements TempServiceInf{
	
	@Resource(name="tempDao")
	private TempDaoInf tempDao;
	

	@Override
	public int insertStudent(Map<String, String> map) throws RuntimeException{
		int insertCnt = 0;
		
		//첫번째 학생 입력
		insertCnt += tempDao.insertStudent(map);
		
		//첫번째 학생 입력 후 강제 예외 발생
		throw new RuntimeException();
		
		
		
//		map.put("id", "199");
//		insertCnt += tempDao.insertStudent(map);
//		return insertCnt;
	}

}
