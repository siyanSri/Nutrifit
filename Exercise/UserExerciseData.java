package Exercise;

import java.util.List;

public class UserExerciseData {

	private String date;
	private String time;
	private String exerciseType;
	private String exerciseDuration;
	private String exerciseIntensity;
	
	
	public String getDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}
	public String getExerciseType() {
		return this.exerciseType;
	}
	public String getExerciseDuration() {
		return this.exerciseDuration;
	}
	public String geTexerciseIntensity() {
		return this.exerciseIntensity;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public void setExerciseDuration(String exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}
	public void setExerciseIntensity(String exerciseIntensity) {
		this.exerciseIntensity = exerciseIntensity;
	}
}
