package Profile;


import connection.DatabaseContext;
import connection.MySqlConnectionStrategy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



 /**
 * The class Database manager profile
 */ 
public class DatabaseManagerProfile {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;


/** 
 *
 * It is a constructor.
 * username and password can be set manually or change environment variable in system to include PASS and NAME 
 *
 */
	public DatabaseManagerProfile() { 

		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}


/** 
 *
 * Create
 *
 * @param user  the user. 
 */
	public void create(UserProfile user){ 


		
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dof = dateFormat.format(user.getDof());
		String insertSQL = "INSERT INTO profiles (userID, name, dof, height, weight, sex) VALUES (\""+ user.getUserID() +"\", \"" + user.getName() +"\", \"" + dof +"\", " + user.getHeight() +", " + user.getWeight() + ", \"" + String.valueOf(user.getSex()) +"\")";

		context.executeDatabaseOperations(username, password, insertSQL);
	}
	

/** 
 *
 * Fetch names
 *
 * @return ArrayList<String>
 */
	public ArrayList<String> fetchNames() { 

		
		ArrayList <String> output = new ArrayList<String>();
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT * FROM profiles";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output.add(result.getString("name"));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;

	}
	

/** 
 *
 * Gets the user identifier
 *
 * @param name  the name. 
 * @return the user identifier
 */
	public String getUserId(String name) { 

		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		String insertSQL = "SELECT userID FROM profiles WHERE name = '"+ name +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
			     output = result.getString("userID");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.context.close();
	    }
		
		return new String (output);	
	}
	

/** 
 *
 * Update Date of Birth
 *
 * @param name  the name. 
 * @param newDof  the new dof. 
 * @throws   SQLException 
 */
	public void updateDof(String name, String newDof) throws SQLException { 

		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET dof = '" + newDof + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    

/** 
 *
 * Update height
 *
 * @param name  the name. 
 * @param newHeight  the new height. 
 * @throws   SQLException 
 */
    public void updateHeight(String name, String newHeight) throws SQLException { 

    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET height = '" + newHeight + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    

/** 
 *
 * Update weight
 *
 * @param name  the name. 
 * @param newWeight  the new weight. 
 * @throws   SQLException 
 */
    public void updateWeight(String name, String newWeight) throws SQLException { 

    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET weight = '" + newWeight + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    

/** 
 *
 * Update sex
 *
 * @param name  the name. 
 * @param newSex  the new sex. 
 * @throws   SQLException 
 */
    public void updateSex(String name, String newSex) throws SQLException { 

    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET sex = '" + newSex + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    

/** 
 *
 * Update name
 *
 * @param name  the name. 
 * @param newName  the new name. 
 * @throws   SQLException 
 */
    public void updateName(String name, String newName) throws SQLException { 

    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET name = '" + newName + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);    
    }
    

/** 
 *
 * Gets the date of birth
 *
 * @param name  the name. 
 * @return the dof
 * @throws   SQLException 
 */
    public String getDof(String name) throws SQLException { 

        this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        
        String sql = "SELECT dof FROM profiles WHERE name = '" + name + "'";
        ResultSet result = context.executeDatabaseOperations(username, password, sql);

        if (result.next()) {
            return result.getString("dof");
        } else {
            return null; 
        }
    }


/** 
 *
 * Gets the height
 *
 * @param name  the name. 
 * @return the height
 * @throws   SQLException 
 */
    public String getHeight(String name) throws SQLException { 

        this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        
        String sql = "SELECT height FROM profiles WHERE name = '" + name + "'";
        ResultSet result = context.executeDatabaseOperations(username, password, sql);

        if (result.next()) {
            return result.getString("height");
        } else {
            return null; 
        }
    }


/** 
 *
 * Gets the weight
 *
 * @param name  the name. 
 * @return the weight
 * @throws   SQLException 
 */
    public String getWeight(String name) throws SQLException { 

        this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        
        String sql = "SELECT weight FROM profiles WHERE name = '" + name + "'";
        ResultSet result = context.executeDatabaseOperations(username, password, sql);

        if (result.next()) {
            return result.getString("weight");
        } else {
            return null; 
        }
    }


/** 
 *
 * Gets the sex
 *
 * @param name  the name. 
 * @return the sex
 * @throws   SQLException 
 */
    public String getSex(String name) throws SQLException { 

        this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        
        String sql = "SELECT sex FROM profiles WHERE name = '" + name + "'";
        ResultSet result = context.executeDatabaseOperations(username, password, sql);

        if (result.next()) {
            return result.getString("sex");
        } else {
            return null; 
        }
    } 
	
}


