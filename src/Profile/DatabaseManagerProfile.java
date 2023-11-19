package Profile;
import connection.DatabaseAdapter;
import connection.DatabaseContext;
import connection.DatabaseStrategy;
import connection.MySqlConnectionStrategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class DatabaseManagerProfile {

	private DatabaseContext context = new DatabaseContext();

	private String username ;
	private String password ;

	DatabaseManagerProfile() {
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
	}

	public void create(UserProfile user){

		
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dof = dateFormat.format(user.getDof());
		String insertSQL = "INSERT INTO profiles (userID, name, dof, height, weight, sex) VALUES (\""+ user.getUserID() +"\", \"" + user.getName() +"\", \"" + dof +"\", " + user.getHeight() +", " + user.getWeight() + ", \"" + String.valueOf(user.getSex()) +"\")";

		context.executeDatabaseOperations(username, password, insertSQL);
	}
	
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
	
	public String getUserId(String name) {
		String output = null;
		
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
		
		System.out.println("name"+name);
		String insertSQL = "SELECT userID FROM profiles WHERE name = '"+ name +"'";
		ResultSet result = context.executeDatabaseOperations(username, password, insertSQL);
		
		 try {
			while (result.next()) {
				System.out.println(result.getString("userID"));	
			     output = result.getString("userID");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.context.close();
	    }
		
		System.out.println(output); 
		return new String (output);	
	}
	
	public void updateDof(String name, String newDof) throws SQLException {
		this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET dof = '" + newDof + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    
    public void updateHeight(String name, String newHeight) throws SQLException {
    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET height = '" + newHeight + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    
    public void updateWeight(String name, String newWeight) throws SQLException {
    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET weight = '" + newWeight + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    
    public void updateSex(String name, String newSex) throws SQLException {
    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET sex = '" + newSex + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);
    }
    
    public void updateName(String name, String newName) throws SQLException {
    	this.context.setDatabaseStrategy(new MySqlConnectionStrategy());
        String sql = "UPDATE profiles SET name = '" + newName + "' WHERE name = '" + name + "'";
        context.executeDatabaseOperations(username, password, sql);    
    }
    
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


