package Meal;

import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseContext {
    private DatabaseStrategy databaseStrategy;

    public void setDatabaseStrategy(DatabaseStrategy strategy) {
        this.databaseStrategy = strategy;
    }

    public void executeDatabaseOperations(String username, String password, String statement) {
        Connection connection = databaseStrategy.connect(username, password);
        databaseStrategy.executeQuery(connection, statement);
        //ResultSet result = databaseStrategy.getResult(connection);
        // Process the result as needed
        //databaseStrategy.close(connection);
    }
}
