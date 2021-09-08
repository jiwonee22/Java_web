package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {

	/**
	 * 테이블 전체 조회
	 * 
	 * @return 테이블을 조회한 전체 목록
	 */
	public List<User> selectAll();

	
	/**
	 * 새로운 유저정보 삽입하기
	 * 
	 * @param insertUser - DB에 삽입할 신규 유저 정보 DTO객체
	 */
	public void insertUser(User insertUser);


	/**
	 * 인덱스를 이용해서 유저 정보 조회하기
	 * 
	 * @param idx - 조회하려는 유저의 인덱스
	 * @return 인덱스로 조회한 유저의 정보 DTO객체, 조회 대상이 없으면 null을 반환한다
	 */
	public User selectByIdx(int idx);


	/**
	 * 인덱스를 이용해서 유저 정보 삭제하기
	 * 
	 * @param idx - 삭제하려는 유저의 인덱스
	 */
	public void deleteByIdx(int idx);
	
	

}
