package sample;

import AHP.Utils.EksternalFileCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.InputPairWiseComparison;

import java.io.File;
import java.io.IOException;

/**
 * Created by steve on 22/11/2015.
 */
public class inputMatriksBerpasanganController {
  /*  @FXML private TextField Administrasi12 = new TextField();
    @FXML private TextField Administrasi13 = new TextField();
    @FXML private TextField Administrasi14 = new TextField();
    @FXML private TextField Administrasi15 = new TextField();
    @FXML private TextField Administrasi16 = new TextField();
    @FXML private TextField Administrasi17 = new TextField();
    @FXML private TextField Administrasi18 = new TextField();
    @FXML private TextField Administrasi23 = new TextField();
    @FXML private TextField Administrasi24 = new TextField();
    @FXML private TextField Administrasi25 = new TextField();
    @FXML private TextField Administrasi26 = new TextField();
    @FXML private TextField Administrasi27 = new TextField();
    @FXML private TextField Administrasi28 = new TextField();
    @FXML private TextField Administrasi34 = new TextField();
    @FXML private TextField Administrasi35 = new TextField();
    @FXML private TextField Administrasi36 = new TextField();
    @FXML private TextField Administrasi37 = new TextField();
    @FXML private TextField Administrasi38 = new TextField();
    @FXML private TextField Administrasi45 = new TextField();
    @FXML private TextField Administrasi46 = new TextField();
    @FXML private TextField Administrasi47 = new TextField();
    @FXML private TextField Administrasi48 = new TextField();
    @FXML private TextField Administrasi56 = new TextField();
    @FXML private TextField Administrasi57 = new TextField();
    @FXML private TextField Administrasi58 = new TextField();
    @FXML private TextField Administrasi67 = new TextField();
    @FXML private TextField Administrasi68 = new TextField();
    @FXML private TextField Administrasi78 = new TextField();
    @FXML private TextField Teknis12 = new TextField();
    @FXML private TextField Teknis13 = new TextField();
    @FXML private TextField Teknis14 = new TextField();
    @FXML private TextField Teknis15 = new TextField();
    @FXML private TextField Teknis16 = new TextField();
    @FXML private TextField Teknis23 = new TextField();
    @FXML private TextField Teknis24 = new TextField();
    @FXML private TextField Teknis25 = new TextField();
    @FXML private TextField Teknis26 = new TextField();
    @FXML private TextField Teknis34 = new TextField();
    @FXML private TextField Teknis35 = new TextField();
    @FXML private TextField Teknis36 = new TextField();
    @FXML private TextField Teknis45 = new TextField();
    @FXML private TextField Teknis46 = new TextField();
    @FXML private TextField Teknis56 = new TextField();
    @FXML private TextField Anggaran12 = new TextField();
    @FXML private TextField Anggaran13 = new TextField();
    @FXML private TextField Anggaran23 = new TextField();*/
    @FXML private TextField pathMatrixAdministrasi = new TextField();
    @FXML private TextField pathMatrixTeknis = new TextField();
    @FXML private TextField pathMatrixAnggaran = new TextField();

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
        // ADMINISTRASI
       /* InputPairWiseComparison inputCriteriaAdministrasi = new InputPairWiseComparison();
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,1,Integer.parseInt(Administrasi12.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,2,Integer.parseInt(Administrasi13.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,3,Integer.parseInt(Administrasi14.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,4,Integer.parseInt(Administrasi15.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,5,Integer.parseInt(Administrasi16.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,6,Integer.parseInt(Administrasi17.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(0,7,Integer.parseInt(Administrasi18.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,2,Integer.parseInt(Administrasi23.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,3,Integer.parseInt(Administrasi24.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,4,Integer.parseInt(Administrasi25.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,5,Integer.parseInt(Administrasi26.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,6,Integer.parseInt(Administrasi27.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,7,Integer.parseInt(Administrasi28.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,3,Integer.parseInt(Administrasi34.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,4,Integer.parseInt(Administrasi35.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,5,Integer.parseInt(Administrasi36.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,6,Integer.parseInt(Administrasi37.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,7,Integer.parseInt(Administrasi38.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,4,Integer.parseInt(Administrasi45.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,5,Integer.parseInt(Administrasi46.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,6,Integer.parseInt(Administrasi47.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,7,Integer.parseInt(Administrasi48.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,5,Integer.parseInt(Administrasi56.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,6,Integer.parseInt(Administrasi57.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,7,Integer.parseInt(Administrasi58.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(5,6,Integer.parseInt(Administrasi67.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(5,7,Integer.parseInt(Administrasi68.getText()));
        inputCriteriaAdministrasi.insertInputPairWiseComparison(6,7,Integer.parseInt(Administrasi78.getText()));*/
        staticVars.matriksBerpasanganAdministrasi = EksternalFileCSV.readHalfMatrix(pathMatrixAdministrasi.getText().toString());
        // TEKNIS
       /* InputPairWiseComparison inputCriteriaTeknis = new InputPairWiseComparison();
        inputCriteriaTeknis.insertInputPairWiseComparison(0,1,Integer.parseInt(Teknis12.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(0,2,Integer.parseInt(Teknis13.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(0,3,Integer.parseInt(Teknis14.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(0,4,Integer.parseInt(Teknis15.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(0,5,Integer.parseInt(Teknis16.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(1,2,Integer.parseInt(Teknis23.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(1,3,Integer.parseInt(Teknis24.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(1,4,Integer.parseInt(Teknis25.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(1,5,Integer.parseInt(Teknis26.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(2,3,Integer.parseInt(Teknis34.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(2,4,Integer.parseInt(Teknis35.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(2,5,Integer.parseInt(Teknis36.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(3,4,Integer.parseInt(Teknis45.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(3,5,Integer.parseInt(Teknis46.getText()));
        inputCriteriaTeknis.insertInputPairWiseComparison(4,5,Integer.parseInt(Teknis56.getText()));*/
        staticVars.matriksBerpasanganTeknis = EksternalFileCSV.readHalfMatrix(pathMatrixTeknis.getText().toString());
        // ANGGARAN
       /* InputPairWiseComparison inputCriteriaAnggaran = new InputPairWiseComparison();
        inputCriteriaAnggaran.insertInputPairWiseComparison(0,1,Integer.parseInt(Anggaran12.getText()));
        inputCriteriaAnggaran.insertInputPairWiseComparison(0,2,Integer.parseInt(Anggaran13.getText()));
        inputCriteriaAnggaran.insertInputPairWiseComparison(1,2,Integer.parseInt(Anggaran23.getText()));*/
        staticVars.matriksBerpasanganAnggaran = EksternalFileCSV.readHalfMatrix(pathMatrixAnggaran.getText().toString());
        // Pindah ke pemrosesan layar berikutnya
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("input_matriks_kontraktor_random.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleChooseMatrixAdministrasi(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih File Matrix Administrasi");
        fileChooser.setInitialDirectory(new File("data"));
        File file = fileChooser.showOpenDialog(staticVars.currentStage);
        if(file != null){
            pathMatrixAdministrasi.setText(file.toString());
        }
    }

    public void handleChooseMatrixTeknis(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih File Matrix Teknis");
        fileChooser.setInitialDirectory(new File("data"));
        File file = fileChooser.showOpenDialog(staticVars.currentStage);
        if(file != null){
            pathMatrixTeknis.setText(file.toString());
        }
    }

    public void handleChooseMatrixAnggaran(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih File Matrix Anggaran");
        fileChooser.setInitialDirectory(new File("data"));
        File file = fileChooser.showOpenDialog(staticVars.currentStage);
        if(file != null){
            pathMatrixAnggaran.setText(file.toString());
        }
    }
}
