package Profile;

import java.util.ArrayList;

public class ProfileHandler {

	private static DatabaseManagerProfile database = null;


	/** 
	 *
	 * Database
	 *
	 */
	private static void database(UserProfile profile) { 

		ProfileHandler.database = new DatabaseManagerProfile();

		UniqueIDGenerator idGenerator = new UniqueIDGenerator();
		profile.setUserID(idGenerator.generateUniqueID());
	}


	/** 
	 *
	 * Create profile
	 *
	 */
	public static void createProfile(UserProfile profile) { 

		if(database == null)	
			database(profile);
		database.create(profile);


	}

	/** 
	 *
	 * Gets the profiles
	 *
	 * @return the profiles
	 */
	public static ArrayList<String> getProfiles(UserProfile profile) { 

		if(database == null)	
			database(profile);
		return database.fetchNames();
	}

	/** 
	 *
	 * Gets the user identifier
	 *
	 * @param name  the name. 
	 * @return the user identifier
	 */
	public String getUserId(UserProfile profile,String name){ 

		if(database == null)	
			database(profile);
		return database.getUserId(name);
	}

	
	
}
