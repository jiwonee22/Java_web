package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {

	/**
	 * 전달 파라미터 userid, nick, email을 Member객체에 저장
	 * 
	 * @param req - 요청 정보 객체
	 * @return 전달된 데이터를 Member객체에 담아서 반환
	 */
	public Member getParam(HttpServletRequest req);

	/**
	 * 전달 파라미터 member 객체를 dao에 삽입해서 회원가입 처리
	 * 
	 * @param param - 회원 정보 객체
	 * @return DB에 삽입 완료된 회원 정보 객체
	 */
	public Member join(Member param);

}
