package Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DatabaseManagerExercise{

	private DatabaseAdapter sql = new SqlAdapter();
	private Connection connection;
	
	private String username ;
	private String password ;
    
    DatabaseManagerExercise() {
    	username = System.getenv("NAME");
    	password = System.getenv("PASS");
    	System.out.println(username+password);
    }
    public void connect() {
    	connection = sql.connect(username,password);
    }
    public void create(UserExerciseData user){
    	
    
        String insertSQL = "INSERT INTO exercise (Type,Duration,Intensity,doe) VALUES (?, ?, ?, ?)";
        Random rand = new Random(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dom = dateFormat.format(user.getDate());

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, user.getExerciseType());
            preparedStatement.setFloat(2, user.getExerciseDuration());
            preparedStatement.setString(3, user.getExerciseIntensity());
            preparedStatement.setString(4, dom);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
