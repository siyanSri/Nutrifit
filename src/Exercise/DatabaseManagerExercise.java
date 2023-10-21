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
    	
    
        String insertSQL = "INSERT INTO exercise (idExercise,Type,Duration,Intensity,doe) VALUES (?, ?, ?, ?, ?)";
        Random rand = new Random(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dom = dateFormat.format(user.getDate());

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setInt(1, rand.nextInt(50));
            preparedStatement.setString(2, user.getExerciseType());
            preparedStatement.setFloat(3, user.getExerciseDuration());
            preparedStatement.setString(4, user.getExerciseIntensity());
            preparedStatement.setString(5, dom);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
