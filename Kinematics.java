
import java.awt.Point;

public class Kinematics{

    private Point position;
    private final int gravity = 9;
    private int velocity;
    private int aceletarion;

    public Kinematics(){
        Point posPoint = new Point();
        this.position = posPoint;
        this.velocity = 0;
        this.aceletarion = 0;
    }

    public Kinematics(int x0, int y0, int v0, int a0){
        Point posPoint = new Point(x0 , y0);
        this.position = posPoint;
        this.velocity = v0;
        this.aceletarion = a0;
    }

    public String toString(){
        return "(" + position.x + "," + position.y +")";
    }

    public int getX(){
        return position.x;
    }

    public int getY(){
        return position.y;
    }

    public int getVelocity(){
        return this.velocity;
    }

    public double getAceleration(){
        return this.aceletarion;
    }

    //Setters

    public void setPositionX(int x){
        position.x = x;
    }

    public void setPositionY(int y){
        position.y = y;
    }

    public void setVelocity (int v){
        this.velocity = v;
    }

    public void setAceleration(int a){
        this.aceletarion = a;
    }

    public int postionX(int time){
        int v_x = velocity;
        int a_x = aceletarion;
        return position.x + v_x * time + a_x * time * time;
    }

    public int freeFalling(int time){
        
        return position.y + velocity * time + gravity * time * time;
    }

    public int ballVelocityY(int time){
        return velocity + aceletarion * time;
    }

    public static void main(String[] args){
        System.out.println("Welcome to Kinematics!!");
        Kinematics testPoint = new Kinematics();
        System.out.println(testPoint.toString());
    }
}