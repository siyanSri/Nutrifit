/**
 * 
 */
package Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author 
 *
 */
public class ProfileUI extends JFrame{


	private static final long serialVersionUID = 1L;

	private JFormattedTextField dofField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField sexField;
	private JRadioButton mRadioButton;
	private JRadioButton iRadioButton;
	private ButtonGroup radioGroup;
	
	
	public ProfileUI() {
		setTitle("Health Information Form");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6, 3));

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		dofField = new JFormattedTextField(df);
		
		JLabel heightLabel = new JLabel("Height (cm):");
		heightField = new JTextField(20);

		JLabel weightLabel = new JLabel("Weight (kg):");
		weightField = new JTextField(20);
		
		JLabel sexLabel = new JLabel("Sex   Male(m) Female(m) Other(o):");
		sexField = new JTextField(20);

		JPanel measurementPanel = new JPanel();
        JLabel units = new JLabel("Measurement Type:");
        radioGroup = new ButtonGroup();
        mRadioButton = new JRadioButton("Metric");
        iRadioButton = new JRadioButton("Imperial");
        radioGroup.add(mRadioButton);
        radioGroup.add(iRadioButton);
        measurementPanel.add(mRadioButton);
        measurementPanel.add(iRadioButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSubmit();
			}
		});

		mainPanel.add(dateOfBirthLabel);
		mainPanel.add(dofField);
		mainPanel.add(heightLabel);
		mainPanel.add(heightField);
		mainPanel.add(weightLabel);
		mainPanel.add(weightField);
		mainPanel.add(sexLabel);
		mainPanel.add(sexField);
		mainPanel.add(units);
		mainPanel.add(measurementPanel);
		mainPanel.add(submitButton);
        add(mainPanel);
	}
	
	 private void handleSubmit() {
	        UserProfile user = new UserProfile();
	        user.setDof(dofField.getText().toString());
			user.setHeight(Float.parseFloat(heightField.getText().toString()));
			user.setWeight(Float.parseFloat(weightField.getText().toString()));
			user.setSex(sexField.getText().toString().charAt(0));
			user.setUnit(mRadioButton.isSelected());
	       
			user.createProfile();
			
	 }


}
