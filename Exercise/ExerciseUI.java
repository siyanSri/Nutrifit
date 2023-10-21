package Exercise;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ExerciseUI extends JFrame{
	
	private JTextField dateField;
	private JTextField timeField;
	private ButtonGroup exerciseGroup;
	private ButtonGroup intensityGroup;
	private String exerciseString;
	private String intensityString;
	private List<String> exerciseList;
	private List<String> durationList;
	private List<String> intensityList;
	
	public ExerciseUI() {
		exerciseList = new ArrayList<>();
		durationList = new ArrayList<>();
		intensityList = new ArrayList<>();
		
		setTitle("Exersie Information Form");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel exersiePanel = new JPanel();
		exersiePanel.setLayout(new GridLayout(5, 3));
		
		JLabel exerciseLabel = new JLabel("Press the button to log your exercise");
		JButton LogButton = new JButton("Log");
		
		LogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame exerciseInfoFrame = new JFrame("Exercise Information Form");
				exerciseInfoFrame.setSize(400, 300);
				exerciseInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				exerciseInfoFrame.setVisible(true);
				exerciseInfoFrame.setLayout(new GridLayout(11, 1));
                JLabel date = new JLabel("Date:");
                dateField = new JTextField(20);
                JLabel time = new JLabel("Time:");
                timeField = new JTextField(20);
                JPanel exercisePanel = new JPanel();
                JLabel exerciseType = new JLabel("Exercise Type:");
                exerciseGroup = new ButtonGroup();
                JRadioButton walkingButton = new JRadioButton("Walking");
                JRadioButton runningButton = new JRadioButton("Running");
                JRadioButton bikingButton = new JRadioButton("Biking");
                JRadioButton swimmingButton = new JRadioButton("Swimming");
                JRadioButton othersButton = new JRadioButton("Others");
                
                exerciseGroup.add(walkingButton);
                exerciseGroup.add(runningButton);
                exerciseGroup.add(bikingButton);
                exerciseGroup.add(swimmingButton);
                exerciseGroup.add(othersButton);
                
                exercisePanel.add(walkingButton);
                exercisePanel.add(runningButton);
                exercisePanel.add(bikingButton);
                exercisePanel.add(swimmingButton);
                exercisePanel.add(othersButton);
                
                walkingButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (walkingButton.isSelected()) {
                        	exerciseString = "walking";
                        } 
                    }
                });
                runningButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (runningButton.isSelected()) {
                        	exerciseString = "running";
                        } 
                    }
                });
                bikingButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (bikingButton.isSelected()) {
                        	exerciseString = "biking";
                        } 
                    }
                });
                swimmingButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (swimmingButton.isSelected()) {
                        	exerciseString = "swimming";
                        } 
                    }
                });
                othersButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (othersButton.isSelected()) {
                        	exerciseString = "others";
                        } 
                    }
                });
                
                JButton submitButton = new JButton("Submit");
                
                JLabel duration = new JLabel("Duration:");
                JTextField durationField = new JTextField(20);
                JPanel IntensityPanel = new JPanel();
                JLabel Intensity = new JLabel("Intensity :");
                
                intensityGroup = new ButtonGroup();
                JRadioButton lowButton = new JRadioButton("Low");
                JRadioButton mediumButton = new JRadioButton("Medium");
                JRadioButton highButton = new JRadioButton("High");
                JRadioButton veryhighButton = new JRadioButton("Very high");
                
                intensityGroup.add(lowButton);
                intensityGroup.add(mediumButton);
                intensityGroup.add(highButton);
                intensityGroup.add(veryhighButton);
                
                IntensityPanel.add(lowButton);
                IntensityPanel.add(mediumButton);
                IntensityPanel.add(highButton);
                IntensityPanel.add(veryhighButton);
                
                lowButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (lowButton.isSelected()) {
                        	intensityString = "low";
                        } 
                    }
                });
                mediumButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (mediumButton.isSelected()) {
                        	intensityString = "medium";
                        } 
                    }
                });
                highButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (highButton.isSelected()) {
                        	intensityString = "high";
                        } 
                    }
                });
                veryhighButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (veryhighButton.isSelected()) {
                        	intensityString = " very high";
                        } 
                    }
                });
                
        		submitButton.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				String date = dateField.getText();
        				System.out.println("date: " + date); 
        				String time = timeField.getText();
        				System.out.println("Time: " + time);
        				System.out.println("exercise type: " + exerciseString);
        				String durationString = durationField.getText();
        				System.out.println("exercise duration: " + durationString);
        				System.out.println("exercise intensity: " + intensityString);
        				exerciseList.add(exerciseString);
        				durationList.add(durationString);
        				intensityList.add(intensityString);
        				exerciseInfoFrame.dispose();
        			 }
                });
        		
                exerciseInfoFrame.add(date);
                exerciseInfoFrame.add(dateField);
                exerciseInfoFrame.add(time);
                exerciseInfoFrame.add(timeField);
                exerciseInfoFrame.add(exerciseType);
                exerciseInfoFrame.add(exercisePanel);
                exerciseInfoFrame.add(duration);
                exerciseInfoFrame.add(durationField);
                exerciseInfoFrame.add(Intensity);
                exerciseInfoFrame.add(IntensityPanel);
                exerciseInfoFrame.add(submitButton);
			}
		});
		
		exersiePanel.add(exerciseLabel);
		exersiePanel.add(LogButton);
		add(exersiePanel);
	}

}
