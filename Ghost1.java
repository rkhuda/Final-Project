import javax.swing.*;
import java.awt.*;

public class Ghost1 {

    int xcor = 20;
    int ycor = 20;

    public static void main(String[] args) {
	Ghost1 ghost = new Ghost1();
    }

    public Ghost1() {
	JFrame frame = new JFrame("Pacman");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	DrawPanel drawPanel = new DrawPanel();

	frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

	frame.setVisible(true);
	frame.setResizable(false);
	frame.setSize(300, 300);
	frame.setLocation(375, 55);

	//move();
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
}
