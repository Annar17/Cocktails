package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mainpackage.userspackage.Users;

public class DatabaseProcedures { //DAO

	private final String url = "jdbc:postgresql://localhost:5432/Cocktails";
	private final String user = "postgres";
	private final String password = "anna123";
	private final String dbDriver = "org.postgresql.Driver";

	public DatabaseProcedures() {	}

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public String insertUser(Object user) {

		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "User has been inserted successfully!";
		String query = "INSERT INTO users(username, email, password, dateofbirth, category) VALUES (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, ((Users) user).getUsername());
			ps.setString(2, ((Users) user).getEmail());
			ps.setString(3, ((Users) user).getPassword());
			ps.setString(4, ((Users) user).getDateOfBirth());
			ps.setString(5, ((Users) user).getCategory());

			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			result = "User insertion failed! \r\nCheck the database connection or check if there is already a client with the same email!";
			e.printStackTrace();
		}
		return result;
	}

	public boolean loginValidation(String email, String password) {

		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		boolean result = false;
		String query = "SELECT email, password FROM users WHERE email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if ( resultSet.next() ) {
				String pass = resultSet.getString("password");
				if(pass.equals(password)) {
					result = true;
				}
				else {
					result = false;
				}
		    }
			else {
				result = false;
			}

			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getUsername(String email) {

		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "SELECT email, username FROM users WHERE email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if ( resultSet.next() ) {
				result = resultSet.getString("username");
		    }
			else {
				result = "Failed";
			}

			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getUserCategory(String email) {

		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "SELECT email, category FROM users WHERE email = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet resultSet = ps.executeQuery();

			if ( resultSet.next() ) {
				result = resultSet.getString("category");
			}
			else {
				result = "Failed";
			}

			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
