package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by steve on 22/11/2015.
 */
public class layarSubkriteriaAHPController {
    public void handleBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("model_configuration.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleNextButton(ActionEvent actionEvent) {
        Parent root = null;
       /* if (staticVars.modelModeSelected == 1) {        // AHP
            try {
                root = FXMLLoader.load(getClass().getResource("input_matriks_berpasangan.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (staticVars.modelModeSelected == 2) { // Clustering
            try {
                root = FXMLLoader.load(getClass().getResource("layar_keterangan_label_clustering.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } */
        try {
            root = FXMLLoader.load(getClass().getResource("input_matriks_berpasangan.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }
}
