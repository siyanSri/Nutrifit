package Exercise;

import java.sql.SQLException;

import Profile.DatabaseManagerProfile;

public class calculateCal {
    String selectedProfile;
    double BMR;
    String sex;
    double weight;
    int age;
    double height;
    String Type;
    String Duration;
    String intensity; 
    private double totalCaloriesBurned;

    public calculateCal(String selectedProfile, String Type, String Duration,String intensity) {
        this.selectedProfile = selectedProfile;
        this.Type = Type;
        this.Duration = Duration;
        this.intensity = intensity;
        getValues();
        calculateBMR();
        calBurned();
    }

    public void getValues() {
        DatabaseManagerProfile manager = new DatabaseManagerProfile();
        try {
            this.sex = manager.getSex(selectedProfile);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            this.age = Integer.parseInt(manager.getAge(selectedProfile));
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

    public void calculateBMR() {
        if (sex.equals("m")) {
            this.BMR = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            this.BMR = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
    }
    
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
    public String getCalories() {
    	return String.valueOf(totalCaloriesBurned);
    }
}