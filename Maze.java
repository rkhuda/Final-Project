import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.border.*;
//import java.awt.Graphics;
//import java.awt.BorderLayout;
//import java.awt.Container;
//import java.awt.GridLayout;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class Maze extends JFrame {
    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
   
 public Maze(){
        this.setTitle("PACMAN");
	this.setSize(900,900);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	this.setBackground(Color.BLACK);
	pane = getContentPane();
	//	this.setBackground(Color.red);
	//	Pacman = new ImageIcon("Pacman.png");
	ImageIcon Pacman = new ImageIcon("Pacman.png");
	Image image = Pacman.getImage(); // transform it 
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH); 
	Pacman = new ImageIcon(newimg);  // transform it back

	pane.setLayout(new GridLayout(40,40));
	panels = new JPanel[40][39];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
		JLabel b = new JLabel();
	       	Container c = getContentPane();
	
		    
		
		if (x == 25 && y == 20) {
                    b.setIcon(Pacman);
                    p.setBackground(Color.BLACK);
		   

		}
		else{
		    p.setBackground(Color.BLACK);
		}
		p.add(b);
		pane.add(p);
	    }

	}
 }
    /* public void paint(Graphics g) {

	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(10));
	g2.setPaint(Color.blue);
	g2.draw(new Rectangle2D.Float(0, 0, 500, 500));
    }

    }

    */
    
    public static void main(String[] args){
	Maze ma = new Maze();
	
	ma.setVisible(true);
    }
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
    

