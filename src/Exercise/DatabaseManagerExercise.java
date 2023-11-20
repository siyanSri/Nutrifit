package Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

import connection.DatabaseContext;
import connection.MySqlConnectionStrategy;

public class DatabaseManagerExercise{
	private DatabaseContext context = new DatabaseContext();

	private DatabaseAdapter sql = new SqlAdapter();
	private Connection connection;
	
	private String username ;
	private String password ;
    
    DatabaseManagerExercise() {
    	username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
    	System.out.println(username+password);
    }
    public void connect() {
    	connection = sql.connect(username,password);
    }
    public void create(UserExerciseData user){
    	
    
        String insertSQL = "INSERT INTO exercise (Type,Duration,Intensity,doe,name,cals) VALUES (?, ?, ?, ?, ?, ?)";
        Random rand = new Random(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dom = dateFormat.format(user.getDate());

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, user.getExerciseType());
            preparedStatement.setFloat(2, user.getExerciseDuration());
            preparedStatement.setString(3, user.getExerciseIntensity());
            preparedStatement.setString(4, dom);
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getCals());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
