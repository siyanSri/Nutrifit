package Meal;

import java.util.ArrayList;

public class NutrientConverter{

	public void Converter (ArrayList <String> foodList, ArrayList <Float> amountList) {
		
		getNutrients(foodlist);
		
		for each food and amount:
			for all nutrients in food:
				foodamount multiply nutrientamount/100;
		
		return array of all foods and nutrients
		
	}
}
