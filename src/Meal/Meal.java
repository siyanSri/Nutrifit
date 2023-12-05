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
		this.mealId = MealHandler.getMealId(name);
		this.userId = MealHandler.setId(selectedProfile);
		this.components = MealHandler.getNutrients(this, this.quantity);
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
	 * Gets the user identifier
	 *
	 * @return the user identifier
	 */
	public String getUserId() { 

		return this.userId;
	}


	public void setSize(int size) {
		this.currentSize = size;
	}

}
