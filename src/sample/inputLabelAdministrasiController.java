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
    // Label per subkriteria
    final String[] labelSubkriteria1 = new String[] {"lengkap","tidak lengkap"};
    final String[] labelSubkriteria2 = new String[] {"tidak masalah","masalah"};
    final String[] labelSubkriteria3 = new String[] {"ada","tidak ada"};
    final String[] labelSubkriteria4 = new String[] {"stabil","tidak stabil"};
    final String[] labelSubkriteria5 = new String[] {"baik","buruk"};
    final String[] labelSubkriteria6 = new String[] {"relevan","tidak relevan"};
    final String[] labelSubkriteria7 = new String[] {"ada","tidak"};
    final String[] labelSubkriteria8 = new String[] {"ada","tidak"};
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
            root = FXMLLoader.load(getClass().getResource("layar_keterangan_label_clustering.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        staticVars.currentStage = stage;
    }

    public void handleNextButton(ActionEvent actionEvent) {
        // Simpan record terkait administrasi
        staticVars.recordKontraktor1.insertAdministrasiScore(convertInputToLabel(administrasi11.getText(),1),convertInputToLabel(administrasi12.getText(),2),convertInputToLabel(administrasi13.getText(),3),convertInputToLabel(administrasi14.getText(),4),convertInputToLabel(administrasi15.getText(),5),convertInputToLabel(administrasi16.getText(),6),convertInputToLabel(administrasi17.getText(),7),convertInputToLabel(administrasi18.getText(),8));
        staticVars.recordKontraktor2.insertAdministrasiScore(convertInputToLabel(administrasi21.getText(),1),convertInputToLabel(administrasi22.getText(),2),convertInputToLabel(administrasi23.getText(),3),convertInputToLabel(administrasi24.getText(),4),convertInputToLabel(administrasi25.getText(),5),convertInputToLabel(administrasi26.getText(),6),convertInputToLabel(administrasi27.getText(),7),convertInputToLabel(administrasi28.getText(),8));
        staticVars.recordKontraktor3.insertAdministrasiScore(convertInputToLabel(administrasi31.getText(),1),convertInputToLabel(administrasi32.getText(),2),convertInputToLabel(administrasi33.getText(),3),convertInputToLabel(administrasi34.getText(),4),convertInputToLabel(administrasi35.getText(),5),convertInputToLabel(administrasi36.getText(),6),convertInputToLabel(administrasi37.getText(),7),convertInputToLabel(administrasi38.getText(),8));
        staticVars.recordKontraktor4.insertAdministrasiScore(convertInputToLabel(administrasi41.getText(),1),convertInputToLabel(administrasi42.getText(),2),convertInputToLabel(administrasi43.getText(),3),convertInputToLabel(administrasi44.getText(),4),convertInputToLabel(administrasi45.getText(),5),convertInputToLabel(administrasi46.getText(),6),convertInputToLabel(administrasi47.getText(),7),convertInputToLabel(administrasi48.getText(),8));
        staticVars.recordKontraktor5.insertAdministrasiScore(convertInputToLabel(administrasi51.getText(),1),convertInputToLabel(administrasi52.getText(),2),convertInputToLabel(administrasi53.getText(),3),convertInputToLabel(administrasi54.getText(),4),convertInputToLabel(administrasi55.getText(),5),convertInputToLabel(administrasi56.getText(),6),convertInputToLabel(administrasi57.getText(),7),convertInputToLabel(administrasi58.getText(),8));
        staticVars.recordKontraktor6.insertAdministrasiScore(convertInputToLabel(administrasi61.getText(),1),convertInputToLabel(administrasi62.getText(),2),convertInputToLabel(administrasi63.getText(),3),convertInputToLabel(administrasi64.getText(),4),convertInputToLabel(administrasi65.getText(),5),convertInputToLabel(administrasi66.getText(),6),convertInputToLabel(administrasi67.getText(),7),convertInputToLabel(administrasi68.getText(),8));
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

    /**
     * Mengolah input dari textfield ke bentuk string label
     * @param indexLabelSubkriteria : 1-n (tergantung banyak label)
     * @param indexSubkriteria : 1-8 (untuk administrasi)
     * @return
     */
    private String convertInputToLabel(String indexLabelSubkriteria, int indexSubkriteria) {
        int labelSubkriteria = Integer.parseInt(indexLabelSubkriteria) - 1;
        String label = null;
        switch (indexSubkriteria) {
            case 1 : label = labelSubkriteria1[labelSubkriteria]; break;
            case 2 : label = labelSubkriteria2[labelSubkriteria]; break;
            case 3 : label = labelSubkriteria3[labelSubkriteria]; break;
            case 4 : label = labelSubkriteria4[labelSubkriteria]; break;
            case 5 : label = labelSubkriteria5[labelSubkriteria]; break;
            case 6 : label = labelSubkriteria6[labelSubkriteria]; break;
            case 7 : label = labelSubkriteria7[labelSubkriteria]; break;
            case 8 : label = labelSubkriteria8[labelSubkriteria]; break;
        }
        return label;
    }
}
