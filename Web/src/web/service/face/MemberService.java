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

	/**
	 * 요청 파라미터 얻기
	 * 
	 * @param req - 요청 정보
	 * @return - 전달 파라미터를 저장한 객체
	 */
	public Member getLoginMember(HttpServletRequest req);
	
	/**
	 * 
	 * 
	 * @param member
	 * @return true 로그인 성공, false 로그인 실패
	 */
	public boolean login(Member member);

	



}
