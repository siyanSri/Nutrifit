package Meal;

import java.util.Iterator;

class Nutrient implements Component {
	private Integer id;
    private String name;
    private Float amount;
    private String unit;

    public Nutrient(Integer id ,String name, Float amount, String unit) {
        this.id = id;
    	this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public Integer getNutrientId() {
    	return id;
    }
    
    public Float getNutrientAmount() {
    	return amount;
    }
    
    @Override
    public void log() {
        System.out.println("Nutrient: " + name);
    }

	
	
}