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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/high-school", "root", "note123++");
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
					+ "	FROM Course AS c, Student AS s, Teacher AS t, Registration AS r WHERE"
					+ "    c.id=r.Course_id AND r.Student_id=s.id AND c.Teacher_id=t.id AND c.name = ? " + "ORDER BY s.lastName;");
			preparedStatement.setString(1, courseName);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}

	public void executeInsert(Object object, String tableName, Field[] fields) {
		String query = "INSERT into ? VALUES (";

		int length = fields.length;
		for (int i = 0; i < length; i++) {
			query += "?";

			if (i != length - 1)
				query += ", ";
			else
				query += ")";
		}

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, tableName);

			int counter = 2;

			for (Field field : fields) {
				preparedStatement.setString(counter, field.get(object).toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getStudentNotes(String lastName) {
		try {
			preparedStatement = connection.prepareStatement("SELECT s.lastName, s.firstName, c.name, r.partialNote1,"
					+ " r.partialNote2, r.partialNote3, r.finalNote	FROM Student AS s, Course AS c, Registration AS r WHERE"
					+ "    s.lastName = ? AND s.id = r.Student_id AND r.Course_id = c.id ORDER BY 1,7;");
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
			preparedStatement = connection.prepareStatement("SELECT s.lastName, s.firstName, c.name, r.partialNote1,"
					+ " r.partialNote2, r.partialNote3, r.finalNote	FROM Student AS s, Course AS c, Registration AS r WHERE"
					+ "    s.id = ? AND s.id = r.Student_id AND r.Course_id = c.id ORDER BY 1,7;");
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
			preparedStatement = connection.prepareStatement("SELECT t.firstName, t.lastName, c.name, s.day, s.startTime, s.endTime "
					+ "FROM Teacher AS t, Course AS c, `Schedule` AS s WHERE"
					+ " t.id = ? AND t.id = c.Teacher_id AND c.id = s.Course_id order by 4;");
			preparedStatement.setInt(1, teacherId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
