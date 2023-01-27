package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_user {
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

	public boolean login(DTO_user dto) {
		boolean res = false;
		getCon();
		
		try {
			String sql = "select * from user_info where id =? and pw =?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			
			rs = psmt.executeQuery();
			res = rs.next();
		} catch (SQLException e) {
			System.out.println("일단 오류");
			e.printStackTrace();
		}finally {
			getClose();
		}
		return res;
	}
	
	public int join(DTO_user dto) {
		int row = 0;
		
		getCon();
		try {
			String sql = "insert into user_info (id, pw, name)"
					+ "values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ID가 중복되었습니다.");
//			e.printStackTrace();
		}	
		finally {
			getClose();
		}
		return row;
	}
	public int scoreInput(DTO_user dto4) {
		int row = 0;
		getCon();
		try {
			String sql = "update user_info set score = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto4.getScore());
			psmt.setString(2, dto4.getLoginID());
			row = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return row;
	}
	public int maxScore(DTO_user dto4) {
		int row = 0;
		getCon();
		try {
			String sql = "update user_info set max = ? where id = ? and (max is null or max < score)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto4.getScore());
			psmt.setString(2, dto4.getLoginID());
			row = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return row;
	}
	public ArrayList<DTO_user> rank() {
		ArrayList<DTO_user> list = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * from ( select * from user_info where max is not null order by max desc) Where rownum <=5";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int max = rs.getInt("max");
				
				DTO_user dto = new DTO_user(id, name, max);

				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return list;
	}
	public DTO_user myRank(DTO_user dto4) {
		getCon();
		
		try {
			String sql = "select * from user_info where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto4.getLoginID());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				int max = rs.getInt("max");
				
				dto4 = new DTO_user(id, name, max);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();

		}
		return dto4;
	}
	
	
	
	
	
}
