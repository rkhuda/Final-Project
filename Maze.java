import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Maze extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
    private Pacman pac;
    public Maze(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);
	addKeyListener(this);
	pane = getContentPane();
	
	Pacman = new ImageIcon("Pacman.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(newimg);  // transform it back
	//	pac = new Pacman(0,0);
	pane.setLayout(new GridLayout(40,40));
	panels = new JPanel[40][40];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
		JLabel b = new JLabel();
	       	Container c = getContentPane();
		
		    
		
		if (x == 20 && y == 20) {
		    //      pac.setX(20);
		    //        pac.setY(20);
		      b.setIcon(Pacman);
		    p.setBackground(Color.WHITE);
		   

		}
		else{
		    p.setBackground(Color.BLACK);
		}
		p.add(b);
		pane.add(p);
	    }

	}
    }
    
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
        
	JLabel b = new JLabel();
	panels[20][21].add(b);
		if(c == KeyEvent.VK_UP){
		    b.setIcon(Pacman);
		    //	    panels[20][21].setBackground(Color.WHITE);
		    //	    panels[20][22].setBackground(Color.WHITE);
	    System.out.println(c);
	    
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
	Maze maze = new Maze();
	maze.setVisible(true);
	//	maze.pack();
    }
 }
    

