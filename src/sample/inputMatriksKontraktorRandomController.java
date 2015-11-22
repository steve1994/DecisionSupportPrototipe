package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.InputPairWiseComparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by steve on 22/11/2015.
 */
public class inputMatriksKontraktorRandomController {
    @FXML private Button lihatHasilButton = new Button();

    public void handleRandomizeButton(ActionEvent actionEvent) {
        Random random = new Random();
        // ADMINISTRASI
        ArrayList<InputPairWiseComparison> listEachSubKriteriaAdministrasi = new ArrayList<InputPairWiseComparison>();
        for (int i=0; i<8; i++) {
            InputPairWiseComparison inputSubkriteriaAdministrasi = new InputPairWiseComparison();
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(0,1,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(0,2,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(0,3,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(0,4,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(0,5,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(1,4,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(1,5,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(2,4,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(2,5,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(3,4,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(3,5,random.nextInt(9)+1);
            inputSubkriteriaAdministrasi.insertInputPairWiseComparison(4,5,random.nextInt(9)+1);
            listEachSubKriteriaAdministrasi.add(inputSubkriteriaAdministrasi);
        }
        staticVars.matriksBerpasanganSubkriteriaAdministrasi = listEachSubKriteriaAdministrasi;
        // TEKNIS
        ArrayList<InputPairWiseComparison> listEachSubCriteriaTeknis = new ArrayList<InputPairWiseComparison>();
        for (int i=0;i<6;i++) {
            InputPairWiseComparison inputSubkriteriaTeknis = new InputPairWiseComparison();
            inputSubkriteriaTeknis.insertInputPairWiseComparison(0,1,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(0,2,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(0,3,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(0,4,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(0,5,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(1,4,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(1,5,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(2,4,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(2,5,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(3,4,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(3,5,random.nextInt(9)+1);
            inputSubkriteriaTeknis.insertInputPairWiseComparison(4,5,random.nextInt(9)+1);
            listEachSubCriteriaTeknis.add(inputSubkriteriaTeknis);
        }
        staticVars.matriksBerpasanganSubkriteriaTeknis = listEachSubCriteriaTeknis;
        // ANGGARAN
        ArrayList<InputPairWiseComparison> listEachSubCriteriaAnggaran = new ArrayList<InputPairWiseComparison>();
        for (int i=0;i<3;i++) {
            InputPairWiseComparison inputSubkriteriaAnggaran = new InputPairWiseComparison();
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(0,1,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(0,2,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(0,3,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(0,4,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(0,5,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(1,4,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(1,5,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(2,4,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(2,5,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(3,4,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(3,5,random.nextInt(9)+1);
            inputSubkriteriaAnggaran.insertInputPairWiseComparison(4,5,random.nextInt(9)+1);
            listEachSubCriteriaAnggaran.add(inputSubkriteriaAnggaran);
        }
        staticVars.matriksBerpasanganSubkriteriaAnggaran = listEachSubCriteriaAnggaran;
        // Set visibility tombol lihat hasil
        lihatHasilButton.setVisible(true);
    }

    public void handleBackButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("input_matriks_berpasangan.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleLihatHasilButton(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("layar_hasil_ahp.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }
}
