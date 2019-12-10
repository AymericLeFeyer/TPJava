package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Représente le dessin d'un pion P dans la partie du surakarta
 */
public class DessinPion extends Circle {
    /**
     * Nous dis si un pion est selectionée
     */
    boolean selected;
    /**
     * Pion que réprésente le dessinPion
     */
    Pion p;


    public DessinPion(Pion p, int taille, int radius, int xPos, int yPos) {
        // xPos et yPos sont les valeurs d'ecart pour le jeu
        super(xPos + p.getX()*taille, yPos + p.getY()*taille, radius);
        selected = false;
        this.p = p;

        setFill(p.getCouleur());
    }

    /**
     * La méthode permet d'actualiser les coordonées du cercle suite à un changement de place du pion p
     * @param xPos  Décalage en X par rapport au bord de la fenêtre
     * @param yPos  Décalage en Y par rapport au bord de la fenêtre
     * @param taille taille d'un pion
     */
    public void refresh(int xPos, int yPos, int taille) {
        this.setCenterX(xPos + p.getX() * taille);
        this.setCenterY(yPos + p.getY() * taille);

    }


}
