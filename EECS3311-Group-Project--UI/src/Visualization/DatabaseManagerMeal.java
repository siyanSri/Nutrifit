package Visualization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class DatabaseManagerMeal {

	private DatabaseAdapter sql = new SqlAdapter();
	private Connection connection;
	
	private String username ;
	private String password ;
    
    DatabaseManagerMeal() {
    	username = System.getenv("NAME");
    	password = System.getenv("PASS");
    	System.out.println(username+password);
    }
    public void connect() {
    	connection = sql.connect(username,password);
    }
    public void create(UserMealData user){
    	
    	

        String insertSQL = "INSERT INTO meals (Type, Quantity, dom) VALUES (?, ?, ?)";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dom = dateFormat.format(user.getDate());

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, user.getMealType());
            preparedStatement.setFloat(2, user.getQuantityList().get(0));
           preparedStatement.setString(3, dom);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
