package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

/**
 * Pion est la classe qui représente un pion de la partie de surakarta
 */
class Pion {
    /**
     * Coordonées du pion en X
     */
    private int x;
    /**
     * Cordonnée du pion en Y
     */
    private int y;
    /**
     * Couleur du pion
     */
    private Color couleur;

    /**
     * Liste de tout les pions de la partie
     */
    static List<Pion> listPions = new ArrayList<Pion>();

    // Constructors
    public Pion(int x, int y, Color couleur) {
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getCouleur() {
        return couleur;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * Méthode permettant de d'initialiser un tableau de pion qu'on va utiliser par la suite pendant le jeu
     */
        static void initializePions() {
        listPions.add(new Pion(1, 1, Color.BLUE));
        listPions.add(new Pion(2, 1, Color.BLUE));
        listPions.add(new Pion(3, 1, Color.BLUE));
        listPions.add(new Pion(4, 1, Color.BLUE));
        listPions.add(new Pion(5, 1, Color.BLUE));
        listPions.add(new Pion(6, 1, Color.BLUE));
        listPions.add(new Pion(1, 2, Color.BLUE));
        listPions.add(new Pion(2, 2, Color.BLUE));
        listPions.add(new Pion(3, 2, Color.BLUE));
        listPions.add(new Pion(4, 2, Color.BLUE));
        listPions.add(new Pion(5, 4, Color.BLUE));
        listPions.add(new Pion(6, 2, Color.BLUE));

        listPions.add(new Pion(1, 5, Color.RED));
        listPions.add(new Pion(2, 5, Color.RED));
        listPions.add(new Pion(3, 5, Color.RED));
        listPions.add(new Pion(4, 5, Color.RED));
        listPions.add(new Pion(5, 5, Color.RED));
        listPions.add(new Pion(6, 5, Color.RED));
        listPions.add(new Pion(1, 6, Color.RED));
        listPions.add(new Pion(2, 6, Color.RED));
        listPions.add(new Pion(3, 6, Color.RED));
        listPions.add(new Pion(4, 6, Color.RED));
        listPions.add(new Pion(5, 6, Color.RED));
        listPions.add(new Pion(6, 6, Color.RED));

    }

    /**
     * Cette méthode permet de savoir si le pion peut se déplacer en X,Y  en utilisant un mouvement simple c'est à dire un mouvement de 1 case autour de lui
     * @param x Coordonées X ou l'on veut déplacer le pion
     * @param y Coordonées Y ou l'on veut déplacer le pion
     * @return renvoie un booléen en fonction de la possibilité du mouvement simple
     */
    boolean simpleMove(int x, int y) {
        for (Pion p : listPions) {
            if (p.x == x && p.y == y && p.getCouleur() == this.getCouleur()) {
                return false;
            }
        }
        if (((abs(x - this.x) == 1) && (abs(y - this.y) == 1)) || ((abs(x - this.x) == 0) && (abs(y - this.y) == 1)) || ((abs(x - this.x) == 1) && (abs(y - this.y) == 0))) {
            return true;
        }

        return false;
    }

    /**
     *Nous décris si un move en x y est possible à partir du pion
     * @param i Coordonées X ou l'on veut déplacer le pion
     * @param j Coordonées Y ou l'on veut déplacer le pion
     * @return renvoie un booléen si l'on peut déplace le pion en X,Y en utilisant sois le mouvement simple sois le mouvement en boucle
     */
    public boolean isMovePossible(int i, int j) {
        return simpleMove(i, j) || boucleMove(i, j);
    }

    /**
     * Déplace le pion
     * @param x Coordonées X ou l'on veut déplacer le pion
     * @param y Coordonées Y ou l'on veut déplacer le pion
     */
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x coordonnée en x que l'on souhaite verifié
     * @param y coordonnée en y que l'on souhaite verifié
     * @return retourne vraie si les coordonnées du pion sont égals à celle passé en paramètre
     */
    public boolean equals(int x, int y) {

        if (this.x == x && this.y == y) {
            return true;
        }

        return false;
    }

    /**
     * Cette méthode permet de savoir si le pion peut se déplacer en X,Y  en utilisant un mouvement en boucle
     * @param x Coordonées X ou l'on veut déplacer le pion
     * @param y Coordonées Y ou l'on veut déplacer le pion
     * @return renvoie un booléen en fonction de la possibilité du mouvement en boucle
     */
    public boolean boucleMove(int x, int y) {
        int listeCoordonnée[][] = {
                {2, 1},
                {2, 2},
                {2, 3},
                {2, 4},
                {2, 5},
                {2, 6},
                {1, 5},
                {2, 5},

                {3, 5},
                {4, 5},
                {5, 5},
                {6, 5},
                {5, 6},
                {5, 5},
                {5, 4},
                {5, 3},
                {5, 2},
                {5, 1},
                {6, 2},
                {5, 2},
                {4, 2},
                {3, 2},
                {2, 2},

        };

        int[] pion = {this.getX(), this.getY()};
        int idPion = -1;

        for (int i = 0; i < 23; i++) {
            if (listeCoordonnée[i][0] == pion[0] && listeCoordonnée[i][1] == pion[1]) {
                idPion = i;
                break;
            }


        }


        if (idPion == -1) {
            return false;
        }


        for (int i = idPion+1; i < 23; i++) {
            for (Pion p : listPions) {
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && !p.equals(x, y)) return false;
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && p.equals(x, y)) return true;


            }
        }
        for (int i = 0; i < idPion-1; i++) {
            for (Pion p : listPions) {
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && !p.equals(x, y)) return false;
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && p.equals(x, y)) return true;
            }
        }

        for (int i = idPion-1; i == 0; i--) {

            for (Pion p : listPions) {
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && !p.equals(x, y))return false;
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && p.equals(x, y)) return true;
            }
        }


        for (int i = 22; i > idPion; i--) {
            for (Pion p : listPions) {
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && !p.equals(x, y)) return false;
                if (p.equals(listeCoordonnée[i][0], listeCoordonnée[i][1]) && p.equals(x, y)) return true;
            }
        }


        return false;


    }
}
