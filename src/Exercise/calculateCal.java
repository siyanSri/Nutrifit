package Exercise;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import Profile.DatabaseManagerProfile;


/**
 * The class Calculate calories
 */ 
public class calculateCal {
	String selectedProfile;
	double BMR;
	String sex;
	double weight;
	int age;
	String dof;
	double height;
	String Type;
	String Duration;
	String intensity; 
	private double totalCaloriesBurned;


	/** 
	 *
	 * constructor 
	 *
	 * @param selectedProfile  the selected profile. 
	 * @param Type  the type. 
	 * @param Duration  the duration. 
	 * @param intensity  the intensity. 
	 */
	public calculateCal(String selectedProfile, String Type, String Duration,String intensity) { 

		this.selectedProfile = selectedProfile;
		this.Type = Type;
		this.Duration = Duration;
		this.intensity = intensity;
		getValues();
		calculateDOB();
		calculateBMR();
		calBurned();
	}


	/** 
	 *
	 * Gets the values
	 *
	 */
	public void getValues() { 

		DatabaseManagerProfile manager = new DatabaseManagerProfile();
		try {
			this.sex = manager.getSex(selectedProfile);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			this.dof = manager.getDof(selectedProfile);
		} catch (SQLException | NumberFormatException ex) {
			ex.printStackTrace();
		}
		try {
			this.height = Double.parseDouble(manager.getHeight(selectedProfile));
		} catch (SQLException | NumberFormatException ex) {
			ex.printStackTrace();
		}
		try {
			this.weight = Double.parseDouble(manager.getWeight(selectedProfile));
		} catch (SQLException | NumberFormatException ex) {
			ex.printStackTrace();
		}
	}


	/** 
	 *
	 * Calculate BMR
	 *
	 */
	public void calculateBMR() { 

		if (sex.equals("m")) {
			this.BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
		} else {
			this.BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
		}
	}


	/** 
	 *
	 * Calculate Age
	 *
	 */
	public void calculateDOB() { 

		StringTokenizer tokenizer = new StringTokenizer(dof, "-");
		int year = Integer.parseInt(tokenizer.nextToken());
		int month = Integer.parseInt(tokenizer.nextToken());
		int day = Integer.parseInt(tokenizer.nextToken());

		LocalDate birthDate = LocalDate.of(year, month, day);
		LocalDate currentDate = LocalDate.now();

		Period period = Period.between(birthDate, currentDate);
		this.age = period.getYears();
	}


	private static final Map<String, Map<String, Double>> CALORIE_MAP = new HashMap<>();

	//Initialize Calorie Map of all available exercise
	static {
		// Populate the calorie map with type, intensity, and calorie values
		CALORIE_MAP.put("walking", createIntensityMap(2.0, 3.5, 5.0, 7.0));
		CALORIE_MAP.put("running", createIntensityMap(6.0, 9.0, 12.0, 15.0));
		CALORIE_MAP.put("biking", createIntensityMap(3.0, 6.0, 9.0, 12.0));
		CALORIE_MAP.put("swimming", createIntensityMap(5.0, 8.0, 11.0, 14.0));
		CALORIE_MAP.put("others", createIntensityMap(3.0, 6.0, 9.0, 12.0));
	}

	/*
	 * Create intensity map for given exercise
	 * @param low  low intensity of exercise 
	 * @param medium  medium intensity of exercise 
	 * @param high  high intensity of exercise
	 * @param Very high  Very high intensity of exercise
	 * 
	 */
	private static Map<String, Double> createIntensityMap(double low, double medium, double high, double veryHigh) {
		Map<String, Double> intensityMap = new HashMap<>();
		intensityMap.put("low", low);
		intensityMap.put("medium", medium);
		intensityMap.put("high", high);
		intensityMap.put("very high", veryHigh);
		return intensityMap;
	}


	/** 
	 *
	 * Calories burned
	 *
	 */
	public void calBurned() { 

		Map<String, Double> intensityMap = CALORIE_MAP.get(this.Type);

		double caloriesPerMinute = intensityMap.get(this.intensity);

		this.totalCaloriesBurned = caloriesPerMinute * Integer.parseInt(Duration);
	}   

	/** 
	 *
	 * Gets the calories
	 *
	 * @return the calories
	 */
	public String getCalories() { 

		return String.valueOf(totalCaloriesBurned);
	}
}
