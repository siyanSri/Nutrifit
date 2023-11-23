package Visualization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * The class Recommended CF G extends J frame
 */ 
public class recommendedCFG extends JFrame {


	/** 
	 *
	 * Recommended CFG
	 *
	 * @param selectedUser  the selected user. 
	 * @return public
	 */
	public recommendedCFG(String selectedUser) { 

		super("Recommended from CFG");

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override

			/** 
			 *
			 * Action performed, back to User charts
			 *
			 * @param e  the e. 
			 */
			public void actionPerformed(ActionEvent e) { 

				dispose();
				VisualizeIntake visualize = new VisualizeIntake(selectedUser);
				visualize.setVisible(true);
			}
		});

		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Carbohydrates", 48);
		dataset.setValue("Fat", 32);
		dataset.setValue("Proteins", 20);

		JFreeChart chart = ChartFactory.createPieChart(
				"Recommended Nutrition",
				dataset,
				true,
				true,
				false
				);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint("Carbohydrates", Color.GREEN);
		plot.setSectionPaint("Fat", Color.RED);
		plot.setSectionPaint("Proteins", Color.BLUE);

		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));

		JPanel chartPanel = new ChartPanel(chart);

		setLayout(new BorderLayout());
		add(backButton, BorderLayout.NORTH);
		add(chartPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
