package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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
        Pion.initializePions();
        for (int i = 1; i < 7; i++) {
            troupe.getChildren().add(new Line(xPos + ecartement,yPos + ecartement*i,xPos + ecartement*6,yPos + ecartement*i));
            troupe.getChildren().add(new Line(xPos + ecartement*i,yPos + ecartement,xPos + ecartement*i,yPos +ecartement*6));

        }
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                troupe.getChildren().add(new DessinPion(new Pion(i, j, Color.WHITE), ecartement, radiusPion, xPos, yPos));

            }
        }


        for (Pion p : Pion.listPions) {
            DessinPion dp = new DessinPion(p, ecartement, radiusPion, xPos, yPos);
            dessinPions.add(dp);
            troupe.getChildren().add(dp);
        }
    }
}
