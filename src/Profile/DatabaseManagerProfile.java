package Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DatabaseManagerProfile {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;

	DatabaseManagerProfile() {
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}

	public void create(UserProfile user){

		UniqueIDGenerator idGenerator = new UniqueIDGenerator();
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dof = dateFormat.format(user.getDof());
		String insertSQL = "INSERT INTO profiles (userID, dof, height, weight, sex) VALUES (\""+ idGenerator.generateUniqueID() +"\", \"" + dof +"\", " + user.getHeight() +", " + user.getWeight() + ", \"" + String.valueOf(user.getSex()) +"\")";

		System.out.println(insertSQL);
		context.executeDatabaseOperations(username, password, insertSQL);
		
	}
}


