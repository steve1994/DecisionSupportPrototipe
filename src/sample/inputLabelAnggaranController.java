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
public class inputLabelAnggaranController {
    // Kontraktor 1
    @FXML private TextField anggaran11 = new TextField();
    @FXML private TextField anggaran12 = new TextField();
    @FXML private TextField anggaran13 = new TextField();
    // Kontraktor 2
    @FXML private TextField anggaran21 = new TextField();
    @FXML private TextField anggaran22 = new TextField();
    @FXML private TextField anggaran23 = new TextField();
    // Kontraktor 3
    @FXML private TextField anggaran31 = new TextField();
    @FXML private TextField anggaran32 = new TextField();
    @FXML private TextField anggaran33 = new TextField();
    // Kontraktor 4
    @FXML private TextField anggaran41 = new TextField();
    @FXML private TextField anggaran42 = new TextField();
    @FXML private TextField anggaran43 = new TextField();
    // Kontraktor 5
    @FXML private TextField anggaran51 = new TextField();
    @FXML private TextField anggaran52 = new TextField();
    @FXML private TextField anggaran53 = new TextField();
    // Kontraktor 6
    @FXML private TextField anggaran61 = new TextField();
    @FXML private TextField anggaran62 = new TextField();
    @FXML private TextField anggaran63 = new TextField();

    public void handleBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("input_label_teknis.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleLihatHasilButton(ActionEvent actionEvent) {
        // Simpan record terkait anggaran
        staticVars.recordKontraktor1.insertAnggaranScore(Integer.parseInt(anggaran11.getText()),Integer.parseInt(anggaran12.getText()),Integer.parseInt(anggaran13.getText()));
        staticVars.recordKontraktor2.insertAnggaranScore(Integer.parseInt(anggaran21.getText()),Integer.parseInt(anggaran22.getText()),Integer.parseInt(anggaran23.getText()));
        staticVars.recordKontraktor3.insertAnggaranScore(Integer.parseInt(anggaran31.getText()),Integer.parseInt(anggaran32.getText()),Integer.parseInt(anggaran33.getText()));
        staticVars.recordKontraktor4.insertAnggaranScore(Integer.parseInt(anggaran41.getText()),Integer.parseInt(anggaran42.getText()),Integer.parseInt(anggaran43.getText()));
        staticVars.recordKontraktor5.insertAnggaranScore(Integer.parseInt(anggaran51.getText()),Integer.parseInt(anggaran52.getText()),Integer.parseInt(anggaran53.getText()));
        staticVars.recordKontraktor6.insertAnggaranScore(Integer.parseInt(anggaran61.getText()),Integer.parseInt(anggaran62.getText()),Integer.parseInt(anggaran63.getText()));
        // Pindah ke layar hasil clustering
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("layar_hasil_clustering.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }
}
