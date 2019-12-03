package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private List<DessinPion> dessinPions;
    private final int ecartement = 60;
    private final int radiusPion = 15;

    private final int xPos = 100;
    private final int yPos = 100;

    private final Color couleur1 = Color.YELLOW;
    private final Color couleur2 = Color.GREEN;

    private List<Circle> rondsPossible;

    DessinPion ps;

    @Override
    public void start(Stage primaryStage) throws Exception {
        dessinPions = new ArrayList<>();
        construirePlateau(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void construirePlateau(Stage primaryStage) {

        Group troupe = new Group();
        Scene scene = new Scene(troupe, 600, 600, Color.BLACK);
        // definir les acteurs et les habiller
        dessinEnv(troupe);

        primaryStage.setTitle("Jeu du Surakarta");
        primaryStage.setScene(scene);
        // afficher le theatre
        primaryStage.show();

    }

    public void dessinEnv(Group troupe) {
        float lineWidth = 5;
        // Initialisation des pions
        Pion.initializePions();
        // Affichage des lignes
        Color c = Color.WHITE;
        for (int i = 1; i < 7; i++) {
            if (i == 1) c = couleur1;
            else c = Color.WHITE;

            Line l1 = new Line(xPos + ecartement, yPos + ecartement * i, xPos + ecartement * 6, yPos + ecartement * i);
            Line l2 = new Line(xPos + ecartement * i, yPos + ecartement, xPos + ecartement * i, yPos + ecartement * 6);
            l1.setStroke(Color.WHITE);
            l2.setStroke(Color.WHITE);
            l1.setStrokeWidth(lineWidth);
            l2.setStrokeWidth(lineWidth);
            troupe.getChildren().add(l1);
            troupe.getChildren().add(l2);
            if (i == 3 || i == 4) {
                l1.setStroke(couleur2);
                l2.setStroke(couleur2);
            }
            if (i == 2 || i == 5) {
                l1.setStroke(couleur1);
                l2.setStroke(couleur1);
            }


        }
        // Affichage des arcs
        Arc arc1 = new Arc(ecartement + xPos, ecartement + yPos, ecartement, ecartement, 0, 270);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(couleur1);
        arc1.setStrokeWidth(lineWidth);

        Arc arc2 = new Arc(ecartement * 6 + xPos, ecartement + yPos, ecartement, ecartement, 270, 270);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(couleur1);
        arc2.setStrokeWidth(lineWidth);


        Arc arc3 = new Arc(ecartement + xPos, ecartement * 6 + yPos, ecartement, ecartement, 90, 270);
        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(couleur1);
        arc3.setStrokeWidth(lineWidth);

        Arc arc4 = new Arc(ecartement * 6 + xPos, ecartement * 6 + yPos, ecartement, ecartement, 180, 270);
        arc4.setType(ArcType.OPEN);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(couleur1);
        arc4.setStrokeWidth(lineWidth);

        Arc arc5 = new Arc(ecartement + xPos, ecartement + yPos, 2 * ecartement, 2 * ecartement, 0, 270);
        arc5.setType(ArcType.OPEN);
        arc5.setFill(Color.TRANSPARENT);
        arc5.setStroke(couleur2);
        arc5.setStrokeWidth(lineWidth);

        Arc arc6 = new Arc(ecartement * 6 + xPos, ecartement + yPos, 2 * ecartement, 2 * ecartement, 270, 270);
        arc6.setType(ArcType.OPEN);
        arc6.setFill(Color.TRANSPARENT);
        arc6.setStroke(couleur2);
        arc6.setStrokeWidth(lineWidth);

        Arc arc7 = new Arc(ecartement + xPos, ecartement * 6 + yPos, 2 * ecartement, 2 * ecartement, 90, 270);
        arc7.setType(ArcType.OPEN);
        arc7.setFill(Color.TRANSPARENT);
        arc7.setStroke(couleur2);
        arc7.setStrokeWidth(lineWidth);

        Arc arc8 = new Arc(ecartement * 6 + xPos, ecartement * 6 + yPos, 2 * ecartement, 2 * ecartement, 180, 270);
        arc8.setType(ArcType.OPEN);
        arc8.setFill(Color.TRANSPARENT);
        arc8.setStroke(couleur2);
        arc8.setStrokeWidth(lineWidth);

        troupe.getChildren().add(arc1);
        troupe.getChildren().add(arc2);
        troupe.getChildren().add(arc3);
        troupe.getChildren().add(arc4);
        troupe.getChildren().add(arc5);
        troupe.getChildren().add(arc6);
        troupe.getChildren().add(arc7);
        troupe.getChildren().add(arc8);


        // Affichage des ronds blancs
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                troupe.getChildren().add(new DessinPion(new Pion(i, j, Color.WHITE), ecartement, radiusPion, xPos, yPos));

            }
        }
        // Affichage des pions
        for (Pion p : Pion.listPions) {

            DessinPion dp = new DessinPion(p, ecartement, radiusPion - 2, xPos, yPos);
            dp.setOnMouseClicked(t -> {

                if (ps != null) {
                    ps.selected = false;
                    ps.setFill(ps.p.getCouleur());
                }
                ps = dp;
                dp.selected = true;
                ps.setFill(Color.ORANGE);

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (p.simpleMove(i, j)) {
                            rondsPossible.add(new Circle());



                        }

                    }
                }
                dp.refresh(xPos, yPos, ecartement);

            });

            dessinPions.add(dp);
            troupe.getChildren().add(dp);
        }
    }
}
