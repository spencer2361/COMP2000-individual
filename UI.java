import java.awt.*;
import javax.swing.*; // keep all of swing? or just what we need, this was easier

public class UI extends JFrame {

    public UI(int width, int height) {

        //Frame Creation
        setTitle("COMP2000 Project");
        setLayout(new BorderLayout());
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);

        //Close Window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Simulation Area
        JPanel simPanel = new JPanel();
        simPanel.setBackground(Color.DARK_GRAY);

        add(simPanel, BorderLayout.CENTER);


        //Side Bar
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(150, 0));
        sidePanel.setBackground(Color.GRAY);

        add(sidePanel, BorderLayout.EAST);


        //Bottom Bar
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0, 60));
        bottomPanel.setBackground(Color.GRAY);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
