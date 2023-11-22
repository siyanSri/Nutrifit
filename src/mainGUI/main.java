package mainGUI;
import javax.swing.SwingUtilities;
import Profile.SelectUI;

public class main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SelectUI  main = new SelectUI();
                main.setVisible(true);
            }
        });
    }    

}




