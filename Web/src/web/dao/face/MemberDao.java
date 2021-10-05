package web.dao.face;

import java.sql.Connection;

import web.dto.Member;

public interface MemberDao {
	
	/** 
	 * DB에 회원정보 삽입
	 * 
	 * @param conne - DB연결
	 * @param memberinfo - insert할 객체
	 * @return
	 */
	public int insert(Connection conn, Member member);
	
	/**
	 * DB에서 아이디, 비밀번호 조회
	 * 
	 * @param conn
	 * @param member
	 * @return 
	 */
	public int selectCntMemberByUseridUserpw(Connection conn, Member member);
	
	/**
	 * userid를 이용해 회원정보 조회
	 * 
	 * @param member - 조회할 회원
	 * @return Member - 조회된 결과 객체
	 */
	public Member selectMemberByUserid(Connection Conn, Member member);

}
