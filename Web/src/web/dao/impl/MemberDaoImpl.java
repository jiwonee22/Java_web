package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.common.JDBCTemplate;
import web.dao.face.MemberDao;
import web.dto.Member;

public class MemberDaoImpl implements MemberDao {
	
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //조회결과 객체
	
	@Override
	public int insert(Connection conn, Member memberinfo) {
		
		String sql = "";
		sql += "INSERT INTO member (userid, userpw, usernick)";
		sql += " VALUES(?, ?, ?)";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberinfo.getUserid());
			ps.setString(2, memberinfo.getUserpw());
			ps.setString(3, memberinfo.getUsernick());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

}
