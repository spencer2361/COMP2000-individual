import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // keep all of swing? or just what we need, this was easier

public class UI extends JFrame {

    Sandbox sandbox;

    public UI(int width, int height, Sandbox sandbox) {
        this.sandbox = sandbox;

        //Frame Creation
        setTitle("COMP2000 Project");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Simulation Area
        JPanel simPanel = new SimPanel();
        simPanel.setBackground(Color.DARK_GRAY);
        add(simPanel, BorderLayout.CENTER);

        Timer timer = new Timer(16, e -> {
            sandbox.step();
            simPanel.repaint();
        });
        timer.start();

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

        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // draws or creates the sandbox and handles clicks within the simultaed area
    class SimPanel extends JPanel {
        SimPanel() {
            // Converting mous to pixels and allows us to spawn our material there
            MouseAdapter mouse = new MouseAdapter() {
                void place(MouseEvent e) {
                    int col = e.getX() / Sandbox.CELL_SIZE;
                    int row = e.getY() / Sandbox.CELL_SIZE;
                    // Collisiojn detection to ensure that we cant click outside of the simulated enviroment/grid
                    if (row >= 0 && row < Sandbox.ROWS && col >= 0 && col < Sandbox.COLS) {
                        sandbox.grid[row][col] = 1;
                        repaint();
                    }
                }

                // mous events for click and clicks+drag
                @Override
                public void mousePressed(MouseEvent e) {
                    place(e);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    place(e);
                }
            };
            addMouseListener(mouse);
            addMouseMotionListener(mouse);
        }

        // called whenever the panel needs to redraw
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // paint the dark gray background first
            g.setColor(Color.RED);
            int s = Sandbox.CELL_SIZE;
            // draw our material from the grid
            for (int row = 0; row < Sandbox.ROWS; row++) {
                for (int col = 0; col < Sandbox.COLS; col++) {
                    if (sandbox.grid[row][col] == 1) {
                        g.fillRect(col * s, row * s, s, s);
                    }
                }
            }
        }
    }
}
