package Exercise;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

import connection.DatabaseAdapter;
import connection.DatabaseContext;
import connection.DatabaseStrategy;
import connection.MySqlConnectionStrategy;


 /**
 * The class Database manager exercise
 */ 
public class DatabaseManagerExercise{
	private DatabaseContext context = new DatabaseContext();


	private String username ;
	private String password ;
    
    DatabaseManagerExercise() {
    	username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
    }
    

/** 
 *
 * Creates entry for user exercise
 *
 * @param user  the user. 
 */
    public void create(UserExerciseData user){ 

    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dom = dateFormat.format(user.getDate());
		String insertSQL = "INSERT INTO exercise (Type, Duration, Intensity, doe, name, cals) VALUES ('" + 
	            user.getExerciseType() + "', '" + user.getExerciseDuration() + "', '" + 
	            user.getExerciseIntensity() + "', '" + dom + "', '" + user.getName() + "', '" + user.getCals() + "')";

		context.executeDatabaseOperations(username, password, insertSQL);
    }
}
