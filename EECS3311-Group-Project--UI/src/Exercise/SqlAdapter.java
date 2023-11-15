package Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlAdapter implements DatabaseAdapter {
    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    SqlAdapter(){
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
    public void executeQuery(String sql) {
    }

    @Override
    public ResultSet getResult() {
		return resultSet;
        
    }

    @Override
    public void close() {
    }
}
