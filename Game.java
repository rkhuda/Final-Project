import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Game extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
    private Pacman pac;
    private JLabel con;
    private JLabel b;
    public Game(){
	
	this.setTitle("Pacman Game");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);
	addKeyListener(this);
	pane = getContentPane();
	//	b = new JLabel();
	Pacman = new ImageIcon("Pacman.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(newimg);  // transform it back
       	pac = new Pacman();
	pane.setLayout(new GridLayout(40,40));
	panels = new JPanel[40][40];
       	con = new JLabel();
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
		con = new JLabel();
	       	Container c = getContentPane();
		p.setBackground(Color.BLACK);
	       	pane.add(p);
	    }
	}
	panels[20][20].add(con);
	con.setIcon(Pacman);
	//	panels[30][30].setBackground(Color.WHITE);
	//	pane.add(panels[30][30]);
    }
		
		/*	if (x == pac.getY() && y == pac.getX()) {
		    //      pac.setX(20);
		    //        pac.setY(20);
		    con.setIcon(Pacman);
		    p.setBackground(Color.BLACK);
		   

		   
		else{
		    p.setBackground(Color.BLACK);
		}
		p.add(con);
		pane.add(p);
	    }
		*/

	    

	
    
    
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	b = new JLabel();
	boolean start = true;
	if(start || c == KeyEvent.VK_UP || c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_DOWN){
	    con.setIcon(null);
	    start = false;
	}
	    
  	if(c == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getY());
	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getY());
	}
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 >= 0){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	this.setVisible(true);
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
	this.setVisible(true);
    }
    
    public static void main(String[] args){
	Game game = new Game();
	game.setVisible(true);

    }
}
    

