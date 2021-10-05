package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.common.JDBCTemplate;
import web.dao.face.MemberDao;
import web.dao.impl.MemberDaoImpl;
import web.dto.Member;
import web.service.face.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member getJoinMember(HttpServletRequest req) {

		Member member = new Member();
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String usernick = req.getParameter("usernick");
		
		if(userid != null && !"".equals(userid)) {
			member.setUserid(userid);
		}
		
		if(userpw != null && !"".equals(userpw)) {
			member.setUserpw(userpw);
		}
		
		if(usernick != null && !"".equals(usernick)) {
			member.setUsernick(usernick);
		}
		
		return member;
	}
		
	@Override
	public void join(Member member) {
		
		int result = 0;
		result = memberDao.insert(JDBCTemplate.getConnection(), member);
		
		if( result > 0 ) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		
		}
	}	

	@Override
	public Member getLoginMember(HttpServletRequest req) {
		
		Member member = new Member();
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if(userid != null && !"".equals(userid)) {
			member.setUserid(userid);
		}
		
		if(userpw != null && !"".equals(userpw)) {
			member.setUserpw(userpw);
		}
		
		return member;
	}
	
	@Override
	public boolean login(Member member) {
		
		if(memberDao.selectCntMemberByUseridUserpw(JDBCTemplate.getConnection(), member) > 0) {
			return true;
		} else {
			return false;
		}
	
	
	}
	
	@Override
	public Member info(Member member) {
		return memberDao.selectMemberByUserid(JDBCTemplate.getConnection(), member);
	}
}
