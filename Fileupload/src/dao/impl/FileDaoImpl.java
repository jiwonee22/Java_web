package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.FileDao;
import dto.ParamData;
import dto.UploadFile;

public class FileDaoImpl implements FileDao {
	
	private PreparedStatement ps = null; //SQL수행 객체

	@Override
	public int insertParam(Connection conn, ParamData paramData) {
		String sql = "";
		sql += "INSERT INTO paramdata(datano, title, data1, data2)";
		sql += " VALUES(paramdata_seq.nextval, ?, ?, ?)";
		
		//수행 결과 변수
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paramData.getTitle());
			ps.setString(2, paramData.getData1());
			ps.setString(3, paramData.getData2());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		//최종 수행 결과 반환
		return result;
	}

	@Override
	public int insertFile(Connection conn, UploadFile uploadFile) {
		String sql = "";
		sql += "INSERT INTO uploadfile(fileno, origin_name, stored_name)";
		sql += " VALUES(upload_seq.nextval, ?, ?)";
		
		//수행 결과 변수
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uploadFile.getOriginName());
			ps.setString(2, uploadFile.getOriginName());
		
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		//최종 수행 결과 반환
		return result;
	}
	
	
}
