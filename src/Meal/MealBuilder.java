package Meal;

import java.text.ParseException;

public class MealBuilder {
    private String name;
    private String date;
    private String mealType;
    private String quantity;
    private String selectedProfile;

    public MealBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MealBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public MealBuilder withMealType(String mealType) {
        this.mealType = mealType;
        return this;
    }
    
    public MealBuilder withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }
    
    public MealBuilder withSelectedProfile(String selectedProfile) {
        this.selectedProfile = selectedProfile;
        return this;
    }

    public Meal build() throws ParseException {
        return new Meal(name, date, mealType, quantity, selectedProfile);
    }
}

