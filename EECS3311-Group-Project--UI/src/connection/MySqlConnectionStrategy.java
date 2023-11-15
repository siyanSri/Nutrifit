package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnectionStrategy implements DatabaseStrategy {
	private static Connection connection;
    private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public MySqlConnectionStrategy(){
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
        try {
            // Use PreparedStatement for flexibility and to prevent SQL injection
            preparedStatement = connection.prepareStatement(sql);

            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                // For SELECT queries
                this.resultSet = preparedStatement.executeQuery();
            } else {
                // For non-SELECT queries (UPDATE, INSERT, DELETE)
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet getResult(Connection connection) {
        return resultSet;
    }

    @Override
    public void close(Connection connection) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
