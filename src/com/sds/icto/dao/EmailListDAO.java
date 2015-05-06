package com.sds.icto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.vo.EmailListVO;

public class EmailListDAO {

	private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String id = "webdb";
	private final String password = "webdb";

	public void getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insert(EmailListVO vo) {

		getConnection();
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into EMAIL_LIST VALUES(EMAIL_LIST_NO_SEQ.nextval, ?, ?, ?)";

		try {
			System.out.println(url + " : " + id + " : " + password);
			con = DriverManager.getConnection(url, id, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
			int rowCount = pstmt.executeUpdate();

			System.out.println(rowCount + "건이 입력되었습니다.");
			
			return rowCount;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return 0;
	}
	
	public List<EmailListVO> fetchList(){
		
		List<EmailListVO> list = new ArrayList<EmailListVO>();
		
				
		
				
		return list;
	}
}