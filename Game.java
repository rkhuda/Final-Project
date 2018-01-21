import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Timer;

import java.util.*;

public class Game extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private JLabel con, pm, bg, yg, pg, rg, pd, b, score;
    private ImageIcon R, L, U, D, Inky, Clyde, Pinky, Blinky, Pacdot, scaredGhost,Pellet;  
    private Pacman pac;
    private Enemy blue, yellow, pink , red;
    private Timer timerBlue, timerYellow, timerRed, timerPower, timerPink;
    private int upCounter, downCounter, rightCounter, leftCounter;
    private int lastDirectionBlue, lastDirectionYellow, lastDirectionPink,lastDirectionRed;
    private int scoreCounter;
    private boolean isPower = false;

    public Game(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(400, 100, 700, 700);
       	this.setResizable(false);
	
	
	addKeyListener(this);
	pane = getContentPane();

	score = new JLabel();
	
	Pellet = new ImageIcon("Pacdot.png");
	Image imagePower = Pellet.getImage();
	Image newimgPower = imagePower.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
	Pellet = new ImageIcon(newimgPower);
       	
	Pacdot = new ImageIcon("Pacdot.png");
	Image imageDot = Pacdot.getImage();
	Image newimgDot = imageDot.getScaledInstance(4, 4, java.awt.Image.SCALE_SMOOTH);
	Pacdot = new ImageIcon(newimgDot);


	R = new ImageIcon("PacmanRight.png");
	Image imageR = R.getImage(); // transform it
	Image newimgR = imageR.getScaledInstance(18, 18,  java.awt.Image.SCALE_SMOOTH);
	R = new ImageIcon(newimgR);  // transform it back
	pm = new JLabel();
	pac = new Pacman();

        L = new ImageIcon("PacmanLeft.png");
	Image imageL = L.getImage(); // transform it
	Image newimgL = imageL.getScaledInstance(18,18,  java.awt.Image.SCALE_SMOOTH);
	L = new ImageIcon(newimgL);  // transform it back

        D = new ImageIcon("PacmanDown.png");
	Image imageD = D.getImage(); // transform it
	Image newimgD = imageD.getScaledInstance(18,18,  java.awt.Image.SCALE_SMOOTH);
	D = new ImageIcon(newimgD);  // transform it back

        U = new ImageIcon("PacmanUp.png");
	Image imageU = U.getImage(); // transform it
	Image newimgU = imageU.getScaledInstance(18,18,  java.awt.Image.SCALE_SMOOTH);
	U = new ImageIcon(newimgU);  // transform it back

	Inky = new ImageIcon("Inky.png");
	Image imageI = Inky.getImage();
	Image newimgI = imageI.getScaledInstance(13, 13, java.awt.Image.SCALE_SMOOTH);
	Inky = new ImageIcon(newimgI);
	bg = new JLabel();
	blue = new Enemy(10, 12);

	Clyde = new ImageIcon("Clyde.png");
	Image image3 = Clyde.getImage(); // transform it
	Image newimg3 = image3.getScaledInstance(13,13,  java.awt.Image.SCALE_SMOOTH);
	Clyde = new ImageIcon(newimg3);  // transform it back
	yg = new JLabel();
        yellow = new Enemy(9, 12);
		
       	Pinky = new ImageIcon("Pinky.png");
	Image image4 = Pinky.getImage(); // transform it
	Image newimg4 = image4.getScaledInstance(13,13,  java.awt.Image.SCALE_SMOOTH);
	Pinky = new ImageIcon(newimg4);  // transform it back
	pg = new JLabel();
        pink = new Enemy(10, 11);
		
	Blinky = new ImageIcon("Blinky.png");
	Image image5 = Blinky.getImage(); // transform it
	Image newimg5 = image5.getScaledInstance(13,13,  java.awt.Image.SCALE_SMOOTH);
	Blinky = new ImageIcon(newimg5);  // transform it back
	rg = new JLabel();
        red = new Enemy(10, 13);
	
        scaredGhost = new ImageIcon("scaredGhost.png");
	Image image6 = scaredGhost.getImage(); // transform it
	Image newimg6 = image6.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	scaredGhost = new ImageIcon(newimg6);  // transform it back



	pane.setLayout(new GridLayout(26, 25));
	panels = new JPanel[26][25];
	
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {

		panels[x][y] = new JPanel(new FlowLayout());
		JPanel p = panels[x][y];
	       	Container c = getContentPane();
		JLabel b = new JLabel();
		JLabel power = new JLabel();
	
		if((x != pac.getY() || y != pac.getX()) && (x != 23 || y != 23) && (x != 1 || y != 23)
		   && (x != 23 || y != 1)  && ( x != 1 || y != 1)){
		    b.setIcon(Pacdot);
		    p.setBackground(Color.BLACK);
		    p.add(b);
		   
		}
		
		if((x == 23  && y == 1) || (x == 1 && y == 23) || ( x == 23 && y == 23) || ( x == 1 && y == 1)){
		    power.setIcon(Pellet);
		    p.setBackground(Color.BLACK);
		    p.add(power);
		}
	        if (x == pac.getY() && y == pac.getX()) {
		    pm.setIcon(R);
		    p.setBackground(Color.BLACK);
		    p.add(pm);
		   
		}
	       	if (x == blue.getY() && y == blue.getX())  {
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
		if (y == 0 && (x != 0 && x != 24 && x != 25)) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 28, 0, 0, Color.BLUE));
		    b.setIcon(null);
		    b.setBackground(Color.BLUE);
		}
		if (y == 24 && (x != 0 && x != 24 && x != 25)) {
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
		if (x == 25) {
		    b.setIcon(null);
		    if (y == 10){
			b.setText("     S");
			b.setForeground(Color.RED);
		    }
		    if (y == 11) {
			b.setText("core");
			b.setForeground(Color.RED);
		    }
		    if (y == 12) {
			score.setText("" + scoreCounter);
			score.setForeground(Color.RED);
			p.add(score);
		    }
		}
		
		//make center box
		if ((x == 9 || x == 11) && (y == 10 || y == 11 ||  y == 12 || y == 13 ||
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
		if (x == 10 && (y == 11 || y == 12 || y == 13)) {
		    b.setIcon(null);
		}
		
	    }
	}
	ActionListener BlueGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if(isPower == false){
			if (lastDirectionBlue == 0)
			    randomMoveBlue(Inky);
			else{
	
	
			    if (lastDirectionBlue == 1)
				{
				    if (upCounter !=0 &&
					(panels[blue.getY() - 1][blue.getX()].getBorder() == null))
					{
					    moveUpBlue(Inky);
					    upCounter--;
					}else
					randomMoveBlue(Inky);			

				}
			    if (lastDirectionBlue == 2)
				{
				    if (downCounter !=0 &&
					(panels[blue.getY() + 1][blue.getX()].getBorder() == null))
					{
					    moveDownBlue(Inky);
					    downCounter--;
					}else
					randomMoveBlue(Inky);			

				}
			    if (lastDirectionBlue == 3)
				{
				    if (rightCounter !=0 &&
					(panels[blue.getY()][blue.getX() + 1].getBorder() == null))
					{
					    moveRightBlue(Inky);
					    rightCounter--;
					}else
					randomMoveBlue(Inky);			

				}
		    
			    if (lastDirectionBlue == 4)
				{
				    if (leftCounter !=0 &&
					(panels[blue.getY()][blue.getX() - 1].getBorder() == null))
					{
					    moveLeftBlue(Inky);
					    leftCounter--;
					}else
					randomMoveBlue(Inky);			

				}
		    


	
			}
		    }
		    if(isPower){
			if (lastDirectionBlue == 0)
			    randomMoveBlue(scaredGhost);
			else{
	
	
			    if (lastDirectionBlue == 1)
				{
				    if (upCounter !=0 &&
					(panels[blue.getY() - 1][blue.getX()].getBorder() == null))
					{
					    moveUpBlue(scaredGhost);
					    upCounter--;
					}else
					randomMoveBlue(scaredGhost);			

				}
			    if (lastDirectionBlue == 2)
				{
				    if (downCounter !=0 &&
					(panels[blue.getY() + 1][blue.getX()].getBorder() == null))
					{
					    moveDownBlue(scaredGhost);
					    downCounter--;
					}else
					randomMoveBlue(scaredGhost);			

				}
			    if (lastDirectionBlue == 3)
				{
				    if (rightCounter !=0 &&
					(panels[blue.getY()][blue.getX() + 1].getBorder() == null))
					{
					    moveRightBlue(scaredGhost);
					    rightCounter--;
					}else
					randomMoveBlue(scaredGhost);			

				}
		    
			    if (lastDirectionBlue == 4)
				{
				    if (leftCounter !=0 &&
					(panels[blue.getY()][blue.getX() - 1].getBorder() == null))
					{
					    moveLeftBlue(scaredGhost);
					    leftCounter--;
					}else
					randomMoveBlue(scaredGhost);			

				}
		    


	
			}
		    }
		}

			
	    };
        timerBlue = new Timer(200, BlueGhost);
        timerBlue.setRepeats(true);
        timerBlue.start();
	
	ActionListener YellowGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if(isPower == false){
			if (lastDirectionYellow == 0)
			    randomMoveYellow(Clyde);
			else{
	
	
			    if (lastDirectionYellow == 3)
				{
				    if (upCounter !=0 &&
					(panels[yellow.getY() - 1][yellow.getX()].getBorder() == null))
					{
					    moveUpYellow(Clyde);
					    upCounter--;
					}else
					randomMoveYellow(Clyde);			

				}
			    if (lastDirectionYellow == 4)
				{
				    if (downCounter !=0 &&
					(panels[yellow.getY() + 1][yellow.getX()].getBorder() == null))
					{
					    moveDownYellow(Clyde);
					    downCounter--;
					}else
					randomMoveYellow(Clyde);			

				}
			    if (lastDirectionYellow == 5)
				{
				    if (rightCounter !=0 &&
					(panels[yellow.getY()][yellow.getX() + 1].getBorder() == null))
					{
					    moveRightYellow(Clyde);
					    rightCounter--;
					}else
					randomMoveYellow(Clyde);			

				}
		    
			    if (lastDirectionYellow == 6)
				{
				    if (leftCounter !=0 &&
					(panels[yellow.getY()][yellow.getX() - 1].getBorder() == null))
					{
					    moveLeftYellow(Clyde);
					    leftCounter--;
					}else
					randomMoveYellow(Clyde);			

				}
		    


	
			}
		    }
		    if(isPower){
			if (lastDirectionYellow == 0)
			    randomMoveYellow(scaredGhost);
			else{
	
	
			    if (lastDirectionYellow == 3)
				{
				    if (upCounter !=0 &&
					(panels[yellow.getY() - 1][yellow.getX()].getBorder() == null))
					{
					    moveUpYellow(scaredGhost);
					    upCounter--;
					}else
					randomMoveYellow(scaredGhost);			

				}
			    if (lastDirectionYellow == 4)
				{
				    if (downCounter !=0 &&
					(panels[yellow.getY() + 1][yellow.getX()].getBorder() == null))
					{
					    moveDownYellow(scaredGhost);
					    downCounter--;
					}else
					randomMoveYellow(scaredGhost);			

				}
			    if (lastDirectionYellow == 5)
				{
				    if (rightCounter !=0 &&
					(panels[yellow.getY()][yellow.getX() + 1].getBorder() == null))
					{
					    moveRightYellow(scaredGhost);
					    rightCounter--;
					}else
					randomMoveYellow(scaredGhost);	

				}
		    
			    if (lastDirectionYellow == 6)
				{
				    if (leftCounter !=0 &&
					(panels[yellow.getY()][yellow.getX() - 1].getBorder() == null))
					{
					    moveLeftYellow(scaredGhost);
					    leftCounter--;
					}else
					randomMoveYellow(scaredGhost);			

				}
		    


	
			}
		    }
		}
		
	    };
        timerYellow = new Timer(200, YellowGhost);
        timerYellow.setRepeats(true);
        timerYellow.start();
	
	ActionListener PinkGhost = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    if(isPower == false){
			if (lastDirectionPink == 0)
			    randomMovePink(Pinky);
			else{
	
	
			    if (lastDirectionPink == 1)
				{
				    if (upCounter !=0 &&
					(panels[pink.getY() - 1][pink.getX()].getBorder() == null))
					{
					    moveUpPink(Pinky);
					    upCounter--;
					}else
					randomMovePink(Pinky);			

				}
			    if (lastDirectionPink == 2)
				{
				    if (downCounter !=0 &&
					(panels[pink.getY() + 1][pink.getX()].getBorder() == null))
					{
					    moveDownPink(Pinky);
					    downCounter--;
					}else
					randomMovePink(Pinky);			

				}
			    if (lastDirectionPink == 3)
				{
				    if (rightCounter !=0 &&
					(panels[pink.getY()][pink.getX() + 1].getBorder() == null))
					{
					    moveRightPink(Pinky);
					    rightCounter--;
					}else
					randomMovePink(Pinky);			

				}
		    
			    if (lastDirectionPink == 4)
				{
				    if (leftCounter !=0 &&
					(panels[pink.getY()][pink.getX() - 1].getBorder() == null))
					{
					    moveLeftPink(Pinky);
					    leftCounter--;
					}else
					randomMovePink(Pinky);			

				}
		    


	
			}
		    }
		    if(isPower){
			if (lastDirectionPink == 0)
			    randomMovePink(scaredGhost);
			else{
	
	
			    if (lastDirectionPink == 1)
				{
				    if (upCounter !=0 &&
					(panels[pink.getY() - 1][pink.getX()].getBorder() == null))
					{
					    moveUpPink(scaredGhost);
					    upCounter--;
					}else
					randomMovePink(scaredGhost);			

				}
			    if (lastDirectionPink == 2)
				{
				    if (downCounter !=0 &&
					(panels[pink.getY() + 1][pink.getX()].getBorder() == null))
					{
					    moveDownPink(scaredGhost);
					    downCounter--;
					}else
					randomMovePink(scaredGhost);			

				}
			    if (lastDirectionPink == 3)
				{
				    if (rightCounter !=0 &&
					(panels[pink.getY()][pink.getX() + 1].getBorder() == null))
					{
					    moveRightPink(scaredGhost);
					    rightCounter--;
					}else
					randomMovePink(scaredGhost);			

				}
		    
			    if (lastDirectionPink == 4)
				{
				    if (leftCounter !=0 &&
					(panels[pink.getY()][pink.getX() - 1].getBorder() == null))
					{
					    moveLeftPink(scaredGhost);
					    leftCounter--;
					}else
					randomMovePink(scaredGhost);			

				}
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
				    if (upCounter !=0 &&
					(panels[red.getY() - 1][red.getX()].getBorder() == null))
					{
					    moveUpRed(scaredGhost);
					    upCounter--;
					}else
					randomMoveRed(scaredGhost);			

				}
			    if (lastDirectionRed == 2)
				{
				    if (downCounter !=0 &&
					(panels[red.getY() + 1][red.getX()].getBorder() == null))
					{
					    moveDownRed(scaredGhost);
					    downCounter--;
					}else
					randomMoveRed(scaredGhost);			

				}
			    if (lastDirectionRed == 3)
				{
				    if (rightCounter !=0 &&
					(panels[red.getY()][red.getX() + 1].getBorder() == null))
					{
					    moveRightRed(scaredGhost);
					    rightCounter--;
					}else
					randomMoveRed(scaredGhost);			

				}
		    
			    if (lastDirectionRed == 4)
				{
				    if (leftCounter !=0 &&
					(panels[red.getY()][red.getX() - 1].getBorder() == null))
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
				    if (upCounter !=0 &&
					(panels[red.getY() - 1][red.getX()].getBorder() == null))
					{
					    moveUpRed(Blinky);
					    upCounter--;
					}else
					randomMoveRed(Blinky);			

				}
			    if (lastDirectionRed == 2)
				{
				    if (downCounter !=0 &&
					(panels[red.getY() + 1][red.getX()].getBorder() == null))
					{
					    moveDownRed(Blinky);
					    downCounter--;
					}else
					randomMoveRed(Blinky);			

				}
			    if (lastDirectionRed == 3)
				{
				    if (rightCounter !=0 &&
					(panels[red.getY()][red.getX() + 1].getBorder() == null))
					{
					    moveRightRed(Blinky);
					    rightCounter--;
					}else
					randomMoveRed(Blinky);			

				}
		    
			    if (lastDirectionRed == 4)
				{
				    if (leftCounter !=0 &&
					(panels[red.getY()][red.getX() - 1].getBorder() == null))
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
        timerRed = new Timer(200, RedGhost);
        timerRed.setRepeats(true);
        timerRed.start();
	
	ActionListener invincible = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		    isPower = false;
		}
	    };
	timerPower = new Timer(7000,invincible);
	timerPower.setRepeats(false);


    }

    public void moveUpBlue(ImageIcon image){
	if(blue.getY()- 1 > 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(image);
	    meetBlue();
	}
    }
    public void moveDownBlue(ImageIcon image){
	if(blue.getY() + 1 < 24){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setY(blue.getY() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(image);
	    meetBlue();
	}
    }
    public void moveRightBlue(ImageIcon image){
	if(blue.getX()+ 1 < 24){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() + 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(image);
	    meetBlue();
	}
    }
    public void moveLeftBlue(ImageIcon image){
	if(blue.getX()- 1 > 0){
	    bg.setIcon(null);
	    panels[blue.getY()][blue.getX()].repaint();
	    blue.setX(blue.getX() - 1);
	    panels[blue.getY()][blue.getX()].add(bg);
	    bg.setIcon(image);
	    meetBlue();
	}
    }
  
    public void randomMoveBlue(ImageIcon image){
	int rand = (1 + (int)(Math.random() * (4)));
 		
	if(rand == 1){
	    if(panels[blue.getY() - 1][blue.getX()].getBorder() == null){
		moveUpBlue(image);
		lastDirectionBlue = 1;
		upCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 2){
	    if(panels[blue.getY() + 1][blue.getX()].getBorder() == null){
		moveDownBlue(image);
		lastDirectionBlue = 2;
		downCounter = (1 + (int)(Math.random() * (7)));
		  
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 3){
	    if(panels[blue.getY()][blue.getX() + 1].getBorder() == null){
		moveRightBlue(image);
		lastDirectionBlue = 3;
		rightCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 4){
	    if(panels[blue.getY()][blue.getX() - 1].getBorder() == null){
		moveLeftBlue(image);
		lastDirectionBlue = 4;
		leftCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
    }







    public void moveUpYellow(ImageIcon image){
	if(yellow.getY()- 1 > 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(image);
	    meetYellow();
	}
    }
    public void moveDownYellow(ImageIcon image){
	if(yellow.getY() + 1 < 24){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(image);
	    meetYellow();
	}
    }
    public void moveRightYellow(ImageIcon image){
	if(yellow.getX()+ 1 < 24){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(image);
	    meetYellow();
	}
    }
    public void moveLeftYellow(ImageIcon image){
	if(yellow.getX()- 1 > 0){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() - 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(image);
	    meetYellow();
	}
    }
  
    public void randomMoveYellow(ImageIcon image){
	int rand = (3 + (int)(Math.random() * (5)));
 		
	if(rand == 3){
	    if(panels[yellow.getY() - 1][yellow.getX()].getBorder() == null){
		moveUpYellow(image);
		lastDirectionYellow = 3;
		upCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (3 +(int)(Math.random() * (5)));
	    }
	}
	if(rand == 4){
	    if(panels[yellow.getY() + 1][yellow.getX()].getBorder() == null){
		moveDownYellow(image);
		lastDirectionYellow = 4;
		downCounter = (1 + (int)(Math.random() * (7)));
		  
	    }
	    else{
		rand = (3 +(int)(Math.random() * (5)));
	    }
	}
	if(rand == 5){
	    if(panels[yellow.getY()][yellow.getX() + 1].getBorder() == null){
		moveRightYellow(image);
		lastDirectionYellow = 5;
		rightCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (3 +(int)(Math.random() * (5)));
	    }
	}
	if(rand == 6 || rand == 7){
	    if(panels[yellow.getY()][yellow.getX() - 1].getBorder() == null){
		moveLeftYellow(image);
		lastDirectionYellow = 6;
		leftCounter = (1 + (int)(Math.random() * (7)));
	    }
	    else{
		rand = (3 +(int)(Math.random() * (5)));
	    }
	}  
    }

    public void moveUpPink(ImageIcon image){
	if(pink.getY()- 1 > 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(image);
	    meetPink();
	}
    }
    public void moveDownPink(ImageIcon image){
	if(pink.getY() + 1 < 24){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setY(pink.getY() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(image);
	    meetPink();
	}
    }
    public void moveRightPink(ImageIcon image){
	if(pink.getX()+ 1 < 24){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() + 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(image);
	    meetPink();
	}
    }
    public void moveLeftPink(ImageIcon image){
	if(pink.getX()- 1 > 0){
	    pg.setIcon(null);
	    panels[pink.getY()][pink.getX()].repaint();
	    pink.setX(pink.getX() - 1);
	    panels[pink.getY()][pink.getX()].add(pg);
	    pg.setIcon(image);
	    meetPink();
	}
    }

  
    public void randomMovePink(ImageIcon image){
	int rand = (1 + (int)(Math.random() * (4)));
 		
	if(rand == 1){
	    if(panels[pink.getY() - 1][pink.getX()].getBorder() == null){
		moveUpPink(image);
		lastDirectionPink = 1;
		upCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 2){
	    if(panels[pink.getY() + 1][pink.getX()].getBorder() == null){ 
		moveDownPink(image);
		lastDirectionPink = 2;
		downCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 3){
	    if(panels[pink.getY()][pink.getX() + 1].getBorder() == null){ 
		moveRightPink(image);
		lastDirectionPink = 3;
		rightCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	} 
	if(rand == 4){
	    if(panels[pink.getY()][pink.getX() - 1].getBorder() == null){ 
		moveLeftPink(image);
		lastDirectionPink = 4;
		leftCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}    
    }
    public void moveUpRed(ImageIcon image){
	if(red.getY()- 1 > 0){
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
	if(red.getY() + 1 < 24){
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
	if(red.getX()+ 1 < 24){
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
	if(red.getX()- 1 > 0){
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
	    if(panels[red.getY() - 1][red.getX()].getBorder() == null){
		moveUpRed(image);
		lastDirectionRed = 1;
		upCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 2){
	    if(panels[red.getY() + 1][red.getX()].getBorder() == null){
		moveDownRed(image);
		lastDirectionRed = 2;
		downCounter = (1 + (int)(Math.random() * (4)));		  
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 3){
	    if(panels[red.getY()][red.getX() + 1].getBorder() == null){
		moveRightRed(image);
		lastDirectionRed = 3;
		rightCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
	}
	if(rand == 4){
	    if(panels[red.getY()][red.getX() - 1].getBorder() == null){
		moveLeftRed(image);
		lastDirectionRed = 4;
		leftCounter = (1 + (int)(Math.random() * (4)));
	    }
	    else{
		rand = (1 + (int)(Math.random() * (4)));
	    }
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
	    //	Game.setVisible(false);
	    ( new Game()).setVisible(true) ;
		
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
    public void checkWin(){
	int sum = 0;
       	for (int x = 0; x < panels.length;x++) {
	    for (int y = 0; y < panels[x].length;y++) {
		sum +=  panels[x][y].getComponentCount();
	    }
	}

	if(sum < 303){
	    win();
	}
    }
    
	
    public void win(){
	timerBlue.stop();
	timerRed.stop();
	timerYellow.stop();
	timerPink.stop();
	int choice = JOptionPane.showConfirmDialog(null, "Congratulations ,You have beat the game!  Do you want to play again?", "Confirm",
						   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.NO_OPTION) {
	    System.exit(0);
        } 
	else if (choice == JOptionPane.YES_OPTION) {
		
	    ( new Game()).setVisible(true) ;
		
        } 
	else if (choice == JOptionPane.CLOSED_OPTION) {
	    System.exit(0);
        }
    }

    public void pacRespawn(){
	pm.setIcon(null);
	panels[pac.getY()][pac.getX()].repaint();
	pac.setX(20);
	pac.setY(20);
	panels[pac.getY()][pac.getX()].add(pm);
	pm.setIcon(R);
    }

    public void blueRespawn(){
	bg.setIcon(null);
	panels[blue.getY()][blue.getX()].repaint();
	blue.setX(10);
	blue.setY(12);
	panels[blue.getY()][blue.getX()].add(bg);
	bg.setIcon(Inky);
    }
    public void yellowRespawn(){
	yg.setIcon(null);
	panels[yellow.getY()][yellow.getX()].repaint();
	yellow.setX(9);
	yellow.setY(12);
	panels[yellow.getY()][yellow.getX()].add(yg);
	yg.setIcon(Clyde);
    }

    public void redRespawn(){
	rg.setIcon(null);
	panels[red.getY()][red.getX()].repaint();
	red.setX(10);
	red.setY(13);
	panels[red.getY()][red.getX()].add(rg);
	rg.setIcon(Blinky);
    }
    
    public void pinkRespawn(){
	pg.setIcon(null);
	panels[pink.getY()][pink.getX()].repaint();
	pink.setX(10);
	pink.setY(11);
	panels[pink.getY()][pink.getX()].add(pg);
	pg.setIcon(Pinky);
    }
   
	
    public void checkPower(){
	if((pac.getY() != 23 || pac.getX() != 23) && (pac.getY() != 23 || pac.getX() != 1) &&
	   ( pac.getY() != 1 || pac.getX() != 1) && (pac.getY() != 1 || pac.getX() != 23)){
	    panels[pac.getY()][pac.getX()].removeAll();
	    scoreCounter = scoreCounter + 1;
	    score.setText("" + scoreCounter);
	}
	else{	    
	    panels[pac.getY()][pac.getX()].removeAll();
	    scoreCounter = scoreCounter + 20;
	    score.setText("" + scoreCounter);
	    isPower = true;
	    timerPower.start();
	}
    }
    
    public void keyPressed(KeyEvent e){

	int c = e.getKeyCode();
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 > 0 &&
	   (panels[pac.getY() - 1][pac.getX()].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    if(panels[pac.getY()][pac.getX()].getComponentCount() > 0){	   
	    checkPower();
	    }
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(U);
	    meetPac();
	    checkWin();
	   
	   
	   
	   
 	}
    
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 < 24 &&
	   (panels[pac.getY() + 1][pac.getX()].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    if(panels[pac.getY()][pac.getX()].getComponentCount() > 0){	   
	    checkPower();
	    }
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(D);
	    meetPac();
	    checkWin();
	   
	}
	
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 < 24 &&
	   (panels[pac.getY()][pac.getX() + 1].getBorder() == null)){
	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    if(panels[pac.getY()][pac.getX()].getComponentCount() > 0){	   
	    checkPower();
	    }
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(R);
	    meetPac();
	    checkWin();
	    
  
	}
	
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 > 0 &&
	   (panels[pac.getY()][pac.getX() - 1].getBorder() == null)){
       	    pm.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    if(panels[pac.getY()][pac.getX()].getComponentCount() > 0){	   
	    checkPower();
	    }
	    panels[pac.getY()][pac.getX()].add(pm);
	    pm.setIcon(L);
	    meetPac();
	    checkWin();
	   
	}
    }
    
    public void keyReleased(KeyEvent e){
	
    }
    public void keyTyped(KeyEvent e){}
    
    public static void main(String[] args){
	Game game = new Game();
	game.setVisible(true);
    }
}
