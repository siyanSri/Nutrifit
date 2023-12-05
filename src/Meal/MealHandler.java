package Meal;

import java.util.ArrayList;
import java.util.List;

public class MealHandler {

	private static DatabaseManagerMeal database = null;
	
	/** 
	 *
	 * Database Init
	 *
	 */
	private static void database() { 
		MealHandler.database = new DatabaseManagerMeal();
	}


	/** 
	 *
	 * Create Meal
	 *
	 */
	public static void create(Meal meal) { 
		if(database == null)	
			database();
		database.create(meal, meal.getUserId());
	}


	/** 
	 *
	 * Gets the foods names
	 *
	 * @return the foods
	 */
	public static ArrayList<String> getFoods() { 
		if(database == null)	
			database();
		return database.fetchNames();
	}


	/** 
	 *
	 * Gets the meal identifier
	 *
	 * @param name  the name. 
	 * @return the meal identifier
	 */
	public static Integer getMealId(String name) { 
		if(database == null)	
			database();
		return database.getMealId(name);
	}


	/** 
	 *
	 * Sets the user identifier
	 *
	 * @param selectedProfile  the selected profile. 
	 */
	public static String setUserId(String selectedProfile) { 

		if(database == null)	
			database();
		return database.getUserId(selectedProfile);
	}


	/** 
	 *
	 * Gets the user identifier
	 *
	 * @param name  the name. 
	 * @return the user identifier
	 */
	public static String getUserId(String name){ 

		if(database == null)	
			database();
		return database.getUserId(name);
	}


	/** 
	 *
	 * Gets the visualdata, Top nutrients
	 *
	 * @param userId  the user identifier. 
	 * @return the visualdata
	 */
	public static List<Float> getVisualdata(String userId) { 

		if(database == null)	
			database();
		return database.getVisualizeIntake(userId);
	}


	/** 
	 *
	 * Gets the weight
	 *
	 * @param selectedProfile  the selected profile. 
	 * @return the weight
	 */
	public static float getWeight(String selectedProfile) { 

		if(database == null)	
			database();
		return database.getWeight(selectedProfile);
	}


	/** 
	 *
	 * Gets the nutrients
	 * @return 
	 *
	 */
	protected static List<Component> getNutrients(Meal meal, float quantity) { 

		List<Integer> nutrientId = new ArrayList<>();
		List<Float> nutrientAmount = new ArrayList<>();
		List<String> nutrientName = new ArrayList<>();
		List<String> nutrientUnit = new ArrayList<>();
		database.nutrientInfo(meal.getFoodId() , nutrientId, nutrientAmount);
		meal.setSize(nutrientId.size());
		database.nutrientVals(nutrientId, nutrientName, nutrientUnit);
		return NutrientCreator.createNutrients(nutrientId, nutrientAmount, nutrientName, nutrientUnit, quantity);
		
	}
	
	/** 
	 *
	 * Sets the identifier
	 *
	 * @param selectedProfile  the selected profile. 
	 * @return String
	 */
	public static String setId(String selectedProfile) { 

		if(database == null)	
			database();
		return database.getUserId(selectedProfile);
	}
	
	
}
