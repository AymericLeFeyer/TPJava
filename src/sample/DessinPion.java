package sample;

import javafx.scene.shape.Circle;

public class DessinPion extends Circle {
    private boolean selected;
    private Pion p;

    public DessinPion(Pion p) {
        super(p.getX(), p.getY(), 10);
        selected = false;
        this.p = p;
        setFill(p.getCouleur());
    }
}
