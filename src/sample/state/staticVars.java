package sample.state;

import AHP.Controller.ControllerAdministrasi;
import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import javafx.stage.Stage;
import model.InputPairWiseComparison;
import model.ListContractor;

import java.util.ArrayList;

/**
 * Created by steve on 21/11/2015.
 */
public class staticVars {
    public static Stage currentStage;
    public static ListContractor listInputContractor;
    public static InputPairWiseComparison matriksBerpasanganAdministrasi;
    public static InputPairWiseComparison matriksBerpasanganTeknis;
    public static InputPairWiseComparison matriksBerpasanganAnggaran;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAdministrasi;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaTeknis;
    public static ArrayList<InputPairWiseComparison> matriksBerpasanganSubkriteriaAnggaran;
    public static ControllerAdministrasi processorAHPAdministrasi;
    public static ControllerAdministrasi processorAHPTeknis;
    public static ControllerAdministrasi processorAHPAnggaran;
    public static KriteriaGrafAdministrasi rankingAHPAdministrasi;
    public static KriteriaGrafTeknis rankingAHPTeknis;
    public static KriteriaGrafAnggaran rankingAHPAnggaran;
}
