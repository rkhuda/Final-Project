import javax.swing.*;
import java.awt.*;

public class Ghost extends JComponent {

    private int lastX = 0;

    public Ghost() {
	Thread animation = new Thread(
				      new Runnable() {
					  public void run() {
					      while (true) {
						  repaint();
						  try {
						      Thread.sleep(10);
						  } catch (Exception ex) {}
					      }
					  }
				      });
	animation.start();
    }

    public void paintComponent(Graphics g) {

	int w = getWidth();
	int h = getHeight();

	int speed = 1;

	int x = lastX + speed;

	if (x > w + 100) {
	    x = -100;
	}

	ImageIcon Pacman = new ImageIcon("Pacman.png");
	Image pac = Pacman.getImage();
	Image scaledpac = pac.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(scaledpac);

	Pacman.paintIcon(this, g, x, h/2 + 10);

	lastX = x;
	
    }
}
