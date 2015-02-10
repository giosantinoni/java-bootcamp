package services;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.DBConnection;

public final class MySqlConnection extends DBConnection {

	public MySqlConnection() {
		System.out.println("MySqlConnection Constructor");
	}

	public MySqlConnection(String user, String password) {
		super(user, password);
	}

	public MySqlConnection(String servidor, String database, String user, String password) {
		super(servidor, database, user, password);
	}

	@Override
	public void connect() throws SQLException, ClassNotFoundException {
		System.out.println("Conectando ...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + getServidor() + "/" + getDatabase();
			setConnection(DriverManager.getConnection(url, getUser(), getPassword()));
			setStatement(getConnection().createStatement());
		} catch (ClassNotFoundException ex) {
			System.err.println("DB Class Driver not found.");
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error in driver db...", "WARNING", JOptionPane.ERROR_MESSAGE);
			throw (ex);
		} catch (SQLException ex) {
			System.err.println("Error in database connection");
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Connection error...", "WARNING", JOptionPane.ERROR_MESSAGE);
			throw (ex);
		}
	}

	@Override
	public void close() {
		try {
			getConnection().close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error closing the database...", "WARNING", JOptionPane.ERROR_MESSAGE);
		}
	}
}
