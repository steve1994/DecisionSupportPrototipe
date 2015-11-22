package sample;

import AHP.Controller.ControllerAdministrasi;
import AHP.Controller.ControllerAnggaran;
import AHP.Controller.ControllerTeknis;
import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.InputPairWiseComparison;
import sample.state.staticVars;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

/**
 * Created by steve on 22/11/2015.
 */
public class layarHasilAHPController implements Initializable{
    @FXML private Label ranking1Administrasi = new Label();
    @FXML private Label ranking2Administrasi = new Label();
    @FXML private Label ranking3Administrasi = new Label();
    @FXML private Label ranking4Administrasi = new Label();
    @FXML private Label ranking5Administrasi = new Label();
    @FXML private Label ranking6Administrasi = new Label();
    @FXML private Label ranking1Teknis = new Label();
    @FXML private Label ranking2Teknis = new Label();
    @FXML private Label ranking3Teknis = new Label();
    @FXML private Label ranking4Teknis = new Label();
    @FXML private Label ranking5Teknis = new Label();
    @FXML private Label ranking6Teknis = new Label();
    @FXML private Label ranking1Anggaran = new Label();
    @FXML private Label ranking2Anggaran = new Label();
    @FXML private Label ranking3Anggaran = new Label();
    @FXML private Label ranking4Anggaran = new Label();
    @FXML private Label ranking5Anggaran = new Label();
    @FXML private Label ranking6Anggaran = new Label();

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
        // GET INPUT FROM USER
        InputPairWiseComparison matriksBerpasanganAdministrasi = staticVars.matriksBerpasanganAdministrasi;
        InputPairWiseComparison matriksBerpasanganTeknis = staticVars.matriksBerpasanganTeknis;
        InputPairWiseComparison matriksBerpasanganAnggaran = staticVars.matriksBerpasanganAnggaran;
        ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAdministrasi = staticVars.matriksBerpasanganSubkriteriaAdministrasi;
        ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaTeknis = staticVars.matriksBerpasanganSubkriteriaTeknis;
        ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAnggaran = staticVars.matriksBerpasanganSubkriteriaAnggaran;

        /**
         * ANALYTICAL HIERARCHICAL PROCESSING EACH CRITERIA
         */

        // ADMINISTRASI
        ControllerAdministrasi administrasi = new ControllerAdministrasi();
        administrasi.setMatriksBerpasanganAdministrasi(matriksBerpasanganAdministrasi);
        administrasi.computeFinalEigenVectorAdministrasi();
        for (int i=0;i<8;i++) {
            administrasi.setMatriksBerpasanganSubcriteria(matriksBerpasanganSubkriteriaAdministrasi.get(i),i);
            administrasi.computeFinalEigenVectorSubcriteria(i);
        }
        // TEKNIS
        ControllerTeknis teknis = new ControllerTeknis();
        teknis.setMatriksBerpasanganTeknis(matriksBerpasanganTeknis);
        teknis.computeFinalEigenVectorTeknis();
        for (int i=0;i<6;i++) {
            teknis.setMatriksBerpasanganSubcriteria(matriksBerpasanganSubkriteriaTeknis.get(i),i);
            teknis.computeFinalEigenVectorSubcriteria(i);
        }
        // ANGGARAN
        ControllerAnggaran anggaran = new ControllerAnggaran();
        anggaran.setMatriksBerpasanganAnggaran(matriksBerpasanganAnggaran);
        anggaran.computeFinalEigenVectorAnggaran();
        for (int i=0;i<3;i++) {
            anggaran.setMatriksBerpasanganSubcriteria(matriksBerpasanganSubkriteriaAnggaran.get(i), i);
            anggaran.computeFinalEigenVectorSubcriteria(i);
        }

        /**
         * CARI PRIORITIZED VECTOR AKHIR TIAP KONTRAKTOR (6 BUAH)
         */

        // ADMINISTRASI
        KriteriaGrafAdministrasi evaluasiAdministrasi = new KriteriaGrafAdministrasi();
        for (int i=0;i<administrasi.getSubCriteriaAdministrasiEigenVector().length;i++) {
            evaluasiAdministrasi.insertSubcriteriaEigenValue(i,administrasi.getSubCriteriaAdministrasiEigenVector()[i]);
            for (int j=0;j<administrasi.getContractorAdministrasiEigenVector().size();j++) {
                evaluasiAdministrasi.insertSubcriteriaValueContractor(i,administrasi.getContractorAdministrasiEigenVector().get(j));
            }
        }
        double[] finalPrioritizedAdministrasi = evaluasiAdministrasi.computeEigenValueEachContractor();
        // TEKNIS
        KriteriaGrafTeknis evaluasiTeknis = new KriteriaGrafTeknis();
        for (int i=0;i<teknis.getSubCriteriaAdministrasiEigenVector().length;i++) {
            evaluasiTeknis.insertSubcriteriaEigenValue(i,teknis.getSubCriteriaAdministrasiEigenVector()[i]);
            for (int j=0;j<teknis.getContractorAdministrasiEigenVector().size();j++) {
                evaluasiTeknis.insertSubcriteriaValueContractor(i,teknis.getContractorAdministrasiEigenVector().get(j));
            }
        }
        double[] finalPrioritizedTeknis = evaluasiTeknis.computeEigenValueEachContractor();
        // ANGGARAN
        KriteriaGrafAnggaran evaluasiAnggaran = new KriteriaGrafAnggaran();
        for (int i=0;i<anggaran.getSubCriteriaAdministrasiEigenVector().length;i++) {
            evaluasiAnggaran.insertSubcriteriaEigenValue(i,anggaran.getSubCriteriaAdministrasiEigenVector()[i]);
            for (int j=0;j<anggaran.getContractorAdministrasiEigenVector().size();j++) {
                evaluasiAnggaran.insertSubcriteriaValueContractor(i,anggaran.getContractorAdministrasiEigenVector().get(j));
            }
        }
        double[] finalPrioritizedAnggaran = evaluasiAnggaran.computeEigenValueEachContractor();

        /**
         * OUTPUT HASIL VECTOR KE LAYAR
         */

        // NAMA KONTRAKTOR
        ArrayList<String> daftarNamaKontraktor = new ArrayList<String>();
        for (int i=0;i<staticVars.listInputContractor.getNumContractor();i++) {
            daftarNamaKontraktor.add(staticVars.listInputContractor.getListContractorInDSS().get(i).getNamaBadanAtauPerorangan());
        }
        // ADMINISTRASI
        for (int i=0;i<6;i++) {
            double scoreThisContractor = finalPrioritizedAdministrasi[i];
            String nameThisContractor = daftarNamaKontraktor.get(i);
            switch (i) {
                case 0 : ranking1Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 1 : ranking2Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 2 : ranking3Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 3 : ranking4Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 4 : ranking5Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 5 : ranking6Administrasi.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
            }
        }
        // TEKNIS
        for (int i=0;i<6;i++) {
            double scoreThisContractor = finalPrioritizedTeknis[i];
            String nameThisContractor = daftarNamaKontraktor.get(i);
            switch (i) {
                case 0 : ranking1Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 1 : ranking2Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 2 : ranking3Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 3 : ranking4Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 4 : ranking5Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 5 : ranking6Teknis.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
            }
        }
        // ANGGARAN
        for (int i=0;i<6;i++) {
            double scoreThisContractor = finalPrioritizedAnggaran[i];
            String nameThisContractor = daftarNamaKontraktor.get(i);
            switch (i) {
                case 0 : ranking1Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 1 : ranking2Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 2 : ranking3Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 3 : ranking4Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 4 : ranking5Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
                case 5 : ranking6Anggaran.setText(nameThisContractor + " (" + scoreThisContractor + ")"); break;
            }
        }
    }
}
