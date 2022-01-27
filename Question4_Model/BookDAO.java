package Question4_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;

	// DB 연결기능
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB 연결 종료
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int memberJoin(BookDTO book) {

		connect();

		sql = "insert into book_member values(?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, book.getId());
			psmt.setString(2, book.getPw());
			psmt.setString(3, book.getNick());
			psmt.setString(4, book.getEmail());
			psmt.setString(5, book.getTel());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close();
		}
		return cnt;
	}

	public BookDTO login(String id, String pw) {

		connect();

		BookDTO member = null;
		sql = "select id, pw, nick, email, tel from book_member where id = ? and pw = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String nick = rs.getString("nick");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				member = new BookDTO(id, pw, nick, email, tel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return member;
	}
		
	
}