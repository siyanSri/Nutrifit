package Meal;

import java.util.ArrayList;
import java.util.List;

public class NutrientCreator {


	/** 
	 *
	 * Create nutrients
	 *
	 * @param nutrientId  the nutrient identifier. 
	 * @param nutrientAmount  the nutrient amount. 
	 * @param nutrientName  the nutrient name. 
	 * @param nutrientUnit  the nutrient unit. 
	 * @return 
	 */
	protected static List<Component> createNutrients(List<Integer> nutrientId, List<Float> nutrientAmount, List<String> nutrientName, List<String> nutrientUnit, float quantity) { 
		List<Component> components = new ArrayList<>();
		for(int i = 0; i<nutrientId.size(); i++) {
			converter(nutrientAmount, nutrientUnit, quantity);
			Component nutrient = new Nutrient(nutrientId.get(i), nutrientName.get(i), nutrientAmount.get(i), nutrientUnit.get(i));
			components.add(nutrient);
		}
		return components;
	}



	/** 
	 *
	 * Converter
	 *
	 * @param nutrientAmount  the nutrient amount. 
	 * @param nutrientUnit  the nutrient unit. 
	 */
	private static void converter(List<Float> nutrientAmount, List<String> nutrientUnit, float quantity) { 

		for(int i = 0; i<nutrientAmount.size(); i++) {
			if(nutrientUnit.get(i).equals("g")) {
				Float amount = (quantity) * (nutrientAmount.get(i)/100);
				nutrientAmount.set(i,amount);
			}
		}
	}
	
}
