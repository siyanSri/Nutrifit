package connection;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DatabaseAdapter {
    Connection connect(String username, String password);
    void executeQuery(String sql);
    ResultSet getResult();
    void close();
}

