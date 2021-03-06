package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("layar_pembuka.fxml"));
        primaryStage.setTitle("Decision Support System");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
        staticVars.currentStage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
