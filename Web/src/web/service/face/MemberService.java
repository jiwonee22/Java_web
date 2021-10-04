package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;

public interface MemberService {

	
	/**
	 * 요청 파라미터 얻기
	 * 
	 * @param req - 요청 정보
	 * @return - 전달파라미터를 저장한 객체
	 */
	public Member getJoinMember(HttpServletRequest req);

	/**
	 * 멤버 객체 db에 추가
	 * 
	 * @param memberinfo
	 */
	public void join(Member memberinfo);



}
