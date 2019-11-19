package sample;

import java.util.List;

enum Couleur {bleu, rouge};

class Pion {
    private int x;
    private int y;
    private Couleur couleur;

    static List<Pion> listPions;

    // Constructors
    public Pion(int x, int y, Couleur couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    // Methods

}
