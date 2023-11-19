package Visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

import javax.swing.*;

import Profile.UserProfile;
import Meal.Meal;

public class VisualizeIntake extends JFrame {

	private String selectedUser;
	private String id;
	private Meal meal = new Meal();
	
    public VisualizeIntake(String selectedUser) {
    	super("Visualize");
    	this.selectedUser = selectedUser;
    	id = meal.getUserId(selectedUser);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, "Visualize");
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Float> nutrientVals = meal.getVisualdata(id);
        System.out.println(nutrientVals.toString());
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