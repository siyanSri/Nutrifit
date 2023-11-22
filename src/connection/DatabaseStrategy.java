package connection;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DatabaseStrategy {
    Connection connect(String username, String password);
    void executeQuery(Connection connection, String sql);
    ResultSet getResult(Connection connection);
    void close(Connection connection);
}
