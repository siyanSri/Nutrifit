package Settings;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import Meal.Meal;
import mainGUI.mainGUIFrame;

public class SettingsUI extends JFrame{
	
	JFrame SettingsUI = new JFrame();
	Settings settingsManager = new Settings();
	
	
	public SettingsUI(Meal meal, String selectedProfile){
		
		settingsManager.subscribe("metric", meal);
		
		setSize(400, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel titleLabel = new JLabel("Select Measurement System:");
		mainPanel.add(titleLabel);

    	JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame
                dispose();
                
                // Create a new frame or navigate back to the previous frame
                mainGUIFrame previousFrame = new mainGUIFrame(selectedProfile); 
                previousFrame.setVisible(true);
            }
        });
        
		
		ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton metricRadioButton = new JRadioButton("Metric");
        JRadioButton imperialRadioButton = new JRadioButton("Imperial");

        buttonGroup.add(metricRadioButton);
        buttonGroup.add(imperialRadioButton);

        
        metricRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsManager.setMetric(true);
            }
        });

        imperialRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsManager.setMetric(false);
            }
        });
        
        mainPanel.add(metricRadioButton);
        mainPanel.add(imperialRadioButton);

        setLayout(new BorderLayout());
        add(backButton, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);
	}
}
