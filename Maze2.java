import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
public class Maze2 extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
    private ImageIcon Inky;
    private ImageIcon Clyde;
    private ImageIcon Pinky;
    private ImageIcon Blinky;
    private Pacman pac;
    private Enemy blue;
    private Enemy yellow;
    private Enemy pink;
    private Enemy red;
    private JLabel con;
    private Timer timerblue;
    private JLabel pm;
    private JLabel bg;
    private JLabel yg;
    private JLabel pg;
    private JLabel rg;
    private int tiles;
    private int actionNum;
    private int up;
    private int upCounter, downCounter, rightCounter, leftCounter;
    private int down;
    private int right;
    private int left;
    private int lastDirectionBlue;
    private int lastDirectionYellow;
    private int lastDirectionPink;
    private int lastDirectionRed;
    private TimerTask tt;
    private Timer t;
    private int pressed;
    
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
        blue = new Enemy(10,5);
	
	Clyde = new ImageIcon("Clyde.png");
	Image image3 = Clyde.getImage(); // transform it
	Image newimg3 = image3.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Clyde = new ImageIcon(newimg3);  // transform it back
	yg = new JLabel();
        yellow = new Enemy(9,5);
		
       	Pinky = new ImageIcon("Pinky.png");
	Image image4 = Pinky.getImage(); // transform it
	Image newimg4 = image4.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pinky = new ImageIcon(newimg4);  // transform it back
	pg = new JLabel();
        pink = new Enemy(10,4);
		
	Blinky = new ImageIcon("Blinky.png");
	Image image5 = Blinky.getImage(); // transform it
	Image newimg5 = image5.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Blinky = new ImageIcon(newimg5);  // transform it back
	rg = new JLabel();
        red = new Enemy(9,4);
		       	

	
	 
	   
	
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
		if(x == yellow.getY() && y == yellow.getX()){
		    yg.setIcon(Clyde);
		    p.add(yg);
		}
			if(x == pink.getY() && y == pink.getX()){
		    pg.setIcon(Pinky);
		    p.add(pg);
		}
			if(x == red.getY() && y == red.getX()){
		    rg.setIcon(Blinky);
		    p.add(rg);
		}
		
	        p.setBackground(Color.BLACK);
     		pane.add(p);
		
	    }
	}
		
       	ActionListener BlueGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

		    if (lastDirectionBlue == 0)
			randomMoveBlue();
		    else{
	
	
			if (lastDirectionBlue == 1)
			    {
				if (upCounter !=0)
				    {
					moveUpBlue();
					upCounter--;
				    }else
				    randomMoveBlue();			

			    }
			if (lastDirectionBlue == 2)
			    {
				if (downCounter !=0)
				    {
					moveDownBlue();
					downCounter--;
				    }else
				    randomMoveBlue();			

			    }
			if (lastDirectionBlue == 3)
			    {
				if (rightCounter !=0)
				    {
					moveRightBlue();
					rightCounter--;
				    }else
				    randomMoveBlue();			

			    }
		    
			if (lastDirectionBlue == 4)
			    {
				if (leftCounter !=0)
				    {
					moveLeftBlue();
					leftCounter--;
				    }else
				    randomMoveBlue();			

			    }
		    


	
		    }
		}
	    };
        Timer timerBlue = new Timer(200, BlueGhost);
        timerBlue.setRepeats(true);
        timerBlue.start();
	
ActionListener YellowGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

		    if (lastDirectionYellow == 0)
			randomMoveYellow();
		    else{
	
	
			if (lastDirectionYellow == 3)
			    {
				if (upCounter !=0)
				    {
					moveUpYellow();
					upCounter--;
				    }else
				    randomMoveYellow();			

			    }
			if (lastDirectionYellow == 4)
			    {
				if (downCounter !=0)
				    {
					moveDownYellow();
					downCounter--;
				    }else
				    randomMoveYellow();			

			    }
			if (lastDirectionYellow == 5)
			    {
				if (rightCounter !=0)
				    {
					moveRightYellow();
					rightCounter--;
				    }else
				    randomMoveYellow();			

			    }
		    
			if (lastDirectionYellow == 6)
			    {
				if (leftCounter !=0)
				    {
					moveLeftYellow();
					leftCounter--;
				    }else
				    randomMoveYellow();			

			    }
		    


	
		    }
		}
	    };
        Timer timerYellow = new Timer(200, YellowGhost);
        timerYellow.setRepeats(true);
        timerYellow.start();
	
ActionListener PinkGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

		    if (lastDirectionPink == 0)
			randomMovePink();
		    else{
	
	
			if (lastDirectionPink == 1)
			    {
				if (upCounter !=0)
				    {
					moveUpPink();
					upCounter--;
				    }else
				    randomMovePink();			

			    }
			if (lastDirectionPink == 2)
			    {
				if (downCounter !=0)
				    {
					moveDownPink();
					downCounter--;
				    }else
				    randomMovePink();			

			    }
			if (lastDirectionPink == 3)
			    {
				if (rightCounter !=0)
				    {
					moveRightPink();
					rightCounter--;
				    }else
				    randomMovePink();			

			    }
		    
			if (lastDirectionPink == 4)
			    {
				if (leftCounter !=0)
				    {
					moveLeftPink();
					leftCounter--;
				    }else
				    randomMovePink();			

			    }
		    


	
		    }
		}
	    };
        Timer timerPink = new Timer(200, PinkGhost);
        timerPink.setRepeats(true);
        timerPink.start();
ActionListener RedGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {

		    if (lastDirectionRed == 0)
			randomMoveRed();
		    else{
	
	
			if (lastDirectionRed == 1)
			    {
				if (upCounter !=0)
				    {
					moveUpRed();
					upCounter--;
				    }else
				    randomMoveRed();			

			    }
			if (lastDirectionRed == 2)
			    {
				if (downCounter !=0)
				    {
					moveDownRed();
					downCounter--;
				    }else
				    randomMoveRed();			

			    }
			if (lastDirectionRed == 3)
			    {
				if (rightCounter !=0)
				    {
					moveRightRed();
					rightCounter--;
				    }else
				    randomMoveRed();			

			    }
		    
			if (lastDirectionRed == 4)
			    {
				if (leftCounter !=0)
				    {
					moveLeftRed();
					leftCounter--;
				    }else
				    randomMoveRed();			

			    }
		    


	
		    }
		}
	    };
        Timer timerRed = new Timer(100, RedGhost);
        timerRed.setRepeats(true);
        timerRed.start();

	new Timer(100,new ActionListener(){
		public void actionPerformed(ActionEvent a){
		    if(pressed == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
			pm.setIcon(null);
			panels[pac.getY()][pac.getX()].repaint();
			pac.setY(pac.getY() - 1);
			panels[pac.getY()][pac.getX()].add(pm);
			pm.setIcon(Pacman);
			//	System.out.println(pac.getY());
			meetPac();
		    }
		    if(pressed == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
			pm.setIcon(null);
			panels[pac.getY()][pac.getX()].repaint();
			pac.setY(pac.getY() + 1);
			panels[pac.getY()][pac.getX()].add(pm);
	  	       	pm.setIcon(Pacman);
			//	System.out.println(pac.getY());
			meetPac();
		    }
	
	
		    if(pressed == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
			pm.setIcon(null);
			panels[pac.getY()][pac.getX()].repaint();
			pac.setX(pac.getX() + 1);
			panels[pac.getY()][pac.getX()].add(pm);
			pm.setIcon(Pacman);
			//	System.out.println(pac.getX());
			meetPac();
		    }
	

		    if(pressed == KeyEvent.VK_LEFT && pac.getX() - 1 >= 0){
			pm.setIcon(null);
			panels[pac.getY()][pac.getX()].repaint();
			pac.setX(pac.getX() - 1);
			panels[pac.getY()][pac.getX()].add(pm);
			pm.setIcon(Pacman);
			//	System.out.println(pac.getX());
			meetPac();
		    }
		    
		    
		}
	    }).start();
      
       
    
    }

    public void moveUpBlue(){
	if(blue.getY()- 1 >= 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	    meetBlue();
	}
    }
    public void moveDownBlue(){
	if(blue.getY() + 1 <= 39){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	    meetBlue();
	}
    }
    public void moveRightBlue(){
	if(blue.getX()+ 1 <= 39){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	    meetBlue();
	}
    }
    public void moveLeftBlue(){
	if(blue.getX()- 1 >= 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	    meetBlue();
	}
    }
  
    public void randomMoveBlue(){
	int rand = (1 + (int)(Math.random() * (4)));
 		
		if(rand == 1){
		   moveUpBlue();
		   lastDirectionBlue = 1;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 2){
		  moveDownBlue();
		  lastDirectionBlue = 2;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 3){
		    moveRightBlue();
		    lastDirectionBlue = 3;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 4){
		    moveLeftBlue();
		    lastDirectionBlue = 4;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
	}







public void moveUpYellow(){
	if(yellow.getY()- 1 >= 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	    meetYellow();
	}
    }
    public void moveDownYellow(){
	if(yellow.getY() + 1 <= 39){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	    meetYellow();
	}
    }
    public void moveRightYellow(){
	if(yellow.getX()+ 1 <= 39){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	    meetYellow();
	}
    }
    public void moveLeftYellow(){
	if(yellow.getX()- 1 >= 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	    meetYellow();
	}
    }
  
    public void randomMoveYellow(){
	int rand = (3 + (int)(Math.random() * (5)));
 		
		if(rand == 3){
		   moveUpYellow();
		   lastDirectionYellow = 3;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 4){
		  moveDownYellow();
		  lastDirectionYellow = 4;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 5){
		    moveRightYellow();
		    lastDirectionYellow = 5;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 6 || rand == 7){
		    moveLeftYellow();
		    lastDirectionYellow = 6;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
    }

public void moveUpPink(){
	if(pink.getY()- 1 >= 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	    meetPink();
	}
    }
    public void moveDownPink(){
	if(pink.getY() + 1 <= 39){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	    meetPink();
	}
    }
    public void moveRightPink(){
	if(pink.getX()+ 1 <= 39){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	    meetPink();
	}
    }
    public void moveLeftPink(){
	if(pink.getX()- 1 >= 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	    meetPink();
	}
    }
  
    public void randomMovePink(){
	int rand = (1 + (int)(Math.random() * (4)));
 		
		if(rand == 1){
		   moveUpPink();
		   lastDirectionPink = 1;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 2){
		  moveDownPink();
		  lastDirectionPink = 2;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 3){
		    moveRightPink();
		    lastDirectionPink = 3;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 4){
		    moveLeftPink();
		    lastDirectionPink = 4;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
	}
public void moveUpRed(){
	if(red.getY()- 1 >= 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() - 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	    meetRed();
	}
    }
    public void moveDownRed(){
	if(red.getY() + 1 <= 39){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() + 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	    meetRed();
	}
    }
    public void moveRightRed(){
	if(red.getX()+ 1 <= 39){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() + 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	    meetRed();
	}
    }
    public void moveLeftRed(){
	if(red.getX()- 1 >= 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() - 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	    meetRed();
	}
    }
  
    public void randomMoveRed(){
	int rand = (1 + (int)(Math.random() * (4)));
 		
		if(rand == 1){
		   moveUpRed();
		   lastDirectionRed = 1;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 2){
		  moveDownRed();
		  lastDirectionRed = 2;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 3){
		    moveRightRed();
		    lastDirectionRed = 3;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 4){
		    moveLeftRed();
		    lastDirectionRed = 4;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
    }
    public void meetPac(){
	if((pac.getY() == yellow.getY() && pac.getX() == yellow.getX()) || 
	   (pac.getY() == red.getY() && pac.getX() == red.getX()) || 
	   (pac.getY() == pink.getY() && pac.getX() == pink.getX()) || 
	   (pac.getY() == blue.getY() && pac.getX() == blue.getX()) 
	   ){
	    pac.setLives(pac.getLives() - 1);
	    System.out.println(pac.getLives());
	}
    }

    public void meetBlue(){
	if(blue.getY() == pac.getY()&& blue.getX() == pac.getX()){	   
	     pac.setLives(pac.getLives() - 1);
	     System.out.println(pac.getLives());
	}
    }
    public void meetRed(){
	if(red.getY() == pac.getY() && red.getX() == pac.getX()){	    
	     pac.setLives(pac.getLives() - 1);
	     System.out.println(pac.getLives());
	}
	
	
    }
    public void meetYellow(){
	if(yellow.getY() == pac.getY() && yellow.getX() == pac.getX()){	    
	     pac.setLives(pac.getLives() - 1);
	     System.out.println(pac.getLives());
	}
    }
    public void meetPink(){
	if(pink.getY() == pac.getY() && pink.getX() == pac.getX()){	   
	     pac.setLives(pac.getLives() - 1);
	     System.out.println(pac.getLives());

	}
    }

	    
    /*
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();

	
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    System.out.println(pac.getY());
	    
	    
 	}
	

	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	   
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
    */
    


    public void keyPressed(KeyEvent e){
	pressed = e.getKeyCode();
	System.out.println(pressed);
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
	pressed = 0;
    }
    
    public static void main(String[] args){
	Maze2 maze = new Maze2();
	maze.setVisible(true);

    }
}
    

