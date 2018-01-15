public class Enemy{
    private int xcor;
    private int ycor;
    
    

    public Enemy(int xcor, int ycor){
	this.xcor = xcor;
	this.ycor = ycor;
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