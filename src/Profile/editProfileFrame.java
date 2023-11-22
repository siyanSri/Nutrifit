package Profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import mainGUI.mainGUIFrame;

interface ProfileState {
	void handleToggleButtonClick(editProfileFrame frame);
	void updateToggleButtonState(editProfileFrame frame);
	void updateFieldsVisibility(editProfileFrame frame);
}

class DefaultProfileState implements ProfileState {
	@Override

	/** 
	 *
	 * Handle toggle button click
	 *
	 * @param frame  the frame. 
	 */
	public void handleToggleButtonClick(editProfileFrame frame) { 

		frame.setProfileState(new EditedProfileState());
		frame.updateToggleButtonState();
		frame.updateFieldsVisibility();
	}

	@Override

	/** 
	 *
	 * Update toggle button state
	 *
	 * @param frame  the frame. 
	 */
	public void updateToggleButtonState(editProfileFrame frame) { 

		frame.toggleButton.setText("No");
		frame.setIsClicked(false);
	}

	@Override

	/** 
	 *
	 * Update fields visibility
	 *
	 * @param frame  the frame. 
	 */
	public void updateFieldsVisibility(editProfileFrame frame) { 

		boolean isVisible = false;
		frame.updateFieldsVisibility(isVisible);
	}
}

class EditedProfileState implements ProfileState {
	@Override

	/** 
	 *
	 * Handle toggle button click
	 *
	 * @param frame  the frame. 
	 */
	public void handleToggleButtonClick(editProfileFrame frame) { 

		frame.setProfileState(new DefaultProfileState());
		frame.updateToggleButtonState();
		frame.updateFieldsVisibility();
	}

	@Override

	/** 
	 *
	 * Update toggle button state
	 *
	 * @param frame  the frame. 
	 */
	public void updateToggleButtonState(editProfileFrame frame) { 

		frame.toggleButton.setText("Yes");
		frame.setIsClicked(true);

	}

	@Override

	/** 
	 *
	 * Update fields visibility
	 *
	 * @param frame  the frame. 
	 */
	public void updateFieldsVisibility(editProfileFrame frame) { 

		boolean isVisible = true;
		frame.updateFieldsVisibility(isVisible);
	}
}

public class editProfileFrame extends JFrame implements ItemListener, ActionListener {

	private boolean isClicked = false;

	/** 
	 *
	 * Sets the is clicked
	 *
	 * @param isClicked  the is clicked. 
	 */
	public void setIsClicked(boolean isClicked) { 

		this.isClicked = isClicked;
	}
	private ProfileState profileState;

	private String username;
	private String password;

	private JLabel nameLabel;
	private JLabel heightLabel;
	private JLabel weightLabel;
	private JLabel sexLabel;
	private JLabel dofLabel;

	private JTextField nameField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField sexField;
	private JTextField dofField;

	private ButtonGroup profileGroup;

	JButton toggleButton;

	JRadioButton editName = new JRadioButton("");
	JRadioButton editDof = new JRadioButton("");
	JRadioButton editHeight = new JRadioButton("");
	JRadioButton editWeight = new JRadioButton("");
	JRadioButton editSex = new JRadioButton("");

	JButton editButton = new JButton("Edit");
	JButton backButton = new JButton("Back");
	JFrame editProfileFrame = new JFrame();
	private String selectedProfile;
	private UserProfile userProfile;



	/** 
	 *
	 * Edit profile frame
	 *
	 * @param selectedProfile  the selected profile. 
	 * @return public
	 */
	public editProfileFrame(String selectedProfile) { 

		profileState = new DefaultProfileState();
		username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();

		toggleButton = new JButton("No");
		toggleButton.addActionListener(new ActionListener() {
			@Override

			/** 
			 *
			 * Action performed
			 *
			 * @param e  the e. 
			 */
			public void actionPerformed(ActionEvent e) { 

				handleToggleButtonClick();
			}
		});

		editName.addItemListener(this);
		editDof.addItemListener(this);
		editHeight.addItemListener(this);
		editWeight.addItemListener(this);
		editSex.addItemListener(this);

		nameField = new JTextField(20);
		dofField = new JTextField(20);
		heightField = new JTextField(20);
		weightField = new JTextField(20);
		sexField = new JTextField(20);

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		dofField = new JFormattedTextField(df);

		nameField.setVisible(false);
		dofField.setVisible(false);
		heightField.setVisible(false);
		weightField.setVisible(false);
		sexField.setVisible(false);

		backButton.addActionListener(this);
		editButton.addActionListener(this);

		this.selectedProfile = selectedProfile;

		editName.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Edit Profile");
		setSize(450, 300);
		JPanel namePanel = new JPanel();
		JPanel dofPanel = new JPanel();
		JPanel heightPanel = new JPanel();
		JPanel weightPanel = new JPanel();
		JPanel sexPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel editAll = new JPanel();
		mainPanel.setLayout(new GridLayout(8, 1));
		editAll.setLayout(new GridLayout(1, 2));
		namePanel.setLayout(new GridLayout(1, 3));
		dofPanel.setLayout(new GridLayout(1, 3));
		heightPanel.setLayout(new GridLayout(1, 3));
		weightPanel.setLayout(new GridLayout(1, 3));
		sexPanel.setLayout(new GridLayout(1, 3));
		nameLabel = new JLabel(selectedProfile);
		JLabel editAllLabel = new JLabel("Do you wish to edit all?");
		editAll.add(editAllLabel);
		editAll.add(toggleButton);
		namePanel.add(nameLabel);
		namePanel.add(editName);
		namePanel.add(nameField);
		dofLabel = new JLabel();
		dofPanel.add(dofLabel);
		dofPanel.add(editDof);
		dofPanel.add(dofField);
		heightLabel = new JLabel();
		heightPanel.add(heightLabel);
		heightPanel.add(editHeight);
		heightPanel.add(heightField);
		weightLabel = new JLabel();
		weightPanel.add(weightLabel);
		weightPanel.add(editWeight);
		weightPanel.add(weightField);
		sexLabel = new JLabel();
		sexPanel.add(sexLabel);
		sexPanel.add(editSex);
		sexPanel.add(sexField);

		profileGroup = new ButtonGroup();

		profileGroup.add(editName);
		profileGroup.add(editDof);
		profileGroup.add(editHeight);
		profileGroup.add(editWeight);
		profileGroup.add(editSex);

		mainPanel.add(editAll);
		mainPanel.add(namePanel);
		mainPanel.add(dofPanel);
		mainPanel.add(heightPanel);
		mainPanel.add(weightPanel);
		mainPanel.add(sexPanel);
		mainPanel.add(editButton);
		mainPanel.add(backButton);
		add(mainPanel);

		DatabaseManagerProfile manager = new DatabaseManagerProfile();

		//displays the values in the frame
		try {
			sexLabel.setText("Sex: " + manager.getSex(selectedProfile));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			heightLabel.setText("Height: " + manager.getHeight(selectedProfile));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			weightLabel.setText("Weight: " + manager.getWeight(selectedProfile));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			dofLabel.setText("Date of Birth: " + manager.getDof(selectedProfile));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}


	/** 
	 *
	 * Sets the profile state
	 *
	 * @param state  the state. 
	 */
	public void setProfileState(ProfileState state) { 

		this.profileState = state;
	}


	/** 
	 *
	 * Gets the profile state
	 *
	 * @return the profile state
	 */
	public ProfileState getProfileState() { 

		return profileState;
	}

	// Modify handleToggleButtonClick, updateToggleButtonState, and updateFieldsVisibility
	// to delegate the behavior to the current state

	/** 
	 *
	 * Handle toggle button click
	 *
	 */
	private void handleToggleButtonClick() { 

		profileState.handleToggleButtonClick(this);
	}


	/** 
	 *
	 * Update toggle button state
	 *
	 */
	public void updateToggleButtonState() { 

		profileState.updateToggleButtonState(this);
	}


	/** 
	 *
	 * Update fields visibility
	 *
	 */
	public void updateFieldsVisibility() { 

		profileState.updateFieldsVisibility(this);
	}

	// Modify updateFieldsVisibility to accept a boolean parameter

	/** 
	 *
	 * Update fields visibility
	 *
	 * @param isVisible  the is visible. 
	 */
	public void updateFieldsVisibility(boolean isVisible) { 

		nameField.setVisible(isVisible);
		dofField.setVisible(isVisible);
		heightField.setVisible(isVisible);
		weightField.setVisible(isVisible);
		sexField.setVisible(isVisible);

		editName.setVisible(!isVisible);
		editDof.setVisible(!isVisible);
		editHeight.setVisible(!isVisible);
		editSex.setVisible(!isVisible);
		editWeight.setVisible(!isVisible);
	}

	@Override

	/** 
	 *
	 * Action performed
	 *
	 * @param e  the e. 
	 */
	public void actionPerformed(ActionEvent e) { 

		if (e.getSource() == backButton) {
			dispose();
			mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
			mainFrame.setVisible(true);
		}

		if (e.getSource() == editButton) {

			if(isClicked == true) {
				DatabaseManagerProfile manager = new DatabaseManagerProfile();
				try {
					manager.updateName(selectedProfile, nameField.getText());
					nameLabel.setText(nameField.getText());
					selectedProfile = nameField.getText();
					manager.updateDof(selectedProfile, dofField.getText());
					manager.updateHeight(selectedProfile, heightField.getText());
					manager.updateWeight(selectedProfile, weightField.getText());
					manager.updateSex(selectedProfile, sexField.getText());
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				dispose();
				mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
				mainFrame.setVisible(true);
			}
			else {
				DatabaseManagerProfile manager = new DatabaseManagerProfile();
				if (editName.isSelected()) {
					try {
						manager.updateName(selectedProfile, nameField.getText());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					nameLabel.setText(nameField.getText());
					selectedProfile = nameField.getText();
					dispose();
					mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
					mainFrame.setVisible(true);
				}
				if (editDof.isSelected()) {
					try {
						manager.updateDof(selectedProfile, dofField.getText());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					dispose();
					mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
					mainFrame.setVisible(true);
				}
				if (editHeight.isSelected()) {
					try {
						manager.updateHeight(selectedProfile, heightField.getText());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					dispose();
					mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
					mainFrame.setVisible(true);
				}
				if (editWeight.isSelected()) {
					try {
						manager.updateWeight(selectedProfile, weightField.getText());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					dispose();
					mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
					mainFrame.setVisible(true);
				}
				if (editSex.isSelected()) {
					try {
						manager.updateSex(selectedProfile, sexField.getText());
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					dispose();
					mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
					mainFrame.setVisible(true);
				}
			}
		}
	}

	@Override

	/** 
	 *
	 * Item state changed
	 *
	 * @param e  the e. 
	 */
	public void itemStateChanged(ItemEvent e) { 

		Object source = e.getItemSelectable();

		if (source == editName) {
			nameField.setVisible(editName.isSelected());
		} else if (source == editDof) {
			dofField.setVisible(editDof.isSelected());
		} else if (source == editHeight) {
			heightField.setVisible(editHeight.isSelected());
		} else if (source == editWeight) {
			weightField.setVisible(editWeight.isSelected());
		} else if (source == editSex) {
			sexField.setVisible(editSex.isSelected());
		}
	}
}
