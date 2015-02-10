package topic5;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

import connection.DBConnection;
import services.MySqlConnection;

public class App {
	public static void main(String[] args) {
		DBConnection myConn;
		CallableStatement callableStatement;

		myConn = new MySqlConnection("localhost", "high-school", "root", "root");
		try {
			// exercice 4
			myConn.connect();
			String course = "Vestibulum";
			String getTeacherSQL = "{call getTeacher(?,?,?)}";
			callableStatement = (CallableStatement) myConn.getConnection().prepareCall(getTeacherSQL);
			callableStatement.setString(1, course);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

			callableStatement.executeUpdate();
			String firstName = callableStatement.getString(2);
			String lastName = callableStatement.getString(3);

			String getStudentsSQL = "{call getStudentsFromCourse(?)}";
			callableStatement = (CallableStatement) myConn.getConnection().prepareCall(getStudentsSQL);
			callableStatement.setString(1, course);

			callableStatement.execute();
			ResultSet rs = callableStatement.getResultSet();

			System.out.println("Course: " + course);
			System.out.println("Teacher: " + lastName + ", " + firstName);
			while (rs.next()) {
				System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name"));
			}

			// exercice 5
			int regNumber = 5980;
			String getStudentIDSQL = "{call getStudentIdByRegNumber(?,?)}";
			callableStatement = (CallableStatement) myConn.getConnection().prepareCall(getStudentIDSQL);
			callableStatement.setInt(1, regNumber);
			callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callableStatement.executeUpdate();
			int studentId = callableStatement.getInt(2);

			String getStudentsNotesSQL = "{call getStudentFinalNote(?)}";
			callableStatement = (CallableStatement) myConn.getConnection().prepareCall(getStudentsNotesSQL);
			callableStatement.setInt(1, studentId);

			callableStatement.execute();
			ResultSet rs2 = callableStatement.getResultSet();

			System.out.println("Student registration number: " + regNumber);
			while (rs2.next()) {
				System.out.println("final note: " + rs.getString("final_note"));
			}

			myConn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
