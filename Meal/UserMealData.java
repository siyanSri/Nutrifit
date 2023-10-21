package Meal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMealData {
	
	private String date;
	private String mealType;
	private List<String> ingredientsList;
	private List<String> quantityList;
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public String getMealType() {
		return this.mealType;
	}
    public void addToIngredientsList(String ingredient) {
    	ingredientsList.add(ingredient);
    }
    public void addToQuantityList(String quantity) {
    	quantityList.add(quantity);
    }
}
