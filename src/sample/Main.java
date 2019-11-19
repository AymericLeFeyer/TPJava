package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    List<DessinPion> dessinPions;

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
        Scene scene = new Scene(troupe, 300, 200, Color.ANTIQUEWHITE);
        // definir les acteurs et les habiller
        dessinEnv(troupe);

        primaryStage.setTitle("Jeu du Surakarta");
        primaryStage.setScene(scene);
        // afficher le theatre
        primaryStage.show();

    }

    public void dessinEnv(Group troupe) {
        Pion.initializePions();
        for (Pion p : Pion.listPions) {
            DessinPion dp = new DessinPion(p);
            dessinPions.add(dp);
            troupe.getChildren().add(dp);
        }
    }
}
