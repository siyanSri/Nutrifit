package Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DatabaseManager {

	private DatabaseAdapter sql = new SqlAdapter();
	private Connection connection;
	
	private String username ;
	private String password ;
    
    DatabaseManager() {
    	username = System.getenv("NAME");
    	password = System.getenv("PASS");
    	System.out.println(username+password);
    }
    public void connect() {
    	connection = sql.connect(username,password);
    }
    public void create(UserProfile user){
    	
    	

        String insertSQL = "INSERT INTO profiles (idProfiles, dof, height, weight, sex) VALUES (?, ?, ?, ?, ?)";
        Random rand = new Random(); 
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dof = dateFormat.format(user.getDof());
            preparedStatement.setInt(1, rand.nextInt(50));
            preparedStatement.setString(2, dof);
            preparedStatement.setFloat(3, user.getHeight());
            preparedStatement.setFloat(4, user.getWeight());
            preparedStatement.setString(5, String.valueOf(user.getSex()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
