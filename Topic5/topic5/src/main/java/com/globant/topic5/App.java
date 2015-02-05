package com.globant.topic5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globant.topic5.dbmanagement.MySQLConnection;
import com.globant.topic5.model.Course;
import com.globant.topic5.model.Teacher;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<Course> courses = new ArrayList<Course>();

		MySQLConnection conn = new MySQLConnection();

		/*
		 * Exercise 4
		 */
		conn.init();
		String courseName = "Physics 1";
		ResultSet rs = conn.getCourse(courseName);
		try {
			System.out.println("Course: " + courseName);
			boolean flag = true;
			while (rs.next()) {

				if (flag) {
					String teacher = rs.getString("t.lastName") + ", " + rs.getString("t.firstName");
					System.out.println("Teacher: " + teacher + "\n Students:");
					flag = false;
				}
				System.out.println("\t" + rs.getString("lastName") + ", " + rs.getString("firstName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		
		/*
		 * Exercise 5 - 1
		 */
		conn.init();
		String lastName = "Muntz";
		rs = conn.getStudentNotes(lastName);
		try {
			boolean flag = true;
			while (rs.next()) {

				if (flag) {
					String student = rs.getString("s.lastName") + ", " + rs.getString("s.firstName");
					System.out.println("Student: " + student + "\n Notes:");
					flag = false;
				}
				System.out.println("\t" + rs.getString("c.name") + ": " + rs.getString("r.partialNote1") + " "
						+ rs.getString("r.partialNote2") + " " + rs.getString("r.partialNote3") + " Final Note: "
						+ rs.getString("r.finalNote"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		
		/*
		 * Exercise 5 - 2
		 */
		conn.init();
		int studentId = 9;
		rs = conn.getStudentNotes(studentId);
		try {
			boolean flag = true;
			while (rs.next()) {

				if (flag) {
					String student = rs.getString("s.lastName") + ", " + rs.getString("s.firstName");
					System.out.println("Student: " + student + "\n Notes:");
					flag = false;
				}
				System.out.println("\t" + rs.getString("c.name") + ": " + rs.getString("r.partialNote1") + " "
						+ rs.getString("r.partialNote2") + " " + rs.getString("r.partialNote3") + " Final Note: "
						+ rs.getString("r.finalNote"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		
		/*
		 * Exercise 6
		 */
		conn.init();
		courseName = "Physics 1";
		rs = conn.getCourseStatistics(courseName);
		try {
			System.out.println("Course: " + courseName);
			while (rs.next()) {
				System.out.println("Passed: " + rs.getFloat("passed"));
				System.out.println("Passed: " + rs.getFloat("failed"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
