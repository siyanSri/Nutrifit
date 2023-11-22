package connection;

import java.sql.Connection;
import java.sql.ResultSet;


 /**
 * The class Database context
 */ 
public class DatabaseContext {
    private DatabaseStrategy databaseStrategy;
    private Connection connection;


/** 
 *
 * Sets the database strategy
 *
 * @param strategy  the strategy. 
 */
    public void setDatabaseStrategy(DatabaseStrategy strategy) { 

        this.databaseStrategy = strategy;
    }


/** 
 *
 * Execute database operations
 *
 * @param username  the username. 
 * @param password  the password. 
 * @param statement  the statement. 
 * @return ResultSet
 */
    public ResultSet executeDatabaseOperations(String username, String password, String statement) { 

        this.connection = databaseStrategy.connect(username, password);
        databaseStrategy.executeQuery(connection, statement);
        ResultSet result = databaseStrategy.getResult(connection);
		return result;
    }


/** 
 *
 * Close Connection
 *
 */
    public void close() { 
    	databaseStrategy.close(this.connection);
    }
    
}