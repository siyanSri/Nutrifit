package Profile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mainGUI.mainGUIFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


 /**
 * The class Profile selectorUI extends Jframe
 */ 
public class ProfileSelectorUI extends JFrame{


/** 
 *
 * Profile selector UI
 *
 * @return public
 */
    public ProfileSelectorUI() { 

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        
        UserProfile user = new UserProfile();
        
        
        // Create a JList to display profiles
        ArrayList<String> profiles = user.getProfiles(); // Replace with actual profile names from the database
        JList<String> profileList = new JList<>(profiles.toArray(new String[profiles.size()]));
        JScrollPane scrollPane = new JScrollPane(profileList);

        // Create "Select Profile"z button
        JButton selectProfileButton = new JButton("Select Profile");
        selectProfileButton.addActionListener(new ActionListener() {
            @Override

/** 
 *
 * Action performed
 *
 * @param e  the e. 
 */
            public void actionPerformed(ActionEvent e) { 

            	
                // Add code to handle "Select Profile" button click
                String selectedProfile = profileList.getSelectedValue();
                if (selectedProfile != null) {
                    dispose(); // Dispose of the current window
                    mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                    mainFrame.setVisible(true);
                }
            }
        });

        panel.add(scrollPane);
        panel.add(selectProfileButton);
        add(panel);
        setVisible(true);
    }
}
