package Meal;

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
    	
    	

        String insertSQL = "INSERT INTO meals (idMeals,Type,Quantity) VALUES (?, ?, ?)";
        Random rand = new Random(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dom = dateFormat.format(user.getDate());

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setInt(1, rand.nextInt(50));
            preparedStatement.setString(2, user.getMealType());
            preparedStatement.setFloat(3, user.getQuantityList().get(0));
//            preparedStatement.setString(4, dom);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
