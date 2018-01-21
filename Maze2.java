
			
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
    private ImageIcon scaredGhost;
    private Pacman pac;
    private Enemy blue;
    private Enemy yellow;
    private Enemy pink;
    private Enemy red;
    private JLabel con;
    private Timer timerBlue;
    private Timer timerRed;
    private Timer timerYellow;
    private Timer timerPink;
    private Timer timerPower;
    private JLabel pm;
    private JLabel bg;
    private JLabel yg;
    private JLabel pg;
    private JLabel rg;
    private JLabel sg;
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
    private boolean isPower = false;
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
		       	
	scaredGhost = new ImageIcon("scaredGhost.png");
	Image image6 = scaredGhost.getImage(); // transform it
	Image newimg6 = image6.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	scaredGhost = new ImageIcon(newimg6);  // transform it back
	sg = new JLabel();
       
	
	 
	   
	
	pane.setLayout(new GridLayout(40 ,40 ));
	panels = new JPanel[40 ][40];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		
		JPanel p = panels[x][y];
	      	Container c = getContentPane();			    
	 	if (x == pac.getY() && y == pac.getX()) {
      		    pm.setIcon(Pacman);
		    //  p.setBackground(Color.BLACK);
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
        timerBlue = new Timer(200, BlueGhost);
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
        timerYellow = new Timer(200, YellowGhost);
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
        timerPink = new Timer(200, PinkGhost);
        timerPink.setRepeats(true);
        timerPink.start();
	
ActionListener RedGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if(isPower){
			if (lastDirectionRed == 0){
			    randomMoveRed(scaredGhost);
			    }

		    else{
	
	
			if (lastDirectionRed == 1)
			    {
				if (upCounter !=0)
				    {
					moveUpRed(scaredGhost);
					upCounter--;
				    }else
				    randomMoveRed(scaredGhost);			

			    }
			if (lastDirectionRed == 2)
			    {
				if (downCounter !=0)
				    {
					moveDownRed(scaredGhost);
					downCounter--;
				    }else
				    randomMoveRed(scaredGhost);			

			    }
			if (lastDirectionRed == 3)
			    {
				if (rightCounter !=0)
				    {
					moveRightRed(scaredGhost);
					rightCounter--;
				    }else
				    randomMoveRed(scaredGhost);			

			    }
		    
			if (lastDirectionRed == 4)
			    {
				if (leftCounter !=0)
				    {
					moveLeftRed(scaredGhost);
					leftCounter--;
				    }else
				    randomMoveRed(scaredGhost);			

			    }
		    


	
		    }
		    }
		    else{
	if (lastDirectionRed == 0){
	    randomMoveRed(Blinky);
			    }

		    else{
	
	
			if (lastDirectionRed == 1)
			    {
				if (upCounter !=0)
				    {
					moveUpRed(Blinky);
					upCounter--;
				    }else
				    randomMoveRed(Blinky);			

			    }
			if (lastDirectionRed == 2)
			    {
				if (downCounter !=0)
				    {
					moveDownRed(Blinky);
					downCounter--;
				    }else
				    randomMoveRed(Blinky);			

			    }
			if (lastDirectionRed == 3)
			    {
				if (rightCounter !=0)
				    {
					moveRightRed(Blinky);
					rightCounter--;
				    }else
				    randomMoveRed(Blinky);			

			    }
		    
			if (lastDirectionRed == 4)
			    {
				if (leftCounter !=0)
				    {
					moveLeftRed(Blinky);
					leftCounter--;
				    }else
				    randomMoveRed(Blinky);			

			    }
		    }
		    }
		    
		}
	    };
        timerRed = new Timer(100, RedGhost);
        timerRed.setRepeats(true);
        timerRed.start();
	
	ActionListener invincible = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    isPower = false;
		}
	    };
	timerPower = new Timer(7000,invincible);
	timerPower.setRepeats(false);
	/*
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
	*/
       
    
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
public void moveUpRed(ImageIcon image){
	if(red.getY()- 1 >= 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() - 1);
	    
	    rg.setIcon(image);
	    panels[red.getY()][red.getX()].setBackground(Color.BLACK);
	    panels[red.getY()][red.getX()].add(rg);
	    meetRed();
	}
    }
    public void moveDownRed(ImageIcon image){
	if(red.getY() + 1 <= 39){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() + 1);
	   
	    rg.setIcon(image);
	     panels[red.getY()][red.getX()].setBackground(Color.BLACK);
	     panels[red.getY()][red.getX()].add(rg);
	    meetRed();
	}
    }
    public void moveRightRed(ImageIcon image){
	if(red.getX()+ 1 <= 39){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() + 1);
	   
	    rg.setIcon(image);
	     panels[red.getY()][red.getX()].setBackground(Color.BLACK);
	     panels[red.getY()][red.getX()].add(rg);
	    meetRed();
	}
    }
    public void moveLeftRed(ImageIcon image){
	if(red.getX()- 1 >= 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() - 1);
	    
	    rg.setIcon(image);
	    panels[red.getY()][red.getX()].setBackground(Color.BLACK);
	    panels[red.getY()][red.getX()].add(rg);
	    meetRed();
	}
    }
  
    public void randomMoveRed(ImageIcon image){
	int rand = (1 + (int)(Math.random() * (4)));
 		
		if(rand == 1){
		   moveUpRed(image);
		   lastDirectionRed = 1;
		   upCounter = (1 + (int)(Math.random() * (7)));
		   	}
		if(rand == 2){
		  moveDownRed(image);
		  lastDirectionRed = 2;
		   downCounter = (1 + (int)(Math.random() * (7)));
		  
		 }
		if(rand == 3){
		    moveRightRed(image);
		    lastDirectionRed = 3;
		   rightCounter = (1 + (int)(Math.random() * (7)));
		}
		if(rand == 4){
		    moveLeftRed(image);
		    lastDirectionRed = 4;
		   leftCounter = (1 + (int)(Math.random() * (7)));
		}
    }
    public void meetPac(){
	if(isPower == false){
	if((pac.getY() == yellow.getY() && pac.getX() == yellow.getX()) || 
	   (pac.getY() == red.getY() && pac.getX() == red.getX()) || 
	   (pac.getY() == pink.getY() && pac.getX() == pink.getX()) || 
	   (pac.getY() == blue.getY() && pac.getX() == blue.getX()) 
	   ){
	    pac.setLives(pac.getLives() - 1);
	  	   	   
	    if(pac.getLives() > 0){
		meetLives();
	    }	  
	    if(pac.getLives() == 0){
		     meetNoLives();
	     }
	}
	}
	if(isPower){
	    if(pac.getY() == yellow.getY() && pac.getX() == yellow.getX()){
		yellowRespawn();
	    } 
	    if(pac.getY() == red.getY() && pac.getX() == red.getX()){
		redRespawn();
	    }	    
	    if(pac.getY() == pink.getY() && pac.getX() == pink.getX()){
		pinkRespawn();
	    }
	    if(pac.getY() == blue.getY() && pac.getX() == blue.getX()){
		blueRespawn();
	    }
	   
	}
    }

    public void meetBlue(){
	if(isPower == false){
	if(blue.getY() == pac.getY()&& blue.getX() == pac.getX()){	   
	     pac.setLives(pac.getLives() - 1);
	     if(pac.getLives() > 0){
		 meetLives();
	     }
	     if(pac.getLives() == 0){
		     meetNoLives();
	     }
	}
	}
	if(isPower){
	    if(blue.getY() == pac.getY() && blue.getX() == pac.getX()){
		blueRespawn();

    }
	}
    }    
    public void meetRed(){
	if(isPower == false){
	if(red.getY() == pac.getY() && red.getX() == pac.getX()){	    
	     pac.setLives(pac.getLives() - 1);
	     if(pac.getLives() > 0){
		 meetLives();
	     
	}	
	       if(pac.getLives() == 0){
		     meetNoLives();
	     }
	}
	}
	if(isPower){
	    if(red.getY() == pac.getY() && red.getX() == pac.getX()){
		redRespawn();
	    }
	}
    }
    public void meetYellow(){
	if(isPower == false){
	if(yellow.getY() == pac.getY() && yellow.getX() == pac.getX()){	    
	     pac.setLives(pac.getLives() - 1);
	     if(pac.getLives() > 0){
		 meetLives();
	}
	       if(pac.getLives() == 0){
		     meetNoLives();
	     }
    }
	}
	if(isPower){
	    if(yellow.getY() == pac.getY() && yellow.getX() == pac.getX()){
		yellowRespawn();
	    }

    }
    }
    public void meetPink(){
	if(isPower == false){
	if(pink.getY() == pac.getY() && pink.getX() == pac.getX()){	   
	     pac.setLives(pac.getLives() - 1);
	     if(pac.getLives() > 0){
		 meetLives();
	    	}
	       if(pac.getLives() == 0){
		     meetNoLives();
	     }
	}
	}
        if(isPower){
	    if(pink.getY() == pac.getY() && pink.getX() == pac.getX()){
		pinkRespawn();
	    }
	}
    }

    public void meetNoLives(){
	int choice = JOptionPane.showConfirmDialog(null, "You are out of lives! Do you want to restart?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.NO_OPTION) {
                System.exit(0);
        } 
            else if (choice == JOptionPane.YES_OPTION) {
		( new Maze2()).setVisible(true) ;
		
        } 
            else if (choice == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
        }
    }

    public void meetLives(){
	
	    timerBlue.stop();
	    timerRed.stop();
	    timerYellow.stop();
	    timerPink.stop();	    	   	   
	    pacRespawn();
	    blueRespawn();
	    yellowRespawn();
	    pinkRespawn();
	    redRespawn();
	    JOptionPane.showMessageDialog(null,"You Have" + " " + Integer.toString(pac.getLives()) + " " + "Lives Remaining!");
	    timerBlue.start();
	    timerRed.start();
	    timerYellow.start();
	    timerPink.start();
	
	
	    
    }
	
    public void pacRespawn(){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(20);
	    pac.setY(20);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
    }

    public void blueRespawn(){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(10);
	    blue.setY(5);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
    }
    public void yellowRespawn(){
            yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(9);
	    yellow.setY(5);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
    }

    public void redRespawn(){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(9);
	    red.setY(4);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
    }
    
    public void pinkRespawn(){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(10);
	    pink.setY(4);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
    }
    
    public void power(){
       	isPower = true;

    }
	
	
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    //  System.out.println(pac.getY());
	    meetPac();
	      power();
	      timerPower.start();
 	}
	
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	   
	    pm.setIcon(Pacman);
	    // System.out.println(pac.getY());
	    meetPac();
	    //  power();
	}
	
	
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    //  System.out.println(pac.getX());
	    meetPac();
	}
	
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 >= 0){
       	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(Pacman);
	    // System.out.println(pac.getX());
	    meetPac();
	}
	
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
