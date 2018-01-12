public class Pacman{
    private int xcor;
    private int ycor;
    private int xChange;
    private int yChange;
   
    

    public Pacman(){
	xcor = 20;
	ycor = 20;
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