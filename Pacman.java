public class Pacman{
    private int xcor;
    private int ycor;
    private int xChange;
    private int yChange;
    private int lives;
    

    public Pacman(){
	xcor = 20;
	ycor = 20;
	lives = 3;
    }

    public int getX(){
	return xcor;
    }
    public int getY(){
	return ycor;
    }
    public int getLives(){
	return lives;
    }
    public void setX(int xcor){
	this.xcor = xcor;
    }
    public void setY(int ycor){
	this.ycor = ycor;
    }
    public void setLives(int lives){
	this.lives = lives;
	    }
}