package Meal;

import java.util.Date;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;




public class ingredientLogFrame extends JFrame implements ActionListener{
	
	JFrame ingredientLogFrame = new JFrame();
	private JTextField ingredientField;
	private JTextField quantityField;
	private ButtonGroup ingredientButtonGroup;
	JRadioButton yesButton = new JRadioButton("Yes");
    JRadioButton noButton = new JRadioButton("No");
    JButton nextButton = new JButton("Next");
    private List<String> ingredientsList;
	private List<String> quantityList;
	int count = 0;
	UserMealData user;
	
	
	public ingredientLogFrame(UserMealData user) {
		this.user = user;
		
		ingredientsList = new ArrayList<>();
		quantityList = new ArrayList<>();
		
        // Create an instance of the autocomplete class for ingredientField
		
		JComboBox comboBox = new JComboBox(this.user.getFoods().toArray()) ;
        // has to be editable
        comboBox.setEditable(true);
        // change the editor's document
        new autocomplete(comboBox);
		
		nextButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ingredient Log Menu");
		setSize(400, 300);
		JPanel logIngredientPanel = new JPanel();
		JPanel logQuantityPanel = new JPanel();
		JPanel addMorePanel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));
		logIngredientPanel.setLayout(new GridLayout(1, 2));
		logQuantityPanel.setLayout(new GridLayout(1, 2));
		addMorePanel.setLayout(new GridLayout(1, 2));
		JLabel ingredient = new JLabel("Enter Ingredient");
		ingredientField = new JTextField(20);
        JLabel quantity = new JLabel("Quantity:");
        quantityField = new JTextField(20);
        JLabel inputMore = new JLabel("Input more ingredients:");
    
        ingredientButtonGroup = new ButtonGroup();
        
        ingredientButtonGroup.add(yesButton);
        ingredientButtonGroup.add(noButton);
        addMorePanel.add(yesButton);
        addMorePanel.add(noButton);
        
        
//        logIngredientPanel.add(ingredientField);
//        
//
        logIngredientPanel.add(ingredient);
//        logIngredientPanel.add(ingredientField);
    
        logQuantityPanel.add(quantity);
        logQuantityPanel.add(quantityField);
        logIngredientPanel.add(comboBox);    
        
        
        mainPanel.add(logIngredientPanel);
        mainPanel.add(logQuantityPanel);
        mainPanel.add(inputMore);
        mainPanel.add(addMorePanel);
        mainPanel.add(nextButton);
        
        
        add(mainPanel);
        
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==nextButton) {
		
			if (yesButton.isSelected()) {
				String ingredientString = ingredientField.getText();
				ingredientsList.add(ingredientString);
				String quantityString = quantityField.getText();
				quantityList.add(quantityString);
				count++; 
				
				this.user.addToIngredientsList(ingredientString);
				this.user.addToQuantityList(quantityString);
				
	        	ingredientField.setText("");
	            quantityField.setText("");
			}
			else {
				dispose();
            	mealLogFrame newFrame = new mealLogFrame();
            	newFrame.setVisible(true);
            	//for testing
            	String ingredientString = ingredientField.getText();
				ingredientsList.add(ingredientString);
				String quantityString = quantityField.getText();
				quantityList.add(quantityString);
            	count++;
            	System.out.println("\ningredient:");
            	for (String item : ingredientsList) { //printing the ingredients in the list (for test only)
                    System.out.println(item);
                }
            	System.out.println("\nquantity:"); 
            	for (String item : quantityList) { //printing the quantity in the list (for test only)
                    System.out.println(item);
                }
            	this.user.addToIngredientsList(ingredientString);
            	this.user.addToQuantityList(quantityString);
            	this.user.create();
            }
		}
		
	}

}
