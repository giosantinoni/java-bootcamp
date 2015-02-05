package com.globant.topic5.dbmanagement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnection {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/high-school", "root", "password");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();

			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getCourse(String courseName) {
		try {
			preparedStatement = connection.prepareStatement("SELECT s.firstName, s.lastName, t.firstName, t.lastName"
					+ "	FROM Student AS s"
					+ " INNER JOIN Registration r ON r.Student_id = s.id"
					+ " INNER JOIN Course c ON c.id = r.Course_id"
					+ " INNER JOIN Teacher t ON c.Teacher_id = t.id"
					+ " WHERE c.name = ? ORDER BY s.lastName;");
			preparedStatement.setString(1, courseName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet getStudentNotes(String lastName) {
		try {
			preparedStatement = connection.prepareStatement("SELECT s.lastName ,s.firstName, c.name, r.partialNote1, r.partialNote2, r.partialNote3, r.finalNote"
					+ "	FROM Student s"
					+ " INNER JOIN Registration r ON s.id = r.Student_id"
					+ " INNER JOIN Course c ON r.Course_id = c.id"
					+ " WHERE s.lastName = ? ORDER BY 1, 7;");
			preparedStatement.setString(1, lastName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet getStudentNotes(int id) {
		try {
			preparedStatement = connection.prepareStatement("SELECT s.lastName ,s.firstName, c.name, r.partialNote1, r.partialNote2, r.partialNote3, r.finalNote"
					+ "	FROM Student s"
					+ " INNER JOIN Registration r ON s.id = r.Student_id"
					+ " INNER JOIN Course c ON r.Course_id = c.id"
					+ " WHERE s.id = ? ORDER BY 1, 7;");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet getCourseStatistics(String courseName) {
		try {
			preparedStatement = connection.prepareStatement("call course_statistics (?);");
			preparedStatement.setString(1, courseName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet getTeacherTimeLine(int teacherId) {
		try {
			preparedStatement = connection.prepareStatement("SELECT t.firstName, t.lastName, c.name, s.day, s.startTime, s.endTime"
					+ "	FROM Teacher t"
					+ " INNER JOIN Course c ON t.id = c.Teacher_id"
					+ " INNER JOIN `Schedule` s ON c.id = s.Course_id"
					+ " WHERE t.id = ? ORDER BY 4;");
			preparedStatement.setInt(1, teacherId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
