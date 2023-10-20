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
	private ButtonGroup radioGroup;
	
	public ProfileUI() {
		setTitle("Health Information Form");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 3));

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		dofField = new JFormattedTextField(df);
		
		JLabel heightLabel = new JLabel("Height (cm):");
		heightField = new JTextField(20);

		JLabel weightLabel = new JLabel("Weight (kg):");
		weightField = new JTextField(20);

		JPanel measurementPanel = new JPanel();
        JLabel units = new JLabel("Measurement Type:");
        radioGroup = new ButtonGroup();
        JRadioButton mRadioButton = new JRadioButton("Metric");
        JRadioButton iRadioButton = new JRadioButton("Imperial");
        radioGroup.add(mRadioButton);
        radioGroup.add(iRadioButton);
        measurementPanel.add(mRadioButton);
        measurementPanel.add(iRadioButton);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserProfile user = new UserProfile();
				
				try {
					user.setDof(dofField.toString());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String height = heightField.getText();
				String weight = weightField.getText();

				// Here, you can process and store the entered data as needed.
				System.out.println("Height: " + height + " cm");
				System.out.println("Weight: " + weight + " kg");
			}
		});

		mainPanel.add(dateOfBirthLabel);
		mainPanel.add(dofField);
		mainPanel.add(heightLabel);
		mainPanel.add(heightField);
		mainPanel.add(weightLabel);
		mainPanel.add(weightField);
		mainPanel.add(units);
		mainPanel.add(measurementPanel);
		mainPanel.add(submitButton);
        add(mainPanel);
	}

}
