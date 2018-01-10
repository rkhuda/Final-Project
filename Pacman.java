import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Pacman{
    private int xcor;
    private int ycor;
    private ImageIcon image;
    

    public Pacman(){
	xcor = 20;
	ycor = 20;
	image = new ImageIcon("Pacman.png");
	Image image2 = image.getImage();
	Image newimg = image.getScaledInstance(23,23,java.awt.Image.SCALE_SMOOTH);
    	image = new ImageIcon(newimg);
    }


    public int getX(){
	return xcor;
    }
    public int getY(){
	return ycor;
    }

    public void setX(int xcor){
	this.xcor = xcor;
    }
    public void setY(int ycor){
	this.ycor = ycor;
    }
    
    
}
