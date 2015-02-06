package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionManagement {

	private Connection connection;
	private Statement statement;
	private String driver;
	private String protocol;
	private String server;
	private String database;
	private String user;
	private String password;

	public ConnectionManagement() {
		System.out.println("Connection by default: MySql.");
		this.driver = "com.mysql.jdbc.Driver";
		this.protocol = "jdbc:mysql";
		this.server = "localhost";
		this.database = "high-school";
		this.user = "root";
		this.password = "";
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getProtocolo() {
		return protocol;
	}

	public void setProtocolo(String protocolo) {
		this.protocol = protocolo;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Statement getStatement() {
		return statement;
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

	public String getServidor() {
		return server;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public boolean isDriver() {
		try {
			Class.forName(getDriver());
		} catch (ClassNotFoundException ex) {
			return false;
		}
		return true;
	}

	public void connect() throws SQLException, ClassNotFoundException {
		System.out.println("Connecting ...");
		if (isDriver()) {
			String url = getProtocolo() + "://" + getServidor() + "/" + getDatabase();
			try {
				setConnection(DriverManager.getConnection(url, getUser(), getPassword()));
				setStatement(getConnection().createStatement());
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Connection Error...", "WARNING", JOptionPane.ERROR_MESSAGE);
				throw (ex);
			}
		} else {
			System.err.println("Driver not found");
			JOptionPane.showMessageDialog(null, "Database Driver Error...", "WARNING", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error closing the database...", "WARNING", JOptionPane.ERROR_MESSAGE);
		}
	}
}
