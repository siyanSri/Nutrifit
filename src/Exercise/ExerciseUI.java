package Exercise;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import mainGUI.mainGUIFrame;



/**
 * The class ExerciseUI 
 */ 
public class ExerciseUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField dateField;
	private JTextField timeField;
	private ButtonGroup exerciseGroup;
	private ButtonGroup intensityGroup;
	private String exerciseString;
	private String intensityString;
	private List<String> exerciseList;
	private List<String> durationList;
	private List<String> intensityList;


	/** 
	 *
	 * Exercise UI
	 *
	 * @param selectedProfile  the selected profile. 
	 * @return public
	 */
	public ExerciseUI(String selectedProfile) { 

		UserExerciseData user = new UserExerciseData();

		exerciseList = new ArrayList<>();
		durationList = new ArrayList<>();
		intensityList = new ArrayList<>();

		setTitle("Exercise Information Form");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel exerciseInfoPanel = new JPanel();
		exerciseInfoPanel.setLayout(new GridLayout(12, 2));

		JLabel date = new JLabel("Date:");
		dateField = new JTextField(20);
		JLabel time = new JLabel("Time(24h):");
		timeField = new JTextField(20);
		JPanel exercisePanel = new JPanel();
		JLabel exerciseType = new JLabel("Exercise Type:");
		exerciseGroup = new ButtonGroup();
		JRadioButton walkingButton = new JRadioButton("Walking");
		JRadioButton runningButton = new JRadioButton("Running");
		JRadioButton bikingButton = new JRadioButton("Biking");
		JRadioButton swimmingButton = new JRadioButton("Swimming");
		JRadioButton othersButton = new JRadioButton("Others");
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			@Override

			/** 
			 *
			 * Action performed, Back Button
			 *
			 * @param e  the e. 
			 */
			public void actionPerformed(ActionEvent e) { 

				// Close the current frame
				dispose();

				// Create a new frame or navigate back to the previous frame
				mainGUIFrame previousFrame = new mainGUIFrame(selectedProfile); 
				previousFrame.setVisible(true);
			}
		});

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

			/** 
			 *
			 * Action performed, walking clicked
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (walkingButton.isSelected()) {
					exerciseString = "walking";
				}
			}
		});
		runningButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, running clicked
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (runningButton.isSelected()) {
					exerciseString = "running";
				}
			}
		});
		bikingButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, biking clicked
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (bikingButton.isSelected()) {
					exerciseString = "biking";
				}
			}
		});
		swimmingButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, swimming clicked
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (swimmingButton.isSelected()) {
					exerciseString = "swimming";
				}
			}
		});
		othersButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, others clicked
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (othersButton.isSelected()) {
					exerciseString = "others";
				}
			}
		});

		JButton submitButton = new JButton("Submit");

		JLabel duration = new JLabel("Duration(minutes):");
		JTextField durationField = new JTextField(20);
		JPanel intensityPanel = new JPanel();
		JLabel intensity = new JLabel("Intensity :");

		intensityGroup = new ButtonGroup();
		JRadioButton lowButton = new JRadioButton("Low");
		JRadioButton mediumButton = new JRadioButton("Medium");
		JRadioButton highButton = new JRadioButton("High");
		JRadioButton veryhighButton = new JRadioButton("Very high");

		intensityGroup.add(lowButton);
		intensityGroup.add(mediumButton);
		intensityGroup.add(highButton);
		intensityGroup.add(veryhighButton);

		intensityPanel.add(lowButton);
		intensityPanel.add(mediumButton);
		intensityPanel.add(highButton);
		intensityPanel.add(veryhighButton);

		lowButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, Low intentsity 
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (lowButton.isSelected()) {
					intensityString = "low";
				}
			}
		});
		mediumButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, Medium intentsity 
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (mediumButton.isSelected()) {
					intensityString = "medium";
				}
			}
		});
		highButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, High intentsity 
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (highButton.isSelected()) {
					intensityString = "high";
				}
			}
		});
		veryhighButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, Very high intentsity 
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 

				if (veryhighButton.isSelected()) {
					intensityString = "very high";
				}
			}
		});

		submitButton.addActionListener(new ActionListener() {

			/** 
			 *
			 * Action performed, Submit
			 *
			 * @param e  the event. 
			 */
			public void actionPerformed(ActionEvent e) { 


				String dateValue = dateField.getText();
				String timeValue = timeField.getText();
				String durationString = durationField.getText();
				exerciseList.add(exerciseString);
				durationList.add(durationString);
				intensityList.add(intensityString);

				calculateCal cals = new calculateCal(selectedProfile,exerciseList.get(0),durationString,intensityList.get(0));
				String Calories = cals.getCalories();
				user.setDate(dateValue);
				user.setName(selectedProfile);
				user.setExerciseDuration(durationString);
				user.setExerciseType(exerciseList.get(0));
				user.setExerciseIntensity(intensityList.get(0));
				user.setCals(Calories);
				user.createExercise();
				dispose();
				// Create a new frame or navigate back to the previous frame
				mainGUIFrame previousFrame = new mainGUIFrame(selectedProfile); 
				previousFrame.setVisible(true);
			}
		});

		exerciseInfoPanel.add(date);
		exerciseInfoPanel.add(dateField);
		exerciseInfoPanel.add(time);
		exerciseInfoPanel.add(timeField);
		exerciseInfoPanel.add(exerciseType);
		exerciseInfoPanel.add(exercisePanel);
		exerciseInfoPanel.add(duration);
		exerciseInfoPanel.add(durationField);
		exerciseInfoPanel.add(intensity);
		exerciseInfoPanel.add(intensityPanel);
		exerciseInfoPanel.add(submitButton);
		exerciseInfoPanel.add(backButton);

		add(exerciseInfoPanel);
	}
}
