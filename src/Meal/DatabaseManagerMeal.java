package Meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class DatabaseManagerMeal {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;

	DatabaseManagerMeal() {
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}

	public void create(UserMealData user){

		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dom = dateFormat.format(user.getDate());
		String insertSQL = "INSERT INTO meals (Type, Quantity, dom) VALUES (\""+ user.getMealType().toString() +"\", " +  user.getQuantityList().get(0).toString() + ", \"" + dom +"\")";

		System.out.println(insertSQL);
		context.executeDatabaseOperations(username, password, insertSQL);
		
	}
	
	public ArrayList<String> fetchNames() {
		
		ArrayList <String> output = new ArrayList<String>();
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT * FROM foodname";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output.add(result.getString("FoodDescription"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;

	}
}


