package Exercise;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Profile.DatabaseManagerProfile;

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

    public ExerciseUI(String selectedProfile) {
        UserExerciseData user = new UserExerciseData();

        exerciseList = new ArrayList<>();
        durationList = new ArrayList<>();
        intensityList = new ArrayList<>();

        setTitle("Exercise Information Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel exerciseInfoPanel = new JPanel();
        exerciseInfoPanel.setLayout(new GridLayout(11, 1));

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
                    intensityString = "very high";
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String dateValue = dateField.getText();
                System.out.println("Date: " + dateValue);
                String timeValue = timeField.getText();
                System.out.println("Time: " + timeValue);
                System.out.println("Exercise type: " + exerciseString);
                String durationString = durationField.getText();
                System.out.println("Exercise duration: " + durationString);
                System.out.println("Exercise intensity: " + intensityString);
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

        add(exerciseInfoPanel);
    }
}