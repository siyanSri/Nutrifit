package Profile;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnectionStrategy implements DatabaseStrategy {
	private static Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	MySqlConnectionStrategy(){
		connection = null;
	}

	@Override
	public Connection connect(String username, String password) {
		if (connection == null) {
			try {
				String url1 = "jdbc:mysql://localhost:3306/userprofile";
				connection = DriverManager.getConnection(url1,username,password);
				System.out.println("Connected");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	@Override
	public void executeQuery(Connection connection, String sql) {
	    Statement stmt = null;

	    try {
	        stmt = connection.createStatement();
	        
	        // Use execute for non-query statements
	         stmt.executeUpdate(sql);
	        
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



	@Override
	public ResultSet getResult(Connection connection) {
		return resultSet;
		// Implement result retrieval for MySQL
	}

	@Override
	public void close(Connection connection) {
		// Implement closing logic for MySQL
	}
}


