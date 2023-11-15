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

public class ProfileSelectorUI extends JFrame{

    public ProfileSelectorUI() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();

        
        UserProfile user = new UserProfile();
        
        
        // Create a JList to display profiles
        ArrayList<String> profiles = user.getProfiles(); // Replace with actual profile names from the database
        System.out.println(profiles);
        JList<String> profileList = new JList<>(profiles.toArray(new String[profiles.size()]));
        JScrollPane scrollPane = new JScrollPane(profileList);

        // Create "Select Profile"z button
        JButton selectProfileButton = new JButton("Select Profile");
        selectProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to handle "Select Profile" button click
                String selectedProfile = profileList.getSelectedValue();
                if (selectedProfile != null) {
                    System.out.println("Selected Profile: " + selectedProfile);
                    dispose(); // Dispose of the current window
                    // Add logic to open the selected profile
                    mainGUIFrame mainFrame = new mainGUIFrame(selectedProfile);
                    mainFrame.setVisible(true);
                }
            }
        });

        // Add components to the panel
        panel.add(scrollPane);
        panel.add(selectProfileButton);

        // Add the panel to the frame
        add(panel);

        // Set frame visibility
        setVisible(true);
    }
}
