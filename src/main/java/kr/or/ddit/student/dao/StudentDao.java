package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDao implements StudentDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다.
	*/
	@Override
	public List<StudentVo> selectAllStudents() {
		return template.selectList("student.selectAllStudents");
	}

	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : id에 맞는 학생 정보 조회
	*/
	@Override
	public StudentVo getStudent(int id) {
		StudentVo studentVo = template.selectOne("student.getStudent", id);
		return studentVo;
	}

	
	/**
	* Method : getStudent2
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : id와 이름에 맞는 학생 정보 조회
	*/
	@Override
	public StudentVo getStudent2(StudentVo studentVo) {
		StudentVo studentInfo = template.selectOne("student.getStudent", studentVo);
		return studentInfo;
	}

	
	/**
	* Method : getStudentList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	@Override
	public List<StudentVo> getStudentList(Map<String, Integer> map) {
		List<StudentVo> studentList = template.selectList("student.getStudentList", map);
		return studentList;
	}


	/**
	* Method : getStudentTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 수 조회
	*/
	@Override
	public int getStudentTotCnt() {
		int cnt = template.selectOne("student.getStudentTotCnt");
		return cnt;
	}


	/**
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC17
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생정보 업데이트
	*/
	@Override
	public int studentUpdate(StudentVo studentVo) {
		int updateCnt = template.update("student.studentUpdate", studentVo);
		return updateCnt;
	}
	
	
	
	
	

}
