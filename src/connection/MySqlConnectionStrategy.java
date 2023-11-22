package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 /**
 * MySQL connection strategy implements database strategy
 */ 
public class MySqlConnectionStrategy implements DatabaseStrategy {
	private static Connection connection;
    private PreparedStatement preparedStatement;
	private ResultSet resultSet;


/** 
 *
 * MySQL connection strategy
 *
 * @return 	public
 */
	public MySqlConnectionStrategy(){ 
		connection = null;
	}

	@Override

/** 
 *
 * Connection to database
 *
 * @param username  the username. 
 * @param password  the password. 
 * @return Connection
 */
	public Connection connect(String username, String password) { 

		if (connection == null) {
			try {
				String url1 = "jdbc:mysql://localhost:3306/userprofile"; //Change according to database link
				connection = DriverManager.getConnection(url1,username,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

    @Override

/** 
 *
 * Execute query
 *
 * @param connection  the connection. 
 * @param sql  the sql. 
 */
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override

/** 
 *
 * Gets the result
 *
 * @param connection  the connection. 
 * @return the result
 */
    public ResultSet getResult(Connection connection) { 

        return resultSet;
    }

    @Override

/** 
 *
 * Close Conection
 *
 * @param connection  the connection. 
 */
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
