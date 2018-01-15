import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Maze2 extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private JLabel con;
    private JLabel b;

    private ImageIcon R;
    private ImageIcon L;
    private ImageIcon U;
    private ImageIcon D;

    private Pacman pac;

    public Maze2(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(400, 100, 700, 700);
	this.setResizable(false);
	
	addKeyListener(this);
	pane = getContentPane();

	R = new ImageIcon("PacmanRight.png");
	Image imageR = R.getImage(); // transform it
	Image newimgR = imageR.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	R = new ImageIcon(newimgR);  // transform it back

        L = new ImageIcon("PacmanLeft.png");
	Image imageL = L.getImage(); // transform it
	Image newimgL = imageL.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	L = new ImageIcon(newimgL);  // transform it back

        D = new ImageIcon("PacmanDown.png");
	Image imageD = D.getImage(); // transform it
	Image newimgD = imageD.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	D = new ImageIcon(newimgD);  // transform it back

        U = new ImageIcon("PacmanUp.png");
	Image imageU = U.getImage(); // transform it
	Image newimgU = imageU.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	U = new ImageIcon(newimgU);  // transform it back

	b = new JLabel();
       	pac = new Pacman();
	pane.setLayout(new GridLayout(25, 25));

	panels = new JPanel[25][25];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
	       	Container c = getContentPane();
		
		if (x == pac.getY() && y == pac.getX()) {
		    b.setIcon(R);
		    p.setBackground(Color.BLACK);
		    p.add(b);
		}

		p.setBackground(Color.BLACK);
		pane.add(p);

		if (x == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(27, 0, 0, 0, Color.BLUE));
		}
		if (x == 24) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 27, 0, Color.BLUE));
		}
		if (y == 0 && (x != 0 && x != 24)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if (y == 24 && (x != 0 && x != 24)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 28, Color.BLUE));
		}
		if ((y == 2 || y == 22) && (x == 2 || x == 3 || x == 4 || x == 6 || x == 8 ||
			       x == 9 || x == 10 || x == 12 || x == 13 || x == 14 || x == 16 ||
			       x == 18 || x == 20 || x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 3 || y == 21) && (x == 2 || x == 6 || x == 14 || x == 16 || x == 18 ||
					    x == 20 || x == 22)){
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 4 || y == 20) && (x == 2 || x == 4 || x == 6 || x == 8 || x == 9 ||
					    x == 10 || x == 11 || x == 12 || x == 14 ||
					    x == 18 || x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 5 || y == 19) && (x == 4 || x == 12 || x == 16 || x == 17 || x == 18 ||
					    x == 20 || x == 21 || x == 22)){
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 6 || y == 18) && (x == 2 || x == 3|| x == 4 || x == 6 || x == 7||
					    x == 9 || x == 10 || x == 11 || x == 12 || x == 13 ||
					    x == 14)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 7 || y == 17) && (x == 7 || x == 12 || x == 16 || x == 17 || x == 18 ||
					    x == 20 || x == 21 || x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 8 || y == 16) && (x == 2 || x == 3|| x == 4 || x == 5|| x == 7 ||
					    x == 9 || x == 10 || x == 12 || x == 13 ||
					    x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 9 || y == 15) && (x == 2 || x == 7 || x == 16 || x == 17 || x == 18 ||
					    x == 19 || x == 20 || x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 10 || y == 14) && (x == 2 || x == 4 || x == 5 || x == 13  ||
					     x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if ((y == 11 || y == 13) && (x == 7 || x == 13 || x == 15 || x == 16 ||
					     x == 18 || x == 20)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if (y == 12 && (x == 1 || x == 2 || x == 4 || x == 5 || x == 6 || x == 7 ||
				x == 13 || x == 14 || x == 15 || x == 16 || x == 18 || x == 20 ||
				x == 22 || x == 23)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		
		//make center box
		if ((x == 9 || x == 11) && (y == 10 || y == 11 ||  y == 13 ||
					    y == 14)) {
		    p.setBorder(BorderFactory.createMatteBorder(28, 0, 0, 0, Color.BLUE));
		}
		if (x == 10 && (y == 10 || y == 14)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		}
		if (x == 11 && y == 12) {
		     p.setBorder(BorderFactory.createMatteBorder(28, 0, 0, 0, Color.BLUE));
		}
	    }
	}
    }

    
    public void keyPressed(KeyEvent e){

	int c = e.getKeyCode();
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 > 0 &&
	   (panels[pac.getY() - 1][pac.getX()].getBorder() == null)){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(U);
 	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 < 39 &&
	   (panels[pac.getY() + 1][pac.getX()].getBorder() == null)){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(D);
	}
	
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 < 39 &&
	   (panels[pac.getY()][pac.getX() + 1].getBorder() == null)){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(R);
	}
	
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 > 0 &&
	   (panels[pac.getY()][pac.getX() - 1].getBorder() == null)){
       	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(L);
	}
    }

    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){}
    
    public static void main(String[] args){
	Maze2 maze = new Maze2();
	maze.setVisible(true);
    }
}
