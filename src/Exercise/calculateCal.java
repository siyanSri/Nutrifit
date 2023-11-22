package Exercise;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
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
    

/** 
 *
 * Calories burned
 *
 */
    public void calBurned() { 

        double caloriesPerMinute = 0;

        if (Type.equals("walking")) {
            if (intensity.equals("low")) {
                caloriesPerMinute = 2.0;
            } else if (intensity.equals("medium")) {
                caloriesPerMinute = 3.5;
            } else if (intensity.equals("high")) {
                caloriesPerMinute = 5.0;
            } else if (intensity.equals("very high")) {
                caloriesPerMinute = 7.0;
            }
        } else if (Type.equals("running")) {
            if (intensity.equals("low")) {
                caloriesPerMinute = 6.0;
            } else if (intensity.equals("medium")) {
                caloriesPerMinute = 9.0;
            } else if (intensity.equals("high")) {
                caloriesPerMinute = 12.0;
            } else if (intensity.equals("very high")) {
                caloriesPerMinute = 15.0;
            }
        } else if (Type.equals("biking")) {
            if (intensity.equals("low")) {
                caloriesPerMinute = 3.0;
            } else if (intensity.equals("medium")) {
                caloriesPerMinute = 6.0;
            } else if (intensity.equals("high")) {
                caloriesPerMinute = 9.0;
            } else if (intensity.equals("very high")) {
                caloriesPerMinute = 12.0;
            }
        } else if (Type.equals("swimming")) {
            if (intensity.equals("low")) {
                caloriesPerMinute = 5.0;
            } else if (intensity.equals("medium")) {
                caloriesPerMinute = 8.0;
            } else if (intensity.equals("high")) {
                caloriesPerMinute = 11.0;
            } else if (intensity.equals("very high")) {
                caloriesPerMinute = 14.0;
            }
        } else if (Type.equals("others")) {
        	if (intensity.equals("low")) {
                caloriesPerMinute = 3.0;
            } else if (intensity.equals("medium")) {
                caloriesPerMinute = 6.0;
            } else if (intensity.equals("high")) {
                caloriesPerMinute = 9.0;
            } else if (intensity.equals("very high")) {
                caloriesPerMinute = 12.0;
            }
        }
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
