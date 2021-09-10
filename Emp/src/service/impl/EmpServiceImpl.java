package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {
	
	//DAO 객체
	private EmpDao empDao = new EmpDaoImpl();
		
	@Override
	public List<Emp> list() {
//		System.out.println("EmpService - list() 호출"); //TEST
		
		//Connection 객체 생성 - JDBC Template 이용
		Connection conn = JDBCTemplate.getConnection();
		
		//Emp테이블 전체 조회 - EmpDao이용
		List<Emp> list = empDao.selectAll(conn);
		
		//조회결과 반환
		return list;
	}

	@Override
	public Emp detail(int empno) {
		System.out.println("EmpService - detail() 호출"); //TEST
		System.out.println("EmpService - empno : " + empno);
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
		//empno를 이용하여 사원 정보 조회 - EmpDao이용
		Emp emp = empDao.selectByEmpno(conn, empno);
		
		//조회결과 반환
		return emp;
	}

}
