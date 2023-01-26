package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_sing {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@gjaischool-b.ddns.net:1525:xe";
			String user = "campus_d_0120_1";
			String password = "smhrd1";
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB접속 실패");
			e.printStackTrace();
		}
	}
	public void getClose() {
		
		try {
			if(rs != null)
			rs.close();
			if(psmt != null)
			psmt.close();
			if(conn != null)
			conn.close();
		} catch (SQLException e) {
			System.out.println("닫는 순서 오류");
			e.printStackTrace();
		}
	}

	// 음악 퀴즈
	public DTO_sing musicQuiz(DTO_sing dto) {
		getCon();
		
		try {
			String sql = "select * from ( select * from sing_info where type1 = ? and point1= ? order by DBMS_RANDOM.RANDOM) where rownum < 2";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getType1());
			psmt.setInt(2, dto.getPoint1());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String singer = rs.getString("singer");
				String file1 = rs.getString("file1");
				int type1 = rs.getInt("type1");
				int point1 = rs.getInt("point1");
				String hint = rs.getString("hint");
				
				dto = new DTO_sing(title,singer,file1,type1,point1,hint);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();

		}
		return dto;
		
		
	}
	
	
	
	
	
}
