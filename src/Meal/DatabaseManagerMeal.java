package Meal;
import connection.DatabaseAdapter;
import connection.DatabaseContext;
import connection.DatabaseStrategy;
import connection.MySqlConnectionStrategy;
import Profile.ProfileUI;
import Profile.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DatabaseManagerMeal {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;

	DatabaseManagerMeal() {
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}

	
	//idMeals, userID, Type, Quantity, dom, nutrientID, nutrientAmount, foodID
	
	public void create(Meal meal, String userId){

		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dom = dateFormat.format(meal.getDate());
		Iterator<Component> iterator = meal.iterator();
		while (iterator.hasNext()) {
			Nutrient component = (Nutrient) iterator.next();
			String insertSQL = "INSERT INTO meals (userID, Type, Quantity, dom, nutrientID, nutrientAmount, foodID) VALUES "
					+ "(\""+ meal.getUserId() +"\", \"" + meal.getMealType() +"\", " +  meal.getQuantity() + ", \"" + dom + "\", " + component.getNutrientId() + ", " + component.getNutrientAmount() + ", " + meal.getFoodId() +")";
			System.out.println(insertSQL);
			System.out.println(meal.getUserId());
			try {
				context.executeDatabaseOperations(username, password, insertSQL);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		
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
	
	public String getUserId(String name) {
		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		System.out.println("name"+name);
		String insertSQL = "SELECT userID FROM profiles WHERE name = '"+ name +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
				System.out.println(result.getString("userID"));	
			     output = result.getString("userID");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.context.close();
	    }
		
		System.out.println(output); 
		return new String (output);	
	}
	
	public Integer getMealId(String name) {
		Integer output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		String insertSQL = "SELECT FoodID FROM foodname WHERE FoodDescription = '"+ name +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output = result.getInt("FoodId");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;	
	}
	
	public String nutrientInfo(Integer mealId, List<Integer> nutrientId, List<Float> nutrientAmount) {
		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT nutrientid, nutrientvalue FROM nutrient_amount WHERE FoodId = '"+ mealId +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
				nutrientId.add(result.getInt("nutrientid"));
				nutrientAmount.add(result.getFloat("nutrientvalue"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;	
	}
	
	public String nutrientVals(List<Integer> nutrientId, List<String> nutrientName ,List<String> nutrientUnit) {
		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		 // Convert the list of nutrientId to a comma-separated string
	    String nutrientIdString = nutrientId.stream().map(Object::toString).collect(Collectors.joining(", "));

	    // Use a prepared statement to avoid SQL injection
	    String insertSQL = "SELECT NutrientName, NutrientUnit FROM nutrientnames WHERE NutrientId IN (" + nutrientIdString + ")";
	    System.out.println(insertSQL);
	    ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
				nutrientName.add(result.getString("NutrientName"));
				nutrientUnit.add(result.getString("NutrientUnit"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;	
	}
	
}


