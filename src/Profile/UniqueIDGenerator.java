package Profile;

import java.util.UUID;
import java.util.HashSet;
import java.util.Set;


/**
 * The class Unique identifier generator
 */ 
public class UniqueIDGenerator {

	private Set<String> usedIDs = new HashSet<>();


	/** 
	 *
	 * Generate unique identifier
	 *
	 * @return String
	 */
	public String generateUniqueID() { 

		String randomID;
		do {
			UUID uuid = UUID.randomUUID();
			randomID = uuid.toString();
		} while (usedIDs.contains(randomID));

		usedIDs.add(randomID);
		return randomID;
	}

}
