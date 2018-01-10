import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Pacman{
    private int xcor;
    private int ycor;
    private int xChange;
    private int yChange;
    private Image image;
    

    public Pacman(){
	xcor = 20;
	ycor = 20;
	ImageIcon image2 = new ImageIcon("Pacman.png");
	image = image2.getImage();
	//	Image newimg = image3.getScaledInstance(23,23,java.awt.Image.SCALE_SMOOTH);
	//	image = newimg.getImage();
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
    public Image getImage(){
	return image;
    }

    public void move(){
	xcor += xChange;
	ycor += yChange;
    }
    public void keyPressed(KeyEvent e){
	int c = e .getKeyCode();
	if(c == KeyEvent.VK_UP){
	    yChange = 1;
	}
	if(c == KeyEvent.VK_DOWN){
	    yChange = -1;
	}
	if(c == KeyEvent.VK_RIGHT){
	    xChange = 1;
	}
	if(c == KeyEvent.VK_LEFT){
	    xChange = -1;
	}
    }

    public void keyTyped(KeyEvent e){
    }

    public void keyReleased(KeyEvent e){
	int c = e .getKeyCode();
	if(c == KeyEvent.VK_UP){
	    yChange = 0;
	}
	if(c == KeyEvent.VK_DOWN){
	    yChange = 0;
	}
	if(c == KeyEvent.VK_RIGHT){
	    xChange = 0;
	}
	if(c == KeyEvent.VK_LEFT){
	    xChange = 0;
	}
    }

}





