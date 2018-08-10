package kr.or.ddit.aop.dao;

import java.util.List;
import java.util.Map;

public interface TempDaoInf {
	
	public List getAllStudent();

	public int insertStudent(Map<String, String> map);

}
