package Meal;

import javax.swing.SwingUtilities;


public class main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MealUI form = new MealUI();
                form.setVisible(true);
            }
        });    
    }
}
