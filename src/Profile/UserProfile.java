package Profile;

import java.text.ParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class UserProfile {

	
	private String name;
	private Date dof;
	private float height;
	private float weight;
	private char sex;
	private char unit;
	private String userID;
	
	private DatabaseManagerProfile database = null;
	
	private void database() {
		this.database = new DatabaseManagerProfile();
		
		UniqueIDGenerator idGenerator = new UniqueIDGenerator();
		this.userID = idGenerator.generateUniqueID();
	}
	
	public void createProfile() {
		if(database == null)	
			database();
		database.create(this);
		
		
	}
	public ArrayList<String> getProfiles() {
		if(database == null)	
			database();
		return database.fetchNames();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDof() {
		return new Date(this.dof.getTime());
	}
	public void setDof(Date dof) {
		this.dof = new Date(dof.getTime());
	}
	public void setDof(String dof){
		try {
			this.dof = new SimpleDateFormat("yyyy/MM/dd").parse(dof);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
	public void setUnit(Boolean metric) {
		if(metric) {
			this.unit = 'm';
		}
		else {
			this.unit = 'i';
		}
		System.out.println(this.unit);
	}
	public void setUserID(String userID) {
		this.userID = new String (userID);
	}
	public String getUserID() {
		return new String (userID);
	}
	
}
