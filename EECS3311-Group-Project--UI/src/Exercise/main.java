package Exercise;

import javax.swing.SwingUtilities;

public class main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ExerciseUI form = new ExerciseUI();
                form.setVisible(true);
            }
        });    
    }

}
