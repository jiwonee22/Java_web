package service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
	
	/**
	 * 파일 업로드 처리
	 * 
	 * @param req - HTTP요청 정보 객체
	 * @param resp - HTTP응답 정보 객체
	 */
	
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);

}
