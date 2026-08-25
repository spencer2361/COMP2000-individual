import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JFrame{
    public UI(int width, int height) {

        //Frame Creation
        setTitle("COMP2000 Project");
        setLayout(new BorderLayout());
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);


        //Close Window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        //Background
        panel.setBackground(Color.DARK_GRAY);
    }    
}
