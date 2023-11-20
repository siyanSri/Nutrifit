package Visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private Float weight;
	
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
            JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Calories", createPieChartPanel("Calories", nutrientVals.get(0), 2000));
            tabbedPane.addTab("Fat", createPieChartPanel("Fat", nutrientVals.get(1), 50));
            tabbedPane.addTab("Saturated Fat", createPieChartPanel("Saturated Fat", nutrientVals.get(2), 22));
            tabbedPane.addTab("Cholesterol", createPieChartPanel("Cholesterol", nutrientVals.get(3), 300));
            tabbedPane.addTab("Carbs", createPieChartPanel("Carbs", nutrientVals.get(4), 270));
            tabbedPane.addTab("Fiber", createPieChartPanel("Fiber", nutrientVals.get(5), 32));
            tabbedPane.addTab("Sugar", createPieChartPanel("Sugar", nutrientVals.get(6), 32));
            tabbedPane.addTab("Protien", createPieChartPanel("Protien", nutrientVals.get(7), getProtien()));
            
            setLayout(new BorderLayout());
            add(backButton, BorderLayout.NORTH);
            add(tabbedPane, BorderLayout.CENTER);
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


    private JPanel createPieChartPanel(String nutrient, float actualValue, float recommendedValue) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        // Actual amount represents progress
        dataset.setValue("Progress", actualValue);

        // Recommended amount represents the total
        dataset.setValue("Remaining", recommendedValue - actualValue);

        JFreeChart chart = ChartFactory.createPieChart(
                nutrient + " Intake",
                dataset,
                true,
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Progress", Color.BLUE);
        plot.setSectionPaint("Remaining", Color.LIGHT_GRAY); // You can choose a different color for the remaining part

        // Customize the section labels
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));

        return new ChartPanel(chart);
    }
    
    private float getProtien() {
    	float output;
    	
        this.weight = meal.getWeight(selectedUser);
        if(this.weight == 0) {
        	output = 56;
        }
        else {
        	output = (float) (this.weight*0.8);
        }
    	
    	return output;
    }

}