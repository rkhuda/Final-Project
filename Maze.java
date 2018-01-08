import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Maze extends JFrame {

    private Container pane;
    private JPanel[][] panels;

    private ImageIcon Pacman;
    private ImageIcon Blinky;
    private ImageIcon Pinky;
    private ImageIcon Inky;
    private ImageIcon Clyde;
    

    public Maze(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);

	pane = getContentPane();

	Pacman = new ImageIcon("Pacman.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(newimg);  // transform it back

	Blinky = new ImageIcon("Blinky.png");
	Image image2 = Blinky.getImage();
	Image newimage = image2.getScaledInstance(23, 23, java.awt.Image.SCALE_SMOOTH);
	Blinky = new ImageIcon(newimage);

	pane.setLayout(new GridLayout(40,40));
	panels = new JPanel[40][40];
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
		else if (x == 0 && y == 0) {
			b.setIcon(Blinky);
			p.setBackground(Color.BLACK);
		    }
		else{
		    p.setBackground(Color.BLACK);
		}
		
		p.add(b);
		pane.add(p);
		b.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    }

	}
 }
    
    public static void main(String[] args){
	Maze maze = new Maze();
	maze.setVisible(true);
    }
 }
    

