package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by steve on 22/11/2015.
 */
public class layarHasilClusteringController implements Initializable {
    @FXML private TextArea hasilClusteringAdministrasi = new TextArea();
    @FXML private TextArea hasilClusteringTeknis = new TextArea();
    @FXML private TextArea hasilClusteringAnggaran = new TextArea();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // INPUT DATA KEENAM KONTRAKTOR DARI KETIGA KRITERIA
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor1);
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor2);
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor3);
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor4);
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor5);
        staticVars.clusteringProcessor.insertNewRecordContractor(staticVars.recordKontraktor6);
        // KONFIG INSTANCE WEKA SEMUA KRITERIA
        staticVars.clusteringProcessor.configArffInstancesEachCriteria();
        // SESUDAH DICONFIG DATA SKOR DILOAD KE INSTANCE WEKA (DATA TERISI DI SINI)
        staticVars.clusteringProcessor.loadArffFromRawRecords();
        // BENTUK CLUSTER K-MEANS TIAP KRITERIA, KELUARKAN HASIL
        String outputAdministrasi = staticVars.clusteringProcessor.outputKmeansClusteringResult(staticVars.clusteringProcessor.getListRecordsArffForAdministrasi());
        String outputTeknis = staticVars.clusteringProcessor.outputKmeansClusteringResult(staticVars.clusteringProcessor.getListRecordsArffForTeknis());
        String outputAnggaran = staticVars.clusteringProcessor.outputKmeansClusteringResult(staticVars.clusteringProcessor.getListRecordsArffForAnggaran());
        hasilClusteringAdministrasi.setText(outputAdministrasi);
        hasilClusteringAnggaran.setText(outputAnggaran);
        hasilClusteringTeknis.setText(outputTeknis);
    }
}
