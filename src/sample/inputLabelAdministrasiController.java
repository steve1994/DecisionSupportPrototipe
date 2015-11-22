package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by steve on 22/11/2015.
 */
public class inputLabelAdministrasiController {
    // Kontraktor 1
    @FXML private TextField administrasi11 = new TextField();
    @FXML private TextField administrasi12 = new TextField();
    @FXML private TextField administrasi13 = new TextField();
    @FXML private TextField administrasi14 = new TextField();
    @FXML private TextField administrasi15 = new TextField();
    @FXML private TextField administrasi16 = new TextField();
    @FXML private TextField administrasi17 = new TextField();
    @FXML private TextField administrasi18 = new TextField();
    // Kontraktor 2
    @FXML private TextField administrasi21 = new TextField();
    @FXML private TextField administrasi22 = new TextField();
    @FXML private TextField administrasi23 = new TextField();
    @FXML private TextField administrasi24 = new TextField();
    @FXML private TextField administrasi25 = new TextField();
    @FXML private TextField administrasi26 = new TextField();
    @FXML private TextField administrasi27 = new TextField();
    @FXML private TextField administrasi28 = new TextField();
    // Kontraktor 3
    @FXML private TextField administrasi31 = new TextField();
    @FXML private TextField administrasi32 = new TextField();
    @FXML private TextField administrasi33 = new TextField();
    @FXML private TextField administrasi34 = new TextField();
    @FXML private TextField administrasi35 = new TextField();
    @FXML private TextField administrasi36 = new TextField();
    @FXML private TextField administrasi37 = new TextField();
    @FXML private TextField administrasi38 = new TextField();
    // Kontraktor 4
    @FXML private TextField administrasi41 = new TextField();
    @FXML private TextField administrasi42 = new TextField();
    @FXML private TextField administrasi43 = new TextField();
    @FXML private TextField administrasi44 = new TextField();
    @FXML private TextField administrasi45 = new TextField();
    @FXML private TextField administrasi46 = new TextField();
    @FXML private TextField administrasi47 = new TextField();
    @FXML private TextField administrasi48 = new TextField();
    // Kontraktor 5
    @FXML private TextField administrasi51 = new TextField();
    @FXML private TextField administrasi52 = new TextField();
    @FXML private TextField administrasi53 = new TextField();
    @FXML private TextField administrasi54 = new TextField();
    @FXML private TextField administrasi55 = new TextField();
    @FXML private TextField administrasi56 = new TextField();
    @FXML private TextField administrasi57 = new TextField();
    @FXML private TextField administrasi58 = new TextField();
    // Kontraktor 6
    @FXML private TextField administrasi61 = new TextField();
    @FXML private TextField administrasi62 = new TextField();
    @FXML private TextField administrasi63 = new TextField();
    @FXML private TextField administrasi64 = new TextField();
    @FXML private TextField administrasi65 = new TextField();
    @FXML private TextField administrasi66 = new TextField();
    @FXML private TextField administrasi67 = new TextField();
    @FXML private TextField administrasi68 = new TextField();

    public void handleBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("layar_subkriteria_ahp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleNextButton(ActionEvent actionEvent) {
        // Simpan record terkait administrasi
        staticVars.recordKontraktor1.insertAdministrasiScore(administrasi11.getText(),administrasi12.getText(),administrasi13.getText(),administrasi14.getText(),administrasi15.getText(),administrasi16.getText(),administrasi17.getText(),administrasi18.getText());
        staticVars.recordKontraktor2.insertAdministrasiScore(administrasi21.getText(),administrasi22.getText(),administrasi23.getText(),administrasi24.getText(),administrasi25.getText(),administrasi26.getText(),administrasi27.getText(),administrasi28.getText());
        staticVars.recordKontraktor3.insertAdministrasiScore(administrasi31.getText(),administrasi32.getText(),administrasi33.getText(),administrasi34.getText(),administrasi35.getText(),administrasi36.getText(),administrasi37.getText(),administrasi38.getText());
        staticVars.recordKontraktor4.insertAdministrasiScore(administrasi41.getText(),administrasi42.getText(),administrasi43.getText(),administrasi44.getText(),administrasi45.getText(),administrasi46.getText(),administrasi47.getText(),administrasi48.getText());
        staticVars.recordKontraktor5.insertAdministrasiScore(administrasi51.getText(),administrasi52.getText(),administrasi53.getText(),administrasi54.getText(),administrasi55.getText(),administrasi56.getText(),administrasi57.getText(),administrasi58.getText());
        staticVars.recordKontraktor6.insertAdministrasiScore(administrasi61.getText(),administrasi62.getText(),administrasi63.getText(),administrasi64.getText(),administrasi65.getText(),administrasi66.getText(),administrasi67.getText(),administrasi68.getText());
        // Pindah layar
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
}
