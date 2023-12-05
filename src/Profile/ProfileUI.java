package Profile;

import javax.swing.*;
import mainGUI.mainGUIFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ProfileUI extends JFrame{


	private UserProfile user = new UserProfile();
	private static final long serialVersionUID = 1L;

	private JFormattedTextField dofField;
	private JTextField nameField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField sexField;
	private JRadioButton mRadioButton;
	private JRadioButton iRadioButton;
	private ButtonGroup radioGroup;



	/** 
	 *
	 * Profile UI
	 *
	 * @return 	public
	 */
	public ProfileUI() { 

		setTitle("Health Information Form");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(7, 3));

		JLabel nameLabel = new JLabel("What is your name:");
		nameField = new JTextField(20);

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		dofField = new JFormattedTextField(df);

		JLabel heightLabel = new JLabel("Height (cm):");
		heightField = new JTextField(20);

		JLabel weightLabel = new JLabel("Weight (kg):");
		weightField = new JTextField(20);

		JLabel sexLabel = new JLabel("Sex   Male(m) Female(m) Other(o):");
		sexField = new JTextField(20);


        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
        	/*
        	 * Check if all fields are filled
        	 */
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    handleSubmit();
                    dispose();
                    mainGUIFrame mainFrame = new mainGUIFrame(nameField.getText().toString());
                    mainFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ProfileUI.this, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

		mainPanel.add(nameLabel);
		mainPanel.add(nameField);
		mainPanel.add(dateOfBirthLabel);
		mainPanel.add(dofField);
		mainPanel.add(heightLabel);
		mainPanel.add(heightField);
		mainPanel.add(weightLabel);
		mainPanel.add(weightField);
		mainPanel.add(sexLabel);
		mainPanel.add(sexField);
		mainPanel.add(submitButton);
		add(mainPanel);
	}


    private boolean validateFields() {
        // Validate that all fields are filled
        if (nameField.getText().trim().isEmpty() ||
            dofField.getText().trim().isEmpty() ||
            heightField.getText().trim().isEmpty() ||
            weightField.getText().trim().isEmpty() ||
            sexField.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }
	
	/** 
	 *
	 * Handle submit
	 *
	 */
	private void handleSubmit() { 

		user.setName(nameField.getText().toString());
		user.setDof(dofField.getText().toString());
		user.setHeight(Float.parseFloat(heightField.getText().toString()));
		user.setWeight(Float.parseFloat(weightField.getText().toString()));
		user.setSex(sexField.getText().toString().charAt(0));

		user.createProfile();

	}


	/** 
	 *
	 * Gets the current
	 *
	 * @return the current
	 */
	public UserProfile getCurrent() { 

		return this.user;
	}

}
