package Exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Meal.DatabaseManagerMeal;

public class UserExerciseData {

	private Date date;
	private String time;
	private String exerciseType;
	private Float exerciseDuration;
	private String exerciseIntensity;
	
	
	public void createExercise() {
		database();
	}
	
	private void database() {
		DatabaseManagerExercise database = new DatabaseManagerExercise();
        database.connect();
        database.create(this);
	}
	
	public Date getDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}
	public String getExerciseType() {
		return this.exerciseType;
	}
	public Float getExerciseDuration() {
		return this.exerciseDuration;
	}
	public String getExerciseIntensity() {
		return this.exerciseIntensity;
	}
	public void setDate(String date) {
		try {
			this.date = new SimpleDateFormat("yyyy/MM/dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public void setExerciseDuration(String exerciseDuration) {
		this.exerciseDuration = Float.valueOf(exerciseDuration);
	}
	public void setExerciseIntensity(String exerciseIntensity) {
		this.exerciseIntensity = exerciseIntensity;
	}
}
