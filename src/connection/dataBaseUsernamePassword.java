package connection;

public class dataBaseUsernamePassword {
	public static String getUsername() {
        return System.getenv("NAME").toString();
    }

    public static String getPassword() {
        return System.getenv("PASS").toString();
    }
}
