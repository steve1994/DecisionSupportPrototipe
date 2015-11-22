package sample.state;

import AHP.Controller.ControllerAdministrasi;
import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import ML.Controller.ControllerML;
import ML.Model.oneRecordKriteria;
import javafx.stage.Stage;
import model.InputPairWiseComparison;
import model.ListContractor;

import java.util.ArrayList;

/**
 * Created by steve on 21/11/2015.
 */
public class staticVars {
    public static Stage currentStage;
    public static int modelModeSelected; // 1 : AHP, 2 : Clustering
    public static ListContractor listInputContractor;
    public static InputPairWiseComparison matriksBerpasanganAdministrasi;
    public static InputPairWiseComparison matriksBerpasanganTeknis;
    public static InputPairWiseComparison matriksBerpasanganAnggaran;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAdministrasi;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaTeknis;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAnggaran;
    public static ControllerML clusteringProcessor = new ControllerML();
    public static oneRecordKriteria recordKontraktor1 = new oneRecordKriteria();
    public static oneRecordKriteria recordKontraktor2 = new oneRecordKriteria();
    public static oneRecordKriteria recordKontraktor3= new oneRecordKriteria();
    public static oneRecordKriteria recordKontraktor4 = new oneRecordKriteria();
    public static oneRecordKriteria recordKontraktor5 = new oneRecordKriteria();
    public static oneRecordKriteria recordKontraktor6 = new oneRecordKriteria();
}
