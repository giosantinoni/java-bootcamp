package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public abstract class DBConnection {
	private Connection connection;
	private Statement statement;
	private String server = "localhost";
	private String database = "paradigmas";
	private String user = "root";
	private String password = "";

	public DBConnection() {
		System.out.println("Constructor DBConnection");
	}

	public DBConnection(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public DBConnection(String servidor, String database, String user, String password) {
		this.server = servidor;
		this.database = database;
		this.user = user;
		this.password = password;
	}

	public void cerrar() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException ex) {
			System.err.println("failure to close the connection to the database");
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error Close BD...", "WARNING", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error Close ResultSet...", "WARNING", JOptionPane.ERROR_MESSAGE);
		}
	}

	public abstract void connect() throws SQLException, ClassNotFoundException;

	public Connection getConnection() {
		return connection;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public String getServidor() {
		return server;
	}

	public Statement getStatement() {
		return statement;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
