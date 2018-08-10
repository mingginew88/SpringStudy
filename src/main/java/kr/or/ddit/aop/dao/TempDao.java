package kr.or.ddit.aop.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("tempDao")
public class TempDao implements TempDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	@Override
	public List getAllStudent() {
		return template.selectList("temp.getAllStudent");
	}


	@Override
	public int insertStudent(Map<String, String> map) {
		return template.insert("temp.insertStudent", map);
	}

}
