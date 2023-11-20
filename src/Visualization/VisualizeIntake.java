package Visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import Profile.UserProfile;
import mainGUI.mainGUIFrame;
import Meal.Meal;

public class VisualizeIntake extends JFrame {

	private String selectedUser;
	private String id;
	private Meal meal = new Meal();
	
    public VisualizeIntake(String selectedUser) {
    	super("Visualize");
    	this.selectedUser = selectedUser;
    	 
    	JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();
                
                // Create a new frame or navigate back to the previous frame
                mainGUIFrame previousFrame = new mainGUIFrame(selectedUser); 
                previousFrame.setVisible(true);
            }
        });
    	 
    	id = meal.getUserId(selectedUser);
    	
    	List<Float> nutrientVals = meal.getVisualdata(id);
        System.out.println(nutrientVals.toString());
    	
        if(!nutrientVals.isEmpty()) {
    	 CategoryDataset dataset = createDataset(nutrientVals);
         JFreeChart chart = createChart(dataset, "Visualize");
         ChartPanel chartPanel = new ChartPanel(chart);
         chartPanel.setSize(new Dimension(500, 270));
         
         setLayout(new BorderLayout());
         add(backButton, BorderLayout.NORTH);
         add(chartPanel, BorderLayout.CENTER);
        }
        else {
        	JLabel Panel = new JLabel("No data Logged on User");
            Panel.setSize(new Dimension(500, 270));
            
            setLayout(new BorderLayout());
            add(backButton, BorderLayout.NORTH);
            add(Panel, BorderLayout.CENTER);
        }
        
        
         

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(600, 400);
         setLocationRelativeTo(null);
         setVisible(true);
    }

    private CategoryDataset createDataset(List<Float> nutrientVals) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        
        // Replace these values with actual nutrient data
	    
        	dataset.addValue(nutrientVals.get(0), this.selectedUser, "Calories");
	        dataset.addValue(nutrientVals.get(1), this.selectedUser, "Fat");
	        dataset.addValue(nutrientVals.get(2), this.selectedUser, "Saturated Fat");
	        dataset.addValue(nutrientVals.get(3), this.selectedUser, "Cholesterol");
	        dataset.addValue(nutrientVals.get(4), this.selectedUser, "Carbs");
	        dataset.addValue(nutrientVals.get(5), this.selectedUser, "Fiber");
	        dataset.addValue(nutrientVals.get(6), this.selectedUser, "Sugar");
	    
        // Add data for another person (if needed)
        // dataset.addValue(...);

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createBarChart(
                title,                  // chart title
                "Nutrient",             // x-axis label
                "Amount",               // y-axis label
                dataset
        );

        return chart;
    }
    



//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            VisualizeIntake chart = new VisualizeIntake("Nutrient Intake", "Nutrient Intake Chart");
//            chart.pack();
//            chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            chart.setVisible(true);
//        });
//    }
}