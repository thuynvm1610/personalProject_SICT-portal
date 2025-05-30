package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Teacher;
import util.DBConnect;

public class TeacherDAO {

	public List<Teacher> findAll() {
		String sql = "select * from teacher";
		DBConnect dbConn = new DBConnect();
		List<Teacher> teacherList = new ArrayList<>();
		try {
			Connection conn = dbConn.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherID(rs.getString("teacherID"));
				teacher.setName(rs.getString("name"));
				teacher.setGender(rs.getString("gender"));
				teacher.setDob(rs.getDate("dob"));
				teacher.setEmail(rs.getString("email"));
				teacher.setHometown(rs.getString("hometown"));
				teacherList.add(teacher);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return teacherList;
	}

	public Teacher findById(String teacherID) {
		String sql = "select * from teacher where teacherID = ?";
		DBConnect dbConn = new DBConnect();
		Teacher teacher = null;
		try {
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherID);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherID(rs.getString("teacherID"));
				teacher.setName(rs.getString("name"));
				teacher.setGender(rs.getString("gender"));
				teacher.setDob(rs.getDate("dob"));
				teacher.setEmail(rs.getString("email"));
				teacher.setHometown(rs.getString("hometown"));
			}
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return teacher;
	}

	public boolean insert(Teacher teacher) {
		String sql = "insert into teacher values (?, ?, ?, ?, ?, ?)";
		DBConnect dbConn = new DBConnect();
		try {
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherID());
			pstmt.setString(2, teacher.getName());
			pstmt.setString(3, teacher.getGender());
			pstmt.setDate(4, teacher.getDob());
			pstmt.setString(5, teacher.getEmail());
			pstmt.setString(6, teacher.getHometown());
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Teacher teacher) {
		String sql = "update teacher set name = ?, gender = ?, dob = ?, email = ?, hometown = ? where teacherID = ?";
		DBConnect dbConn = new DBConnect();
		try {
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getGender());
			pstmt.setDate(3, teacher.getDob());
			pstmt.setString(4, teacher.getEmail());
			pstmt.setString(5, teacher.getHometown());
			pstmt.setString(6, teacher.getTeacherID());
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String teacherID) {
		String sql = "delete from teacher where teacherID = ?";
		DBConnect dbConn = new DBConnect();
		try {
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherID);
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isEmailExists(String email, String teacherID) {
		String sql = "select email from teacher where email = ? and teacherID != ? " + "union "
				+ "select email from student where email = ?";
		DBConnect dbConn = new DBConnect();
		try {
			Connection conn = dbConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, teacherID);
			pstmt.setString(3, email);
			ResultSet rs = pstmt.executeQuery();
			boolean result = rs.next();
			conn.close();
			pstmt.close();
			rs.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public int totalTeacher() {
		String sql = "select count(*) from teacher";
		DBConnect dbConn = new DBConnect();
		try {
			Connection conn = dbConn.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1);
			}
			conn.close();
			stmt.close();
			rs.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
