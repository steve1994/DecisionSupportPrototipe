package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Contractor;
import model.ListContractor;
import sample.state.staticVars;

import java.io.IOException;


/**
 * Created by steve on 21/11/2015.
 */
public class inputKontraktorController {
    @FXML private TextField namaKontraktor1 = new TextField();
    @FXML private TextField alamatKontraktor1 = new TextField();
    @FXML private TextField visiKontraktor1 = new TextField();
    @FXML private TextField misiKontraktor1 = new TextField();
    @FXML private TextField namaKontraktor2 = new TextField();
    @FXML private TextField alamatKontraktor2 = new TextField();
    @FXML private TextField visiKontraktor2 = new TextField();
    @FXML private TextField misiKontraktor2 = new TextField();
    @FXML private TextField namaKontraktor3 = new TextField();
    @FXML private TextField alamatKontraktor3 = new TextField();
    @FXML private TextField visiKontraktor3 = new TextField();
    @FXML private TextField misiKontraktor3 = new TextField();
    @FXML private TextField namaKontraktor4 = new TextField();
    @FXML private TextField alamatKontraktor4 = new TextField();
    @FXML private TextField visiKontraktor4 = new TextField();
    @FXML private TextField misiKontraktor4 = new TextField();
    @FXML private TextField namaKontraktor5 = new TextField();
    @FXML private TextField alamatKontraktor5 = new TextField();
    @FXML private TextField visiKontraktor5 = new TextField();
    @FXML private TextField misiKontraktor5 = new TextField();
    @FXML private TextField namaKontraktor6 = new TextField();
    @FXML private TextField alamatKontraktor6 = new TextField();
    @FXML private TextField visiKontraktor6 = new TextField();
    @FXML private TextField misiKontraktor6 = new TextField();

    public void handleContractorInput(ActionEvent actionEvent) {
        // Kontraktor 1
        Contractor contractor1 = new Contractor();
        contractor1.setIndex(0);
        contractor1.setNamaBadanAtauPerorangan(namaKontraktor1.getText());
        contractor1.setAlamatBadanAtauPerorangan(alamatKontraktor1.getText());
        contractor1.setVisiBadanAtauPerorangan(visiKontraktor1.getText());
        contractor1.setMisiBadanAtauPerorangan(misiKontraktor1.getText());
        // Kontraktor 2
        Contractor contractor2 = new Contractor();
        contractor2.setIndex(1);
        contractor2.setNamaBadanAtauPerorangan(namaKontraktor2.getText());
        contractor2.setAlamatBadanAtauPerorangan(alamatKontraktor2.getText());
        contractor2.setVisiBadanAtauPerorangan(visiKontraktor2.getText());
        contractor2.setMisiBadanAtauPerorangan(misiKontraktor2.getText());
        // Kontraktor 3
        Contractor contractor3 = new Contractor();
        contractor3.setIndex(2);
        contractor3.setNamaBadanAtauPerorangan(namaKontraktor3.getText());
        contractor3.setAlamatBadanAtauPerorangan(alamatKontraktor3.getText());
        contractor3.setVisiBadanAtauPerorangan(visiKontraktor3.getText());
        contractor3.setMisiBadanAtauPerorangan(misiKontraktor3.getText());
        // Kontraktor 1
        Contractor contractor4 = new Contractor();
        contractor4.setIndex(3);
        contractor4.setNamaBadanAtauPerorangan(namaKontraktor4.getText());
        contractor4.setAlamatBadanAtauPerorangan(alamatKontraktor4.getText());
        contractor4.setVisiBadanAtauPerorangan(visiKontraktor4.getText());
        contractor4.setMisiBadanAtauPerorangan(misiKontraktor4.getText());
        // Kontraktor 1
        Contractor contractor5 = new Contractor();
        contractor5.setIndex(4);
        contractor5.setNamaBadanAtauPerorangan(namaKontraktor5.getText());
        contractor5.setAlamatBadanAtauPerorangan(alamatKontraktor5.getText());
        contractor5.setVisiBadanAtauPerorangan(visiKontraktor5.getText());
        contractor5.setMisiBadanAtauPerorangan(misiKontraktor5.getText());
        // Kontraktor 1
        Contractor contractor6 = new Contractor();
        contractor6.setIndex(5);
        contractor6.setNamaBadanAtauPerorangan(namaKontraktor6.getText());
        contractor6.setAlamatBadanAtauPerorangan(alamatKontraktor6.getText());
        contractor6.setVisiBadanAtauPerorangan(visiKontraktor6.getText());
        contractor6.setMisiBadanAtauPerorangan(misiKontraktor6.getText());
        // Masukkan ke list of contractor
        ListContractor listContractor = new ListContractor();
        listContractor.insertNewContractor(contractor1);
        listContractor.insertNewContractor(contractor2);
        listContractor.insertNewContractor(contractor3);
        listContractor.insertNewContractor(contractor4);
        listContractor.insertNewContractor(contractor5);
        listContractor.insertNewContractor(contractor6);
        staticVars.listInputContractor = listContractor;
        // Pindah layar berikutnya
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
}
