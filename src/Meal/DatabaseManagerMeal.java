package Meal;


import connection.DatabaseContext;
import connection.MySqlConnectionStrategy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


 /**
 * The class Database manager meal
 * username and password can be set manually or change environment variable in system to include PASS and NAME
 */ 
public class DatabaseManagerMeal {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;

	DatabaseManagerMeal() {
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}

	
	//idMeals, userID, Type, Quantity, dom, nutrientID, nutrientAmount, foodID
	

/** 
 *
 * Create Meal entry
 *
 * @param meal  the meal. 
 * @param userId  the user identifier. 
 */
	public void create(Meal meal, String userId){ 


		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dom = dateFormat.format(meal.getDate());
		Iterator<Component> iterator = meal.iterator();
		while (iterator.hasNext()) {
			Nutrient component = (Nutrient) iterator.next();
			String insertSQL = "INSERT INTO meals (userID, Type, Quantity, dom, nutrientID, nutrientAmount, foodID) VALUES "
					+ "(\""+ meal.getUserId() +"\", \"" + meal.getMealType() +"\", " +  meal.getQuantity() + ", \"" + dom + "\", " + component.getNutrientId() + ", " + component.getNutrientAmount() + ", " + meal.getFoodId() +")";
			try {
				context.executeDatabaseOperations(username, password, insertSQL);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		
	}
	

/** 
 *
 * Fetch names of foods
 *
 * @return ArrayList<String>
 */
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
	

/** 
 *
 * Gets the user identifier
 *
 * @param name  the name. 
 * @return the user identifier
 */
	public String getUserId(String name) { 

		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT userID FROM profiles WHERE name = '"+ name +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output = result.getString("userID");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.context.close();
	    }
		
		return new String (output);	
	}
	

/** 
 *
 * Gets the meal identifier
 *
 * @param name  the name. 
 * @return the meal identifier
 */
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
	

/** 
 *
 * Nutrient info
 *
 * @param mealId  the meal identifier. 
 * @param nutrientId  the nutrient identifier. 
 * @param nutrientAmount  the nutrient amount. 
 * @return String
 */
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
	

/** 
 *
 * Nutrient Values
 *
 * @param nutrientId  the nutrient identifier. 
 * @param nutrientName  the nutrient name. 
 * @param nutrientUnit  the nutrient unit. 
 * @return String
 */
	public String nutrientVals(List<Integer> nutrientId, List<String> nutrientName ,List<String> nutrientUnit) { 

		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		 // Convert the list of nutrientId to a comma-separated string
	    String nutrientIdString = nutrientId.stream().map(Object::toString).collect(Collectors.joining(", "));
	    String insertSQL = "SELECT NutrientName, NutrientUnit FROM nutrientnames WHERE NutrientId IN (" + nutrientIdString + ")";
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
	

/** 
 *
 * Gets the visualize intake
 *
 * @param userId  the user identifier. 
 * @return the visualize intake
 */
	public List<Float> getVisualizeIntake(String userId) { 

		List<Float> output = new ArrayList<Float>();
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());

	    String insertSQL = "SELECT userId, nutrientId, SUM(nutrientAmount) AS totalNutrientAmount " +
                "FROM meals " +
                "WHERE userId = '"+ userId +"' AND nutrientId IN (208, 204, 606, 601, 205, 291, 269, 203) " +
                "GROUP BY userId, nutrientId";
	    ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
				output.add(result.getFloat("totalNutrientAmount"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;	
	}
	

/** 
 *
 * Gets the weight
 *
 * @param name  the name. 
 * @return the weight
 */
    public float getWeight(String name) { 

        this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        
        float output = 0;
        
        String sql = "SELECT weight FROM profiles WHERE name = '" + name + "'";
        ResultSet result = context.executeDatabaseOperations(username, password, sql);

        try {
			while (result.next()) {
            output = result.getFloat("weight");
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			return output;	
    }



	
}


