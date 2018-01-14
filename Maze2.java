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
	this.setBounds(300, 200, 900, 900);
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
	pane.setLayout(new GridLayout(40 ,40 ));

	panels = new JPanel[40 ][40];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
		//	con  = new JLabel();
		
	       	Container c = getContentPane();
	
		    
		   			
		if (x == pac.getY() && y == pac.getX()) {
		    //      pac.setX(20);
		    //        pac.setY(20);
		     b.setIcon(R);
		    p.setBackground(Color.BLACK);
		    p.add(b);
		}
		
		
		
		
		    p.setBackground(Color.BLACK);
	    
		    //	p.add(con);
		pane.add(p);

		if (x == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Color.BLUE));
		}
		if (x == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.BLUE));
		}
		if (y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, Color.BLUE));
		}
		if (y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, Color.BLUE));
		}
		if (x == 0 && y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 0, Color.BLUE));
		}
		if (x == 39 && y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 0, Color.BLUE));
		}
		if (x == 0 && y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 10, Color.BLUE));
		}
		if (x == 39 && y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 10, Color.BLUE));
		}
	    }
	}
    }

    
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	//	 b = new JLabel();
	
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 > 0){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(U);
	    System.out.println(pac.getY());
	    
	    // b.setLocation(1,1);
 	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 < 39){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(D);
	    System.out.println(pac.getY());
	}
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 < 39){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(R);
	    System.out.println(pac.getX());
	}
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 > 0){
       	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(L);
	    System.out.println(pac.getX());
	}
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
	//	JLabel b = new JLabel();
	//	(panels[pac.getX()][pac.getY()]).setIcon(Pacman);
	//	b.setIcon(Pacman);
    }
    
    public static void main(String[] args){
	Maze2 maze = new Maze2();
	maze.setVisible(true);
	//	maze.pack();
    }
}
