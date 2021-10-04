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
	public int insert(Connection conn, Member memberinfo);

}
