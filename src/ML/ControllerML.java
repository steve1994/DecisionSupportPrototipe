package ML;

import ML.Model.oneRecordKriteria;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instances;

import java.util.ArrayList;

/**
 * Created by steve on 21/11/2015.
 */
public class ControllerML {
    private ArrayList<oneRecordKriteria> listRawRecordsContractor;
    private Instances listRecordsArffForAdministrasi;
    private Instances listRecordsArffForTeknis;
    private Instances listRecordsArffForAnggaran;

    public ControllerML() {
        listRawRecordsContractor = new ArrayList<oneRecordKriteria>();
    }

    public void insertNewRecordContractor(oneRecordKriteria contractorRecord) {
        listRawRecordsContractor.add(contractorRecord);
    }

    /**
     * Konfigurasi attribut pada dataset masing-masing instance 3 kriteria
     */
    public void configArffInstancesEachCriteria() {
        // Subkriteria ADMINISTRASI
        Attribute subKriteriaAdministrasi1 = new Attribute("adm1");
        Attribute subKriteriaAdministrasi2 = new Attribute("adm2");
        Attribute subKriteriaAdministrasi3 = new Attribute("adm3");
        Attribute subKriteriaAdministrasi4 = new Attribute("adm4");
        Attribute subKriteriaAdministrasi5 = new Attribute("adm5");
        Attribute subKriteriaAdministrasi6 = new Attribute("adm6");
        Attribute subKriteriaAdministrasi7 = new Attribute("adm7");
        Attribute subKriteriaAdministrasi8 = new Attribute("adm8");
        FastVector attributesInstanceAdministrasi = new FastVector();
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi1);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi2);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi3);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi4);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi5);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi6);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi7);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi8);
        listRecordsArffForAdministrasi = new Instances("Administrasi Dataset",attributesInstanceAdministrasi,0);
        // Subkriteria TEKNIS
        Attribute subKriteriaTeknis1 = new Attribute("tek1");
        Attribute subKriteriaTeknis2 = new Attribute("tek2");
        Attribute subKriteriaTeknis3 = new Attribute("tek3");
        Attribute subKriteriaTeknis4 = new Attribute("tek4");
        Attribute subKriteriaTeknis5 = new Attribute("tek5");
        Attribute subKriteriaTeknis6 = new Attribute("tek6");
        FastVector attributesInstanceTeknis = new FastVector();
        attributesInstanceTeknis.addElement(subKriteriaTeknis1);
        attributesInstanceTeknis.addElement(subKriteriaTeknis2);
        attributesInstanceTeknis.addElement(subKriteriaTeknis3);
        attributesInstanceTeknis.addElement(subKriteriaTeknis4);
        attributesInstanceTeknis.addElement(subKriteriaTeknis5);
        attributesInstanceTeknis.addElement(subKriteriaTeknis6);
        listRecordsArffForTeknis = new Instances("Teknis Dataset",attributesInstanceTeknis,0);
        // Subkriteria ANGGARAN
        Attribute subKriteriaAnggaran1 = new Attribute("ang1");
        Attribute subKriteriaAnggaran2 = new Attribute("ang2");
        Attribute subKriteriaAnggaran3 = new Attribute("ang3");
        FastVector attributesInstanceAnggaran = new FastVector();
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran1);
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran2);
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran3);
        listRecordsArffForAnggaran = new Instances("Anggaran Dataset",attributesInstanceAnggaran,0);
    }

    public void loadArffFromRawRecords() {
        for (oneRecordKriteria criteria : listRawRecordsContractor) {
            ArrayList<Integer> listAttributesAdministrasiScore = criteria.getListScoringKriteriaAdministrasi();
            ArrayList<Integer> listAttributesTeknisScore = criteria.getListScoringKriteriaTeknis();
            ArrayList<Integer> listAttributesAnggaranScore = criteria.getListScoringKriteriaAnggaran();
        }
    }
}
