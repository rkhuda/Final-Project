import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Timer;

import java.util.*;

public class FinalMaze extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;

    private JLabel con;
    private JLabel pm;
    private JLabel bg;
    private JLabel yg;
    private JLabel pg;
    private JLabel rg;
    private JLabel pd;

    private ImageIcon R;
    private ImageIcon L;
    private ImageIcon U;
    private ImageIcon D;
    private ImageIcon Inky;
    private ImageIcon Clyde;
    private ImageIcon Pinky;
    private ImageIcon Blinky;
    private ImageIcon Pacdot;

    private Pacman pac;

    private Enemy blue;
    private Enemy yellow;
    private Enemy pink;
    private Enemy red;

    private Timer timerblue;
    private Timer t;
    private TimerTask tt;

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
    private int pressed;

    public FinalMaze(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(400, 100, 700, 700);
	this.setResizable(false);
	
	addKeyListener(this);
	pane = getContentPane();
       	
	Pacdot = new ImageIcon("Pacdot.png");
	Image imageDot = Pacdot.getImage();
	Image newimgDot = imageDot.getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH);
	Pacdot = new ImageIcon(newimgDot);

	R = new ImageIcon("PacmanRight.png");
	Image imageR = R.getImage(); // transform it
	Image newimgR = imageR.getScaledInstance(23, 23,  java.awt.Image.SCALE_SMOOTH);
	R = new ImageIcon(newimgR);  // transform it back
	pm = new JLabel();
	pac = new Pacman();

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

	Inky = new ImageIcon("Inky.png");
	Image imageI = Inky.getImage();
	Image newimgI = imageI.getScaledInstance(23, 23, java.awt.Image.SCALE_SMOOTH);
	Inky = new ImageIcon(newimgI);
	bg = new JLabel();
	blue = new Enemy(10, 12);

	Clyde = new ImageIcon("Clyde.png");
	Image image3 = Clyde.getImage(); // transform it
	Image newimg3 = image3.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Clyde = new ImageIcon(newimg3);  // transform it back
	yg = new JLabel();
        yellow = new Enemy(9, 12);
		
       	Pinky = new ImageIcon("Pinky.png");
	Image image4 = Pinky.getImage(); // transform it
	Image newimg4 = image4.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pinky = new ImageIcon(newimg4);  // transform it back
	pg = new JLabel();
        pink = new Enemy(10, 11);
		
	Blinky = new ImageIcon("Blinky.png");
	Image image5 = Blinky.getImage(); // transform it
	Image newimg5 = image5.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Blinky = new ImageIcon(newimg5);  // transform it back
	rg = new JLabel();
        red = new Enemy(10, 13);
	
	pane.setLayout(new GridLayout(25, 25));
	panels = new JPanel[25][25];
	
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {

		panels[x][y] = new JPanel(new FlowLayout());
		JPanel p = panels[x][y];
	       	Container c = getContentPane();
		JLabel b = new JLabel();

		b.setIcon(Pacdot);
		b.setBackground(Color.BLACK);
		b.setOpaque(true);

		if (x == pac.getY() && y == pac.getX()) {
		    pm.setIcon(R);
		    pm.setBackground(Color.BLACK);
		    p.add(pm);
		    b.setIcon(null);
		}
		if (x == blue.getY() && y == blue.getX()) {
		    bg.setIcon(Inky);
		    p.add(bg);
		}
		if (x == yellow.getY() && y == yellow.getX()) {
		    yg.setIcon(Clyde);
		    p.add(yg);
		}
		if (x == pink.getY() && y == pink.getX()) {
		    pg.setIcon(Pinky);
		    p.add(pg);
		}
		if (x == red.getY() && y == red.getX()) {
		    rg.setIcon(Blinky);
		    p.add(rg);
		}
		
	       	p.setBackground(Color.BLACK);
		pane.add(p);
		pane.add(b);
		
		if (x == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(27, 0, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (x == 24) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 27, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (y == 0 && (x != 0 && x != 24)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (y == 24 && (x != 0 && x != 24)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 28, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 2 || y == 22) && (x == 2 || x == 3 || x == 4 || x == 6 || x == 8 ||
			       x == 9 || x == 10 || x == 12 || x == 13 || x == 14 || x == 16 ||
			       x == 18 || x == 20 || x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		     b.setIcon(null);
		     b.setBackground(Color.BLUE);
		}
		if ((y == 3 || y == 21) && (x == 2 || x == 6 || x == 14 || x == 16 || x == 18 ||
					    x == 20 || x == 22)){
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 4 || y == 20) && (x == 2 || x == 4 || x == 6 || x == 8 || x == 9 ||
					    x == 10 || x == 11 || x == 12 || x == 14 ||
					    x == 18 || x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		     b.setIcon(null);
		     b.setBackground(Color.BLUE);
		}
		if ((y == 5 || y == 19) && (x == 4 || x == 12 || x == 16 || x == 17 || x == 18 ||
					    x == 20 || x == 21 || x == 22)){
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 6 || y == 18) && (x == 2 || x == 3|| x == 4 || x == 6 || x == 7||
					    x == 9 || x == 10 || x == 11 || x == 12 || x == 13 ||
					    x == 14)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		     b.setIcon(null);
		     b.setBackground(Color.BLUE);
		}
		if ((y == 7 || y == 17) && (x == 7 || x == 12 || x == 16 || x == 17 || x == 18 ||
					    x == 20 || x == 21 || x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 8 || y == 16) && (x == 2 || x == 3|| x == 4 || x == 5|| x == 7 ||
					    x == 9 || x == 10 || x == 12 || x == 13 ||
					    x == 22)) {
		     p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		     b.setIcon(null);
		     b.setBackground(Color.BLUE);
		}
		if ((y == 9 || y == 15) && (x == 2 || x == 7 || x == 16 || x == 17 || x == 18 ||
					    x == 19 || x == 20 || x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 10 || y == 14) && (x == 2 || x == 4 || x == 5 || x == 13  ||
					     x == 22)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if ((y == 11 || y == 13) && (x == 7 || x == 13 || x == 15 || x == 16 ||
					     x == 18 || x == 20)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (y == 12 && (x == 1 || x == 2 || x == 4 || x == 5 || x == 6 || x == 7 ||
				x == 13 || x == 14 || x == 15 || x == 16 || x == 18 || x == 20 ||
				x == 22 || x == 23)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		
		//make center box
		if ((x == 9 || x == 11) && (y == 10 || y == 11 ||  y == 13 ||
					    y == 14)) {
		    p.setBorder(BorderFactory.createMatteBorder(28, 0, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (x == 10 && (y == 10 || y == 14)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (x == 11 && y == 12) {
		     p.setBorder(BorderFactory.createMatteBorder(28, 0, 0, 0, Color.BLUE));
		     b.setIcon(null);
		     b.setBackground(Color.BLUE);
		}
		
	    }
	}

	ActionListener BlueGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if (lastDirectionBlue == 0)
			randomMoveBlue();
		    else{
	
	
			if (lastDirectionBlue == 1)
			    {
				if (upCounter !=0 &&
				    (panels[blue.getY() - 1][blue.getX()].getBorder() == null))
				    {
					moveUpBlue();
					upCounter--;
				    }else
				    randomMoveBlue();			

			    }
			if (lastDirectionBlue == 2)
			    {
				if (downCounter !=0 &&
				    (panels[blue.getY() + 1][blue.getX()].getBorder() == null))
				    {
					moveDownBlue();
					downCounter--;
				    }else
				    randomMoveBlue();			

			    }
			if (lastDirectionBlue == 3)
			    {
				if (rightCounter !=0 &&
				    (panels[blue.getY()][blue.getX() + 1].getBorder() == null))
				    {
					moveRightBlue();
					rightCounter--;
				    }else
				    randomMoveBlue();			

			    }
		    
			if (lastDirectionBlue == 4)
			    {
				if (leftCounter !=0 &&
				    (panels[blue.getY()][blue.getX() - 1].getBorder() == null))
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
				if (upCounter !=0 &&
				    (panels[yellow.getY() - 1][yellow.getX()].getBorder() == null))
				    {
					moveUpYellow();
					upCounter--;
				    }else
				    randomMoveYellow();			

			    }
			if (lastDirectionYellow == 4)
			    {
				if (downCounter !=0 &&
				    (panels[yellow.getY() + 1][yellow.getX()].getBorder() == null))
				    {
					moveDownYellow();
					downCounter--;
				    }else
				    randomMoveYellow();			

			    }
			if (lastDirectionYellow == 5)
			    {
				if (rightCounter !=0 &&
				    (panels[yellow.getY()][yellow.getX() + 1].getBorder() == null))
				    {
					moveRightYellow();
					rightCounter--;
				    }else
				    randomMoveYellow();			

			    }
		    
			if (lastDirectionYellow == 6)
			    {
				if (leftCounter !=0 &&
				    (panels[yellow.getY()][yellow.getX() - 1].getBorder() == null))
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
				if (upCounter !=0 &&
				    (panels[pink.getY() - 1][pink.getX()].getBorder() == null))
				    {
					moveUpPink();
					upCounter--;
				    }else
				    randomMovePink();			

			    }
			if (lastDirectionPink == 2)
			    {
				if (downCounter !=0 &&
				    (panels[pink.getY() + 1][pink.getX()].getBorder() == null))
				    {
					moveDownPink();
					downCounter--;
				    }else
				    randomMovePink();			

			    }
			if (lastDirectionPink == 3)
			    {
				if (rightCounter !=0 &&
				    (panels[pink.getY()][pink.getX() + 1].getBorder() == null))
				    {
					moveRightPink();
					rightCounter--;
				    }else
				    randomMovePink();			

			    }
		    
			if (lastDirectionPink == 4)
			    {
				if (leftCounter !=0 &&
				    (panels[pink.getY()][pink.getX() - 1].getBorder() == null))
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
				if (upCounter !=0 &&
				    (panels[red.getY() - 1][red.getX()].getBorder() == null))
				    {
					moveUpRed();
					upCounter--;
				    }else
				    randomMoveRed();			

			    }
			if (lastDirectionRed == 2)
			    {
				if (downCounter !=0 &&
				    (panels[red.getY() + 1][red.getX()].getBorder() == null))
				    {
					moveDownRed();
					downCounter--;
				    }else
				    randomMoveRed();			

			    }
			if (lastDirectionRed == 3)
			    {
				if (rightCounter !=0 &&
				    (panels[red.getY()][red.getX() + 1].getBorder() == null))
				    {
					moveRightRed();
					rightCounter--;
				    }else
				    randomMoveRed();			

			    }
		    
			if (lastDirectionRed == 4)
			    {
				if (leftCounter !=0 &&
				    (panels[red.getY()][red.getX() - 1].getBorder() == null))
				    {
					moveLeftRed();
					leftCounter--;
				    }else
				    randomMoveRed();			

			    }
		    


	
		    }
		}
	    };
        Timer timerRed = new Timer(200, RedGhost);
        timerRed.setRepeats(true);
        timerRed.start();
	/*
	new Timer(1000,new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
		    if(pressed == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
			pm.setIcon(null);
			panels[pac.getY()][pac.getX()].repaint();
			pac.setY(pac.getY() - 1);
			panels[pac.getY()][pac.getX()].add(pm);
			pm.setIcon(R);
			System.out.println(pac.getY());
		    }
		}
	    }).start();
	*/

    }

    public void moveUpBlue(){
	if(blue.getY()- 1 > 0) {
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveDownBlue(){
	if(blue.getY() + 1 < 24){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveRightBlue(){
	if(blue.getX()+ 1 < 24){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
	}
    }
    public void moveLeftBlue(){
	if (blue.getX() - 1 > 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(Inky);
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
	if(yellow.getY()- 1 > 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	}
    }
    public void moveDownYellow(){
	if(yellow.getY() + 1 < 24){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	}
    }
    public void moveRightYellow(){
	if(yellow.getX()+ 1 < 24){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	}
    }
    public void moveLeftYellow(){
	if(yellow.getX()- 1 > 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
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
	if(pink.getY()- 1 > 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	}
    }
    public void moveDownPink(){
	if(pink.getY() + 1 < 24){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	}
    }
    public void moveRightPink(){
	if(pink.getX()+ 1 < 24){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
	}
    }
    public void moveLeftPink(){
	if(pink.getX()- 1 > 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(Pinky);
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
	if(red.getY()- 1 > 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() - 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	}
    }
    public void moveDownRed(){
	if(red.getY() + 1 < 24){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setY(red.getY() + 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	}
    }
    public void moveRightRed(){
	if(red.getX()+ 1 < 24){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() + 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
	}
    }
    public void moveLeftRed(){
	if(red.getX()- 1 > 0){
	    rg.setIcon(null);
	    panels[red.getY()][red.getX()].repaint();
	    red.setX(red.getX() - 1);
	    panels[red.getY()][red.getX()].add(rg);
	    rg.setIcon(Blinky);
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

    
    public void keyPressed(KeyEvent e){

	int c = e.getKeyCode();
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 > 0 &&
	   (panels[pac.getY() - 1][pac.getX()].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(U);
 	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 < 24 &&
	   (panels[pac.getY() + 1][pac.getX()].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(D);
	}
	
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 < 24 &&
	   (panels[pac.getY()][pac.getX() + 1].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(R);
	}
	
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 > 0 &&
	   (panels[pac.getY()][pac.getX() - 1].getBorder() == null)){
       	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(L);
	}
    }
    
    public void keyReleased(KeyEvent e){
	//pressed = 0;
    }
    public void keyTyped(KeyEvent e){}
    
    public static void main(String[] args){
	FinalMaze maze = new FinalMaze();
	maze.setVisible(true);
    }
}
