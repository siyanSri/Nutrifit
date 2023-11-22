package Profile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * The class Select UI extends Jframe
 */ 
public class SelectUI extends JFrame{


	/** 
	 *
	 * Select UI
	 *
	 * @return 	public
	 */
	public SelectUI() { 

		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a panel to hold the buttons
		JPanel panel = new JPanel();

		// Create "Select Profile" button
		JButton selectProfile = new JButton("Select Profile");
		selectProfile.addActionListener(new ActionListener() {
			@Override

			/** 
			 *
			 * Action performed, show profiles
			 *
			 * @param e  the e. 
			 */
			public void actionPerformed(ActionEvent e) { 

				dispose(); // Dispose of the current window
				ProfileSelectorUI newWindow = new ProfileSelectorUI();
				newWindow.setVisible(true);
			}
		});

		JButton createProfile = new JButton("Create Profile");
		createProfile.addActionListener(new ActionListener() {
			@Override

			/** 
			 *
			 * Action performed, create profile frame
			 *
			 * @param e  the e. 
			 */
			public void actionPerformed(ActionEvent e) { 

				dispose(); // Dispose of the current window
				ProfileUI newWindow = new ProfileUI();
				newWindow.setVisible(true);
			}
		});


		panel.add(selectProfile);
		panel.add(createProfile);
		add(panel);
		setVisible(true);
	}
}
