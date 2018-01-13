import javax.swing.*;
import java.awt.*;

public class Ghost1 {

    private int xcor = 100;
    private int ycor = 100;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private JFrame frame;

    public static void main(String[] args) {
	Ghost1 ghost = new Ghost1();
	ghost.move();
    }

    public Ghost1() {
	frame = new JFrame("Pacman");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	DrawPanel drawPanel = new DrawPanel();

	frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

	frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(300, 300);
	frame.setLocation(375, 55);
    }
    class DrawPanel extends JPanel {
	    public void paintComponent(Graphics g) {
		ImageIcon Pacman = new ImageIcon("PacmanRight.png");
	        Image pac = Pacman.getImage();
		Image scaledpac = pac.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		Pacman = new ImageIcon(scaledpac);

		Pacman.paintIcon(this, g, xcor, ycor);
	    }
	}

    private void move(){
	while (true) {
	    if (xcor > 10) {
		up = false;
		down = false;
		right = true;
		left = false;
	    }
	    if (xcor > 280 && ycor > 10) {
		up = true;
		down= false;
		right = false;
		left = false;
	    }

	    if (up) {
	    ycor--;
	    }
	    if (right) {
		xcor++;
	    }
	    try {
		Thread.sleep(10);
	    } catch (Exception exc){}
	    frame.repaint();
	}
    }
}
