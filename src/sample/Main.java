package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private List<DessinPion> dessinPions;
    private final int ecartement = 40;
    private final int radiusPion = 15;

    private final int xPos = 50;
    private final int yPos = 50;

    private final Color couleur1 = Color.YELLOW;
    private final Color couleur2 = Color.ORANGE;

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
        Scene scene = new Scene(troupe, 400, 400, Color.GRAY);
        // definir les acteurs et les habiller
        dessinEnv(troupe);

        primaryStage.setTitle("Jeu du Surakarta");
        primaryStage.setScene(scene);
        // afficher le theatre
        primaryStage.show();

    }

    public void dessinEnv(Group troupe) {
        // Initialisation des pions
        Pion.initializePions();
        // Affichage des lignes
        Color c = Color.BLACK;
        for (int i = 1; i < 7; i++) {
            if (i == 1) c = couleur1;
            else c = Color.BLACK;
            troupe.getChildren().add(new Line(xPos + ecartement,yPos + ecartement*i,xPos + ecartement*6,yPos + ecartement*i));
            troupe.getChildren().add(new Line(xPos + ecartement*i,yPos + ecartement,xPos + ecartement*i,yPos +ecartement*6));


        }
        // Affichage des arcs
        Arc arc1 = new Arc(ecartement + xPos, ecartement + yPos, ecartement , ecartement, 0, 270);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(couleur1);

        Arc arc2 = new Arc(ecartement * 6 + xPos, ecartement + yPos, ecartement , ecartement, 270, 270);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(couleur1);

        Arc arc3 = new Arc(ecartement + xPos, ecartement * 6 + yPos, ecartement , ecartement, 90, 270);
        arc3.setType(ArcType.OPEN);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(couleur1);

        Arc arc4 = new Arc(ecartement * 6 + xPos, ecartement * 6 + yPos, ecartement , ecartement, 180, 270);
        arc4.setType(ArcType.OPEN);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(couleur1);

        troupe.getChildren().add(arc1);
        troupe.getChildren().add(arc2);
        troupe.getChildren().add(arc3);
        troupe.getChildren().add(arc4);



        // Affichage des ronds blancs
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                troupe.getChildren().add(new DessinPion(new Pion(i, j, Color.WHITE), ecartement, radiusPion, xPos, yPos));

            }
        }
        // Affichage des pions
        for (Pion p : Pion.listPions) {
            DessinPion dp = new DessinPion(p, ecartement, radiusPion, xPos, yPos);
            dessinPions.add(dp);
            troupe.getChildren().add(dp);
        }
    }
}
