package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.UserDao;
import dto.User;

public class UserDaoImpl implements UserDao {

	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";

	//OJDBC	객체
	private static Connection conn = null; //DB연결객체
	private static PreparedStatement ps = null; // SQL수행객체
	private static ResultSet rs = null; //조회결과객체


	//생성자
	public UserDaoImpl() {

		try {

			Class.forName(DRIVER);

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//--- 자동 커밋 설정 ---
			//	-> true - AutoCommit 한다 (기본값)
			//	-> false - AutoCommit 하지 않는다, 직접 commit 또는 rollback 해야함
			conn.setAutoCommit(false);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> selectAll() {

		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " ORDER BY idx";

		List<User> userList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				User user = new User();

				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(rs != null && !rs.isClosed())	rs.close(); //resultSet이 만들어 진적이 있고, 클로즈 된적이 없을 때 rs.close();
				if(ps != null && !ps.isClosed())	ps.close(); //preparedStatement가 만들어 진적이 있고, 클로즈 된적이 없을 때 ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		//--- 최종 결과 리턴 ---
		return userList;
	}

	@Override
	public void insertUser(User insertUser) {

		String sql = "";
		sql += "INSERT INTO userTest (idx, userid, name)";
		sql += " VALUES(userTest_SQ.nextval, ?, ?)";


		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, insertUser.getUserid());
			ps.setString(2, insertUser.getName());

			ps.executeUpdate();
			
			//--- 예외없이 코드 실행했을 경우 커밋 ---
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
	
			//--- 예외가 발생했을 경우 롤백 ---
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {

			try {
				//--- 자원 해제 ---
				if(ps != null && !ps.isClosed())	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	@Override
	public User selectByIdx(int idx) {

		String sql = "";
		sql += "SELECT * FROM userTest";
		sql += " WHERE idx = ?";

		User user = null;

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, idx);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				user = new User();

				user.setIdx(rs.getInt("idx"));
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if(rs != null && !rs.isClosed())	rs.close();
				if(ps != null && !ps.isClosed())	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		return user;
	}
	
	@Override
	public void deleteByIdx(int idx) {
		
		String sql = "";
		sql += "DELETE userTest";
		sql += " WHERE idx = ?";
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, idx);
			
			ps.executeUpdate();
			
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(ps != null && !ps.isClosed())	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}

	}



} //class END
