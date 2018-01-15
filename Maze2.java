import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.*;

public class Maze2 extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
    private ImageIcon Inky;
    private Pacman pac;
    private Enemy blue;
    private JLabel con;
    private Timer timerblue;
    private JLabel pm;
    private JLabel bg;
    private int tiles;
    private int actionNum;
    private int up;
    private int upCounter, downCounter, rightCounter, leftCounter;
    private int down;
    private int right;
    private int left;
    private int lastDirection = 0;
    public Maze2(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);
	addKeyListener(this);
	pane = getContentPane();
       	
	Pacman = new ImageIcon("Pacman.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(newimg);  // transform it back
	pm = new JLabel();
       	pac = new Pacman();

	Inky = new ImageIcon("Inky.png");
	Image image2 = Inky.getImage(); // transform it
	Image newimg2 = image2.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Inky = new ImageIcon(newimg2);  // transform it back
	bg = new JLabel();
        blue = new Enemy();

	
	 
	   
	
	pane.setLayout(new GridLayout(40 ,40 ));
	panels = new JPanel[40 ][40];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		
		JPanel p = panels[x][y];
	      	Container c = getContentPane();			    
	 	if (x == pac.getY() && y == pac.getX()) {
      		    pm.setIcon(Pacman);
		    p.setBackground(Color.BLACK);
		    p.add(pm);
		}
		if(x == blue.getY() && y == blue.getX()){
		    bg.setIcon(Inky);
		    p.add(bg);
		}
	       
	        p.setBackground(Color.BLACK);
     		pane.add(p);
		
	    }
	}
	
       	ActionListener BlueGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

		    if (lastDirection == 0)
			randomMove();
		    else{
	
	
			if (lastDirection == 3)
			    {
				if (upCounter !=0)
				    {
					moveUpBlue();
					upCounter--;
				    }else
				    randomMove();			

			    }
			if (lastDirection == 4)
			    {
				if (downCounter !=0)
				    {
					moveDownBlue();
					downCounter--;
				    }else
				    randomMove();			

			    }
			if (lastDirection == 5)
			    {
				if (rightCounter !=0)
				    {
					moveRightBlue();
					rightCounter--;
				    }else
				    randomMove();			

			    }
		    
			if (lastDirection == 6)
			    {
				if (leftCounter !=0)
				    {
					moveLeftBlue();
					leftCounter--;
				    }else
				    randomMove();			

			    }
		    


	
		    }
		}
	    };
        Timer timer = new Timer(1000, BlueGhost);
        timer.setRepeats(true);
        timer.start();
	


    
    
    }

    public void moveUpBlue(){
	if(blue.getY()- 1 >= 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveDownBlue(){
	if(blue.getY() + 1 <= 39){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveRightBlue(){
	if(blue.getX()+ 1 <= 39){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveLeftBlue(){
	if(blue.getX()- 1 >= 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
  
    public void randomMove(){
	int rand = (3 + (int)(Math.random() * (4)));
 		
		if(rand == 3){
		   moveUpBlue();
		   lastDirection = 3;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 4){
		  moveDownBlue();
		  lastDirection = 4;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 5){
		    moveRightBlue();
		    lastDirection = 5;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 6){
		    moveLeftBlue();
		    lastDirection = 6;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
	}
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	//	 b = new JLabel();
	
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    System.out.println(pac.getY());
	    
	    // b.setLocation(1,1);
 	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    // panels[pac.getY()][pac.getX()].setBackground(Color.WHITE);
	    pm.setIcon(Pacman);
	    System.out.println(pac.getY());
	}
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 >= 0){
       	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
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
    

