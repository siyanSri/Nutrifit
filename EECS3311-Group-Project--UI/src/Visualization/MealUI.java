package Visualization;

import java.util.Date;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class MealUI extends JFrame{
	
	/*
	UserMealData mealData = new UserMealData(); //instance of usermealData
	*/
	
	private JTextField dateField;
	private ButtonGroup foodGroup;
	private ButtonGroup ingredientGroup;
	private JTextField ingredientField;
	private JTextField quantityField;
	private String foodString;
	private List<String> ingredientsList;
	private List<String> quantityList;
	
	private int count = 0;
	
	public MealUI() {
		UserMealData user = new UserMealData();
		ingredientsList = new ArrayList<>();
		quantityList = new ArrayList<>();
		setTitle("Meal Information Form");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mealPanel = new JPanel();
		mealPanel.setLayout(new GridLayout(5, 3));
		
		JLabel mealLabel = new JLabel("Press the button to log your meal");
		JButton LogButton = new JButton("Log");
		LogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame mealInfoFrame = new JFrame("Meal Information Form");
				mealInfoFrame.setSize(400, 300);
				mealInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				mealInfoFrame.setVisible(true);
				mealInfoFrame.setLayout(new GridLayout(7, 1));
                JLabel date = new JLabel("Date:");
                dateField = new JTextField(20);
                
                JPanel foodPanel = new JPanel();
                JLabel foodType = new JLabel("Food Type:");
                foodGroup = new ButtonGroup();
                JRadioButton breakfastButton = new JRadioButton("Breakfast");
                JRadioButton lunchButton = new JRadioButton("Lunch");
                JRadioButton dinnerButton = new JRadioButton("Dinner");
                JRadioButton snackButton = new JRadioButton("Snack");
                foodGroup.add(breakfastButton);
                foodGroup.add(lunchButton);
                foodGroup.add(dinnerButton);
                foodGroup.add(snackButton);
                foodPanel.add(breakfastButton);
                foodPanel.add(lunchButton);
                foodPanel.add(dinnerButton);
                foodPanel.add(snackButton);
                
   
                
                breakfastButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (breakfastButton.isSelected()) {
                            foodString = "breakfast";
                        } 
                    }
                });
                lunchButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (lunchButton.isSelected()) {
                            foodString = "lunch";
                        } 
                    }
                });
                dinnerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (dinnerButton.isSelected()) {
                            foodString = "dinner";
                        } 
                    }
                });
                snackButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (snackButton.isSelected()) {
                            foodString = "snack";
                        } 
                    }
                });
                
                JButton submitButton = new JButton("Submit");
        		submitButton.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				String date = dateField.getText();
        				System.out.println("date: " + date); //printing the date (for test only)
        			
        				user.setDate(date); //storing data in usermealdata class
        				
        				System.out.println("food type: " + foodString); //printing the food type (for test only)
        				
        				user.setMealType(foodString); //storing data in usermealdata class
        				
        				if(foodString.equals("snack")){
        					System.out.println("True");
        				}
        				mealInfoFrame.dispose();
        				JFrame ingredientInfoFrame = new JFrame("Ingredient Information Form");
        				ingredientInfoFrame.setSize(400, 300);
        				ingredientInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        				ingredientInfoFrame.setVisible(true);
        				ingredientInfoFrame.setLayout(new GridLayout(7, 1));
                        JLabel ingredient = new JLabel("Enter Ingredient");
                        ingredientField = new JTextField(20);
                        JLabel quantity = new JLabel("Quantity:");
                        quantityField = new JTextField(20);
                        
                        JPanel ingredientPanel = new JPanel();
                        JLabel ingredientType = new JLabel("Input more ingredients:");
                        ingredientGroup = new ButtonGroup();
                        JRadioButton yesButton = new JRadioButton("Yes");
                        JRadioButton noButton = new JRadioButton("No");
                        
                        JButton nextButton = new JButton("Next");
                        
                        
                        ingredientGroup.add(yesButton);
                        ingredientGroup.add(noButton);
                        ingredientPanel.add(yesButton);
                        ingredientPanel.add(noButton);
                        
                        nextButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (yesButton.isSelected()) {
                                	String ingredientString = ingredientField.getText();
                    				ingredientsList.add(ingredientString);
                    				String quantityString = quantityField.getText();
                    				quantityList.add(quantityString);
                    				count++; //increment counter

                    				
                    				user.addToIngredientsList(ingredientString); //storing data in usermealdata class
                    				user.addToQuantityList(quantityString); //storing data in usermealdata class
                    				
                    				
                                	ingredientField.setText("");
                                    quantityField.setText("");
                                }
                                else {
                                	String ingredientString = ingredientField.getText();
                                	user.addToIngredientsList(ingredientString); //storing data in usermealdata class
                    				String quantityString = quantityField.getText();
                    				user.addToQuantityList(quantityString); //storing data in usermealdata class
                                	count++;

                                	user.createMeal();
                                }
                            }
                        });
                        
                        ingredientInfoFrame.add(ingredient);
                        ingredientInfoFrame.add(ingredientField);
                        ingredientInfoFrame.add(quantity);
                        ingredientInfoFrame.add(quantityField);
                        ingredientInfoFrame.add(ingredientType);
                        ingredientInfoFrame.add(ingredientPanel);
                        ingredientInfoFrame.add(nextButton);
        			}
        		});
        		

        		mealInfoFrame.add(date);
        		mealInfoFrame.add(dateField);
        		mealInfoFrame.add(foodType);
        		mealInfoFrame.add(foodPanel);
        		mealInfoFrame.add(submitButton);
			}
		});
		
		mealPanel.add(mealLabel);
		mealPanel.add(LogButton);
		add(mealPanel);
	}
}

