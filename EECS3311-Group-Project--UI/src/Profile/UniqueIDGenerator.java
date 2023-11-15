package Profile;

import java.util.UUID;
import java.util.HashSet;
import java.util.Set;

public class UniqueIDGenerator {

    private Set<String> usedIDs = new HashSet<>();

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
