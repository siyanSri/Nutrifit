package Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		String insertSQL = "INSERT INTO profiles (userID, name, dof, height, weight, sex) VALUES (\""+ idGenerator.generateUniqueID() +"\", \"" + user.getName() +"\", \"" + dof +"\", " + user.getHeight() +", " + user.getWeight() + ", \"" + String.valueOf(user.getSex()) +"\")";

		context.executeDatabaseOperations(username, password, insertSQL);
	}
	
	public ArrayList<String> fetchNames() {
		
		ArrayList <String> output = new ArrayList<String>();
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT * FROM profiles";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output.add(result.getString("name"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;

	}
	
}


