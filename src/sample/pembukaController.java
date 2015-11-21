package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class pembukaController extends Application {
    @FXML private Button tryItButton;


    @Override
    public void start(Stage primaryStage) throws Exception {
        tryItButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("input_kontraktor.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            }
        });
    }

    @FXML protected void handleFirstScene(ActionEvent actionEvent) {

    }
}
