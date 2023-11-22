package Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * The class User profile
 */ 
public class UserProfile {


	private String name;
	private Date dof;
	private float height;
	private float weight;
	private char sex;
	private char unit;
	private String userID;

	private DatabaseManagerProfile database = null;


	/** 
	 *
	 * Database
	 *
	 */
	private void database() { 

		this.database = new DatabaseManagerProfile();

		UniqueIDGenerator idGenerator = new UniqueIDGenerator();
		this.userID = idGenerator.generateUniqueID();
	}


	/** 
	 *
	 * Create profile
	 *
	 */
	public void createProfile() { 

		if(database == null)	
			database();
		database.create(this);


	}

	/** 
	 *
	 * Gets the profiles
	 *
	 * @return the profiles
	 */
	public ArrayList<String> getProfiles() { 

		if(database == null)	
			database();
		return database.fetchNames();
	}

	/** 
	 *
	 * Gets the user identifier
	 *
	 * @param name  the name. 
	 * @return the user identifier
	 */
	public String getUserId(String name){ 

		if(database == null)	
			database();
		return database.getUserId(name);
	}


	/** 
	 *
	 * Gets the name
	 *
	 * @return the name
	 */
	public String getName() { 

		return name;
	}


	/** 
	 *
	 * Sets the name
	 *
	 * @param name  the name. 
	 */
	public void setName(String name) { 

		this.name = name;
	}


	/** 
	 *
	 * Gets the dof
	 *
	 * @return the dof
	 */
	public Date getDof() { 

		return new Date(this.dof.getTime());
	}

	/** 
	 *
	 * Sets the dof
	 *
	 * @param dof  the dof. 
	 */
	public void setDof(Date dof) { 

		this.dof = new Date(dof.getTime());
	}

	/** 
	 *
	 * Sets the dof
	 *
	 * @param dof  the dof. 
	 */
	public void setDof(String dof){ 

		try {
			this.dof = new SimpleDateFormat("yyyy/MM/dd").parse(dof);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	/** 
	 *
	 * Gets the height
	 *
	 * @return the height
	 */
	public float getHeight() { 

		return this.height;
	}

	/** 
	 *
	 * Sets the height
	 *
	 * @param height  the height. 
	 */
	public void setHeight(float height) { 

		this.height = height;
	}


	/** 
	 *
	 * Gets the weight
	 *
	 * @return the weight
	 */
	public float getWeight() { 

		return this.weight;
	}

	/** 
	 *
	 * Sets the weight
	 *
	 * @param weight  the weight. 
	 */
	public void setWeight(float weight) { 

		this.weight = weight;
	}


	/** 
	 *
	 * Gets the sex
	 *
	 * @return the sex
	 */
	public char getSex() { 

		return this.sex;
	}

	/** 
	 *
	 * Sets the sex
	 *
	 * @param sex  the sex. 
	 */
	public void setSex(char sex) { 

		this.sex = sex;
	}


	/** 
	 *
	 * Gets the unit
	 *
	 * @return the unit
	 */
	public char getUnit() { 

		return this.unit;
	}

	/** 
	 *
	 * Sets the unit
	 *
	 * @param metric  the metric. 
	 */
	public void setUnit(Boolean metric) { 

		if(metric) {
			this.unit = 'm';
		}
		else {
			this.unit = 'i';
		}
	}

	/** 
	 *
	 * Sets the user identifier
	 *
	 * @param userID  the user identifier. 
	 */
	public void setUserID(String userID) { 

		this.userID = new String (userID);
	}

	/** 
	 *
	 * Gets the user identifier
	 *
	 * @return the user identifier
	 */
	public String getUserID() { 

		return new String (userID);
	}

}
