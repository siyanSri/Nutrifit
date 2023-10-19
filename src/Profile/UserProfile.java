package Profile;

import java.util.Date;

public class UserProfile {

	private Date dof;
	private float height;
	private float weight;
	private char sex;
	private char unit;
	
	public Date getDof() {
		return new Date(this.dof.getTime());
	}
	public void setDof(Date dof) {
		this.dof = new Date(dof.getTime());
	}
	
	public float getHeight() {
		return this.height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWeight() {
		return this.weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public char getSex() {
		return this.sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public char getUnit() {
		return this.unit;
	}
	public void setUnit(char unit) {
		this.unit = unit;
	}
	
	
	
	
}
