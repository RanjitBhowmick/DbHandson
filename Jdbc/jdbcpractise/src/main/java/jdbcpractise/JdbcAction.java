package jdbcpractise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.CallableStatement;

public class JdbcAction {

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void createConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "admin");
		System.out.println("Creating connection!!");
	}

	public void showData() throws Exception {
		stmt = conn.createStatement();
		rs = stmt.executeQuery("Select * from department");
		while (rs.next()) {
			System.out.println();
			System.out.print("  " + rs.getInt("empid"));
			System.out.print("  " + rs.getString("deptname"));
			System.out.print("  " + rs.getString("deptaddress"));
			System.out.print("  " + rs.getString("deptincharge"));
		}
	}

	public void updateData() throws Exception {
		pstmt = conn.prepareStatement("UPDATE department SET deptincharge=? where empid=?");
		pstmt.setString(1, "Karan");
		pstmt.setString(2, "1");
		int rows = pstmt.executeUpdate();
		System.out.println("Rows impacted : " + rows);
	}

	public void showDataProcedure() throws Exception {
		CallableStatement cstmt=conn.prepareCall("{call showData()}");
		rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.println();
			System.out.print("  " + rs.getInt("empid"));
			System.out.print("  " + rs.getString("deptname"));
			System.out.print("  " + rs.getString("deptaddress"));
			System.out.print("  " + rs.getString("deptincharge"));
		}
	}

	public void closeConnection() throws Exception {
		System.out.println("Closing connection!!");
		conn.close();
	}

}
