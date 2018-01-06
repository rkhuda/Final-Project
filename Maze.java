import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

//import java.awt.Graphics;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.GridLayout;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Maze extends JPanel {

    public void paint(Graphics g) {

	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(10));
	g2.setPaint(Color.blue);
	g2.draw(new Rectangle2D.Float(0, 0, 500, 500));
    }

    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setBackground(Color.black);
	frame.add(new Maze());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(500, 200, 500, 520);
	frame.setVisible(true);
    }
    /*
    public Maze() {

	JFrame frame = new JFrame("MazeFoundation");
	frame.setTitle("Pacman");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	Container pane = frame.getContentPane();

	JPanel panel = new JPanel(new GridLayout(3, 0));
	for (int i = 1; i <= 9; i++) {
	    panel.add(new JButton("Button " + i));
	}
	panel.setBackground(Color.black);
	pane.add(panel, BorderLayout.CENTER);

	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args){
	Maze maze = new Maze();
    }
    */
    
}
