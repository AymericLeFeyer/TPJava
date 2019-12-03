package sample;

import javafx.scene.shape.Circle;

public class Place extends Circle {
    int x,y;
    public Place( int xPos, int yPos,int radius,int x,int y){
        super(xPos , yPos, radius);
        this.x=x;
        this.y=y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
