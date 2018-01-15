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
	}
    }
    public void moveDownYellow(){
	if(yellow.getY() + 1 <= 39){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setY(yellow.getY() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	}
    }
    public void moveRightYellow(){
	if(yellow.getX()+ 1 <= 39){
	    yg.setIcon(null);
	    panels[yellow.getY()][yellow.getX()].repaint();
	    yellow.setX(yellow.getX() + 1);
	    panels[yellow.getY()][yellow.getX()].add(yg);
	    yg.setIcon(Clyde);
	}
    }
    public void moveLeftYellow(){
	if(yellow.getX()- 1 >= 0){
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
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){

    }
    
    public static void main(String[] args){
	Maze2 maze = new Maze2();
	maze.setVisible(true);

    }
}
    

