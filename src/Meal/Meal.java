package Meal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Settings.Observer;

//Composite class representing a meal

/**
 * The class Meal implements component, observer
 */ 
public class Meal implements Component, Observer{


	private DatabaseManagerMeal database = null;
	private Boolean metric = true;

	private String name;
	private Integer mealId;
	private String userId;
	private Date date;
	private String mealType;
	private Float quantity;
	private List<Component> components = new ArrayList<>();
	private int currentSize;


	/** 
	 *
	 * Meal empty Constructor
	 *
	 * @return public
	 */
	public Meal() { 


		this.currentSize = 0;
		this.name = "";
		this.mealId = null;
		this.date = new Date();
		this.mealType = "";
		this.quantity = null;
	}


	/** 
	 *
	 * Meal Constructor
	 *
	 * @param name  the name. 
	 * @param date  the date. 
	 * @param mealType  the meal type. 
	 * @param quantity  the quantity. 
	 * @param selectedProfile  the selected profile. 
	 * @return public
	 * @throws   ParseException 
	 */
	public Meal(String name, String date, String mealType, String quantity, String selectedProfile) throws ParseException { 

		this.name = name;
		this.date = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		this.mealType = mealType;
		this.quantity = Float.valueOf(quantity);
		this.mealId = getMealId(name);
		this.userId = setId(selectedProfile);
		getNutrients();
	}


	/** 
	 *
	 * Database Init
	 *
	 */
	private void database() { 

		this.database = new DatabaseManagerMeal();
	}


	/** 
	 *
	 * Create Meal
	 *
	 */
	public void create() { 

		if(database == null)	
			database();
		database.create(this, this.userId);
	}


	/** 
	 *
	 * Gets the foods names
	 *
	 * @return the foods
	 */
	public ArrayList<String> getFoods() { 

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
	public Integer getMealId(String name) { 

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
	public void setUserId(String selectedProfile) { 

		if(database == null)	
			database();
		this.userId = database.getUserId(selectedProfile);
	}


	/** 
	 *
	 * Gets the user identifier
	 *
	 * @param name  the name. 
	 * @return the user identifier
	 */
	public String getUserId(String name){ 

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
	public List<Float> getVisualdata(String userId) { 

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
	public float getWeight(String selectedProfile) { 

		if(database == null)	
			database();
		return database.getWeight(selectedProfile);
	}


	/** 
	 *
	 * Gets the nutrients
	 *
	 */
	private void getNutrients() { 

		List<Integer> nutrientId = new ArrayList<>();
		List<Float> nutrientAmount = new ArrayList<>();
		List<String> nutrientName = new ArrayList<>();
		List<String> nutrientUnit = new ArrayList<>();
		database.nutrientInfo(this.mealId , nutrientId, nutrientAmount);
		this.currentSize = nutrientId.size();
		database.nutrientVals(nutrientId, nutrientName, nutrientUnit);
		createNutrients(nutrientId, nutrientAmount, nutrientName, nutrientUnit);
	}



	/** 
	 *
	 * Create nutrients
	 *
	 * @param nutrientId  the nutrient identifier. 
	 * @param nutrientAmount  the nutrient amount. 
	 * @param nutrientName  the nutrient name. 
	 * @param nutrientUnit  the nutrient unit. 
	 */
	private void createNutrients(List<Integer> nutrientId, List<Float> nutrientAmount, List<String> nutrientName, List<String> nutrientUnit) { 


		for(int i = 0; i<nutrientId.size(); i++) {
			converter(nutrientAmount, nutrientUnit);
			Component nutrient = new Nutrient(nutrientId.get(i), nutrientName.get(i), nutrientAmount.get(i), nutrientUnit.get(i));
			this.components.add(nutrient);
		}	
	}



	/** 
	 *
	 * Converter
	 *
	 * @param nutrientAmount  the nutrient amount. 
	 * @param nutrientUnit  the nutrient unit. 
	 */
	private void converter(List<Float> nutrientAmount, List<String> nutrientUnit) { 

		for(int i = 0; i<nutrientAmount.size(); i++) {
			if(nutrientUnit.get(i).equals("g")) {
				Float amount = (this.quantity) * (nutrientAmount.get(i)/100);
				nutrientAmount.set(i,amount);
			}
		}
	}

	@Override 

	/** 
	 *
	 * Update metric
	 *
	 * @param metric  the metric. 
	 */
	public void updateMetric(boolean metric){ 

		this.metric = metric;
	}


	/** 
	 *
	 * Iterator Pattern for component
	 *
	 * @return Iterator<Component>
	 */
	public Iterator<Component> iterator() { 

		Iterator<Component> it = new Iterator<Component>() {

			private int currentIndex = 0;

			@Override

			/** 
			 *
			 * Has next
			 *
			 * @return boolean
			 */
			public boolean hasNext() { 

				return currentIndex < currentSize && components.get(currentIndex) != null;
			}

			@Override

			/** 
			 *
			 * Next
			 *
			 * @return Component
			 */
			public Component next() { 

				return components.get(currentIndex++);
			}

			@Override

			/** 
			 *
			 * Remove
			 *
			 */
			public void remove() { 

				throw new UnsupportedOperationException();
			}
		};
		return it;
	}

	@Override

	/** 
	 *
	 * Log
	 *
	 */
	public void log() { 

		System.out.println("Meal Date: " + date);
		System.out.println("Meal Type: " + mealType);
		System.out.println("Components:");

		for (Component component : components) {
			component.log();
		}
	}


	/** 
	 *
	 * Gets the date
	 *
	 * @return the date
	 */
	public Date getDate() { 

		return this.date;
	}


	/** 
	 *
	 * Gets the meal type
	 *
	 * @return the meal type
	 */
	public String getMealType() { 

		return this.mealType;
	}

	/** 
	 *
	 * Gets the nutrient list
	 *
	 * @return the nutrient list
	 */
	public List<Component> getNutrientList(){ 

		return this.components;
	}


	/** 
	 *
	 * Gets the quantity
	 *
	 * @return the quantity
	 */
	public Float getQuantity() { 

		return this.quantity;
	}


	/** 
	 *
	 * Gets the food identifier
	 *
	 * @return the food identifier
	 */
	public Integer getFoodId() { 

		return this.mealId;
	}


	/** 
	 *
	 * Sets the identifier
	 *
	 * @param selectedProfile  the selected profile. 
	 * @return String
	 */
	public String setId(String selectedProfile) { 

		if(database == null)	
			database();
		return database.getUserId(selectedProfile);
	}


	/** 
	 *
	 * Gets the user identifier
	 *
	 * @return the user identifier
	 */
	public String getUserId() { 

		return this.userId;
	}

}
