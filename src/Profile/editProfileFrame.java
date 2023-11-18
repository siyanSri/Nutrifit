package Profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import connection.DatabaseContext;
import connection.DatabaseStrategy;
import connection.MySqlConnectionStrategy;
import mainGUI.mainGUIFrame;

public class editProfileFrame extends JFrame implements ItemListener, ActionListener {
	private String username ;
	private String password ;
	
	
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

    public editProfileFrame(String selectedProfile) {
    	
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
    	
    	username = System.getenv("NAME").toString();
		password = System.getenv("PASS").toString();
		
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
        mainPanel.setLayout(new GridLayout(7, 1));
        namePanel.setLayout(new GridLayout(1, 3));
        dofPanel.setLayout(new GridLayout(1, 3));
        heightPanel.setLayout(new GridLayout(1, 3));
        weightPanel.setLayout(new GridLayout(1, 3));
        sexPanel.setLayout(new GridLayout(1, 3));
        nameLabel = new JLabel(selectedProfile);
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

        mainPanel.add(namePanel);
        mainPanel.add(dofPanel);
        mainPanel.add(heightPanel);
        mainPanel.add(weightPanel);
        mainPanel.add(sexPanel);
        mainPanel.add(editButton);
        mainPanel.add(backButton);
        add(mainPanel);

        // Retrieve user profile data from the database and display in labels
        retrieveAndDisplayUserProfile(selectedProfile);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
            mainFrame.setVisible(true);
        }
        
        if (e.getSource() == editButton) {
        	if (editName.isSelected()) {
        		try {
            	    updateName(selectedProfile, nameField.getText());
            	} catch (SQLException ex) {
            	    ex.printStackTrace();
            	}
        		dispose();
                mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                mainFrame.setVisible(true);
        	}
        	if (editDof.isSelected()) {
        		try {
            	    updateDof(selectedProfile, dofField.getText());
            	} catch (SQLException ex) {
            	    ex.printStackTrace();
            	}
        		dispose();
                mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                mainFrame.setVisible(true);
        	}
        	if (editHeight.isSelected()) {
        		try {
            	    updateHeight(selectedProfile, heightField.getText());
            	} catch (SQLException ex) {
            	    ex.printStackTrace();
            	}
        		dispose();
                mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                mainFrame.setVisible(true);
        	}
        	if (editWeight.isSelected()) {
        		try {
            	    updateWeight(selectedProfile, weightField.getText());
            	} catch (SQLException ex) {
            	    ex.printStackTrace();
            	}
        		dispose();
                mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                mainFrame.setVisible(true);
        	}
        	if (editSex.isSelected()) {
        		try {
            	    updateSex(selectedProfile, sexField.getText());
            	} catch (SQLException ex) {
            	    ex.printStackTrace();
            	}
        		dispose();
                mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                mainFrame.setVisible(true);
        	}
        } 
    }
    
    @Override
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

    private void retrieveAndDisplayUserProfile(String name) {
        
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy(); 
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        
        String sql = "SELECT * FROM profiles WHERE name = '" + name + "'";

        try {
            ResultSet resultSet = databaseContext.executeDatabaseOperations(username, password, sql);

            if (resultSet.next()) {
                
                sexLabel.setText("Sex: " + resultSet.getString("sex"));
                heightLabel.setText("Height: " + resultSet.getString("height"));
                weightLabel.setText("Weight: " + resultSet.getString("weight"));
                dofLabel.setText("Date of Birth: " + resultSet.getString("dof"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateName(String name, String newName) throws SQLException {
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy();
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        String sql = "UPDATE profiles SET name = '" + newName + "' WHERE name = '" + name + "'";

        databaseContext.executeDatabaseOperations(username, password, sql);
        nameLabel.setText(newName);
        selectedProfile = newName;
    }
    
    private void updateDof(String name, String newDof) throws SQLException {
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy();
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        String sql = "UPDATE profiles SET dof = '" + newDof + "' WHERE name = '" + name + "'";

        databaseContext.executeDatabaseOperations(username, password, sql);
    }
    
    private void updateHeight(String name, String newHeight) throws SQLException {
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy();
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        String sql = "UPDATE profiles SET height = '" + newHeight + "' WHERE name = '" + name + "'";

        databaseContext.executeDatabaseOperations(username, password, sql);
     
    }
    
    private void updateWeight(String name, String newWeight) throws SQLException {
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy();
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        String sql = "UPDATE profiles SET weight = '" + newWeight + "' WHERE name = '" + name + "'";

        databaseContext.executeDatabaseOperations(username, password, sql);
     
    }
    
    private void updateSex(String name, String newSex) throws SQLException {
        DatabaseStrategy databaseStrategy = new MySqlConnectionStrategy();
        DatabaseContext databaseContext = new DatabaseContext();
        databaseContext.setDatabaseStrategy(databaseStrategy);

        String sql = "UPDATE profiles SET sex = '" + newSex + "' WHERE name = '" + name + "'";

        databaseContext.executeDatabaseOperations(username, password, sql);
     
    }
}