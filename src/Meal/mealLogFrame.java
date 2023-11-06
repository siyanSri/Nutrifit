package Meal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class mealLogFrame extends JFrame implements ActionListener{
	UserMealData user = new UserMealData();
	JFrame mealLogFrame = new JFrame();
	JButton submitButton = new JButton("Submit");
	private String foodTypeString;
	private ButtonGroup foodGroup;
	private JTextField dateField;
	
	
	public mealLogFrame() {
		
		submitButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meal Log Menu");
		setSize(400, 300);
		JPanel logMealPanel = new JPanel();
		logMealPanel.setLayout(new GridLayout(7, 1));
		JLabel date = new JLabel("Date:");
		dateField = new JTextField(20);
		
		JPanel foodPanel = new JPanel();
        JLabel foodType = new JLabel("Food Type:");
        
        //**************************** button group for food type
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
                	foodTypeString = "breakfast";
                } 
            }
        });
        lunchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (lunchButton.isSelected()) {
                	foodTypeString = "lunch";
                } 
            }
        });
        dinnerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dinnerButton.isSelected()) {
                	foodTypeString = "dinner";
                } 
            }
        });
        snackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (snackButton.isSelected()) {
                	foodTypeString = "snack";
                } 
            }
        });
		//***************************
		
        logMealPanel.add(date);
        logMealPanel.add(dateField);
        logMealPanel.add(foodType);
        logMealPanel.add(foodPanel);
		logMealPanel.add(submitButton);
		add(logMealPanel);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==submitButton) {		
			dispose();
			ingredientLogFrame newFrame = new ingredientLogFrame(this.user);
			newFrame.setVisible(true);
			
			//for Testing:
			String date = dateField.getText();
			System.out.println("date: " + date);
			System.out.println("food type: " + foodTypeString);
			if(foodTypeString.equals("snack")){
				System.out.println("True");
			}
			user.setDate(date);
			user.setMealType(foodTypeString);
		}
		
	}
	

}
