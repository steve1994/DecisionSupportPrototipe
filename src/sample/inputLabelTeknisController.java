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
public class inputLabelTeknisController {
    // Label per subkriteria
    final String[] labelSubkriteria1 = new String[] {"tinggi","sedang","kurang"};
    final String[] labelSubkriteria2 = new String[] {"lengkap","tidak lengkap"};
    final String[] labelSubkriteria3 = new String[] {"lengkap","tidak lengkap"};
    final String[] labelSubkriteria4 = new String[] {"pengalaman","tidak pengalaman"};
    final String[] labelSubkriteria5 = new String[] {"borong","tusi"};
    final String[] labelSubkriteria6 = new String[] {"ada","tidak ada"};
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
        staticVars.recordKontraktor1.insertTeknisScore(convertInputToLabel(teknis11.getText(),1),convertInputToLabel(teknis12.getText(),2),convertInputToLabel(teknis13.getText(),3),convertInputToLabel(teknis14.getText(),4),convertInputToLabel(teknis15.getText(),5),convertInputToLabel(teknis16.getText(),6));
        staticVars.recordKontraktor2.insertTeknisScore(convertInputToLabel(teknis21.getText(),1),convertInputToLabel(teknis22.getText(),2),convertInputToLabel(teknis23.getText(),3),convertInputToLabel(teknis24.getText(),4),convertInputToLabel(teknis25.getText(),5),convertInputToLabel(teknis26.getText(),6));
        staticVars.recordKontraktor3.insertTeknisScore(convertInputToLabel(teknis31.getText(),1),convertInputToLabel(teknis32.getText(),2),convertInputToLabel(teknis33.getText(),3),convertInputToLabel(teknis34.getText(),4),convertInputToLabel(teknis35.getText(),5),convertInputToLabel(teknis36.getText(),6));
        staticVars.recordKontraktor4.insertTeknisScore(convertInputToLabel(teknis41.getText(),1),convertInputToLabel(teknis42.getText(),2),convertInputToLabel(teknis43.getText(),3),convertInputToLabel(teknis44.getText(),4),convertInputToLabel(teknis45.getText(),5),convertInputToLabel(teknis46.getText(),6));
        staticVars.recordKontraktor5.insertTeknisScore(convertInputToLabel(teknis51.getText(),1),convertInputToLabel(teknis52.getText(),2),convertInputToLabel(teknis53.getText(),3),convertInputToLabel(teknis54.getText(),4),convertInputToLabel(teknis55.getText(),5),convertInputToLabel(teknis56.getText(),6));
        staticVars.recordKontraktor6.insertTeknisScore(convertInputToLabel(teknis61.getText(),1),convertInputToLabel(teknis62.getText(),2),convertInputToLabel(teknis63.getText(),3),convertInputToLabel(teknis64.getText(),4),convertInputToLabel(teknis65.getText(),5),convertInputToLabel(teknis66.getText(),6));
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

    /**
     * Mengolah input dari textfield ke bentuk string label
     * @param indexLabelSubkriteria : 1-n (tergantung banyak label)
     * @param indexSubkriteria : 1-6 (untuk teknis)
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
        }
        return label;
    }
}
