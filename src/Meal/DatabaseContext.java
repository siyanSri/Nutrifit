package Meal;

import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseContext {
    private DatabaseStrategy databaseStrategy;

    public void setDatabaseStrategy(DatabaseStrategy strategy) {
        this.databaseStrategy = strategy;
    }

    public ResultSet executeDatabaseOperations(String username, String password, String statement) {
        Connection connection = databaseStrategy.connect(username, password);
        databaseStrategy.executeQuery(connection, statement);
        ResultSet result = databaseStrategy.getResult(connection);
		return result;
    }
    
}
