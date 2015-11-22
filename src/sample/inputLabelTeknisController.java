package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.state.staticVars;

import java.io.IOException;

/**
 * Created by steve on 22/11/2015.
 */
public class inputLabelTeknisController {
    // Kontraktor 1
    @FXML private TextField teknis11 = new TextField();
    @FXML private TextField teknis12 = new TextField();
    @FXML private TextField teknis13 = new TextField();
    @FXML private TextField teknis14 = new TextField();
    @FXML private TextField teknis15 = new TextField();
    @FXML private TextField teknis16 = new TextField();
    // Kontraktor 2
    @FXML private TextField teknis21 = new TextField();
    @FXML private TextField teknis22 = new TextField();
    @FXML private TextField teknis23 = new TextField();
    @FXML private TextField teknis24 = new TextField();
    @FXML private TextField teknis25 = new TextField();
    @FXML private TextField teknis26 = new TextField();
    // Kontraktor 3
    @FXML private TextField teknis31 = new TextField();
    @FXML private TextField teknis32 = new TextField();
    @FXML private TextField teknis33 = new TextField();
    @FXML private TextField teknis34 = new TextField();
    @FXML private TextField teknis35 = new TextField();
    @FXML private TextField teknis36 = new TextField();
    // Kontraktor 4
    @FXML private TextField teknis41 = new TextField();
    @FXML private TextField teknis42 = new TextField();
    @FXML private TextField teknis43 = new TextField();
    @FXML private TextField teknis44 = new TextField();
    @FXML private TextField teknis45 = new TextField();
    @FXML private TextField teknis46 = new TextField();
    // Kontraktor 5
    @FXML private TextField teknis51 = new TextField();
    @FXML private TextField teknis52 = new TextField();
    @FXML private TextField teknis53 = new TextField();
    @FXML private TextField teknis54 = new TextField();
    @FXML private TextField teknis55 = new TextField();
    @FXML private TextField teknis56 = new TextField();
    // Kontraktor 6
    @FXML private TextField teknis61 = new TextField();
    @FXML private TextField teknis62 = new TextField();
    @FXML private TextField teknis63 = new TextField();
    @FXML private TextField teknis64 = new TextField();
    @FXML private TextField teknis65 = new TextField();
    @FXML private TextField teknis66 = new TextField();

    public void handleBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("input_label_administrasi.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleNextButton(ActionEvent actionEvent) {
        // Simpan record terkait teknis
        staticVars.recordKontraktor1.insertTeknisScore(teknis11.getText(),teknis12.getText(),teknis13.getText(),teknis14.getText(),teknis15.getText(),teknis16.getText());
        staticVars.recordKontraktor2.insertTeknisScore(teknis21.getText(),teknis22.getText(),teknis23.getText(),teknis24.getText(),teknis25.getText(),teknis26.getText());
        staticVars.recordKontraktor3.insertTeknisScore(teknis31.getText(),teknis32.getText(),teknis33.getText(),teknis34.getText(),teknis35.getText(),teknis36.getText());
        staticVars.recordKontraktor4.insertTeknisScore(teknis41.getText(),teknis42.getText(),teknis43.getText(),teknis44.getText(),teknis45.getText(),teknis46.getText());
        staticVars.recordKontraktor5.insertTeknisScore(teknis51.getText(),teknis52.getText(),teknis53.getText(),teknis54.getText(),teknis55.getText(),teknis56.getText());
        staticVars.recordKontraktor6.insertTeknisScore(teknis61.getText(),teknis62.getText(),teknis63.getText(),teknis64.getText(),teknis65.getText(),teknis66.getText());
        // Pindah layar
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("input_label_anggaran.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }
}
