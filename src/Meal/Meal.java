package Meal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import connection.DatabaseContext;

//Composite class representing a meal
class Meal implements Component {
	

	private DatabaseManagerMeal database = null;
	
	private String name;
	private Integer mealId;
	private String userId;
    private Date date;
    private String mealType;
    private Float quantity;
    private List<Component> components = new ArrayList<>();
    private int currentSize;

    public Meal() {
    	this.currentSize = 0;
		this.name = "";
		this.mealId = null;
		this.date = new Date();
		this.mealType = "";
		this.quantity = null;
    }
    
    public Meal(String name, String date, String mealType, String quantity, String selectedProfile) throws ParseException {
        
    	this.name = name;
		this.date = new SimpleDateFormat("yyyy/MM/dd").parse(date);
    	this.mealType = mealType;
        this.quantity = Float.valueOf(quantity);
        this.mealId = getMealId(name);
        System.out.println("init name" + selectedProfile);
        this.userId = setId(selectedProfile);
        getNutrients();
    }
	
	private void database() {
		this.database = new DatabaseManagerMeal();
	}
    
	public void create() {
		if(database == null)	
			database();
		database.create(this, this.userId);
	}
	
	public ArrayList<String> getFoods() {
		if(database == null)	
			database();
		return database.fetchNames();
	}
	
	public Integer getMealId(String name) {
		if(database == null)	
			database();
		return database.getMealId(name);
	}
	
	public void setUserId(String selectedProfile) {
		if(database == null)	
			database();
		this.userId = database.getUserId(selectedProfile);
	}
    
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
    
    
	private void createNutrients(List<Integer> nutrientId, List<Float> nutrientAmount, List<String> nutrientName, List<String> nutrientUnit) {
		
		for(int i = 0; i<nutrientId.size(); i++) {
			converter(nutrientAmount, nutrientUnit);
			Component nutrient = new Nutrient(nutrientId.get(i), nutrientName.get(i), nutrientAmount.get(i), nutrientUnit.get(i));
			this.components.add(nutrient);
		}	
	}


	private void converter(List<Float> nutrientAmount, List<String> nutrientUnit) {
		for(int i = 0; i<nutrientAmount.size(); i++) {
			if(nutrientUnit.get(i).equals("g")) {
				Float amount = (this.quantity) * (nutrientAmount.get(i)/100);
				nutrientAmount.set(i,amount);
			}
		}
	}


    @Override
    public Iterator<Component> iterator() {
        Iterator<Component> it = new Iterator<Component>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && components.get(currentIndex) != null;
            }

            @Override
            public Component next() {
                return components.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
	
    @Override
    public void log() {
        System.out.println("Meal Date: " + date);
        System.out.println("Meal Type: " + mealType);
        System.out.println("Components:");

        for (Component component : components) {
            component.log();
        }
    }

	public Date getDate() {
		return this.date;
	}

	public String getMealType() {
		return this.mealType;
	}
    public List<Component> getNutrientList(){
    	return this.components;
    }

	public Float getQuantity() {
		return this.quantity;
	}

	public Integer getFoodId() {
		return this.mealId;
	}
    
	public String setId(String selectedProfile) {
		if(database == null)	
			database();
		return database.getUserId(selectedProfile);
	}

	public String getUserId() {
		return this.userId;
	}
    
}