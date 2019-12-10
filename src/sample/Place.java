package sample;

import javafx.scene.shape.Circle;

/**
 * Classe réprésentant les pions derrière les jetons actuel (uniquement du design)
 */
public class Place extends Circle {
    /**
     * Représente les coordonée en X Y de la place
     */
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
