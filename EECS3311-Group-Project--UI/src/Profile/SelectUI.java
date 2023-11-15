package Profile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectUI extends JFrame{

	public SelectUI() {
	    setSize(300, 200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    // Create a panel to hold the buttons
	    JPanel panel = new JPanel();
	
	    // Create "Select Profile" button
	    JButton selectProfile = new JButton("Select Profile");
	    selectProfile.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	dispose(); // Dispose of the current window
	            ProfileSelectorUI newWindow = new ProfileSelectorUI();
	            newWindow.setVisible(true);
	        }
	    });
	
	    // Create "Create Profile" button
	    JButton createProfile = new JButton("Create Profile");
	    createProfile.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	dispose(); // Dispose of the current window
	            ProfileUI newWindow = new ProfileUI();
	            newWindow.setVisible(true);
	        }
	    });
	
	    // Add buttons to the panel
	    panel.add(selectProfile);
	    panel.add(createProfile);
	
	    // Add the panel to the frame
	    add(panel);
	
	    // Set frame visibility
	    setVisible(true);
	}
}
