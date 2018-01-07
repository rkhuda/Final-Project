import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Walls extends JPanel {
    
    public void paint(Graphics g) {
	
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(10));
	g2.setPaint(Color.blue);
	g2.draw(new Rectangle2D.Float(0, 0, 500, 500));
    }
}
