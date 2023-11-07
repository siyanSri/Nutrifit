package Meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
}


