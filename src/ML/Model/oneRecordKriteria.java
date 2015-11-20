package ML.Model;

import java.util.ArrayList;

/**
 * Created by steve on 21/11/2015.
 */
public class oneRecordKriteria {
    /**
     * 8 Buah Kriteria terkait Administrasi
     */
    private ArrayList<Integer> listScoringKriteriaAdministrasi;
    /**
     * 6 Buah Kriteria terkait Teknis
     */
    private ArrayList<Integer> listScoringKriteriaTeknis;
    /**
     * 3 Buah Kriteria terkait Anggaran
     */
    private ArrayList<Integer> listScoringKriteriaAnggaran;

    /**
     * GETTER DAN SETTER
     */

    public ArrayList<Integer> getListScoringKriteriaAdministrasi() {
        return listScoringKriteriaAdministrasi;
    }

    public void setListScoringKriteriaAdministrasi(ArrayList<Integer> listScoringKriteriaAdministrasi) {
        this.listScoringKriteriaAdministrasi = listScoringKriteriaAdministrasi;
    }

    public ArrayList<Integer> getListScoringKriteriaAnggaran() {
        return listScoringKriteriaAnggaran;
    }

    public void setListScoringKriteriaAnggaran(ArrayList<Integer> listScoringKriteriaAnggaran) {
        this.listScoringKriteriaAnggaran = listScoringKriteriaAnggaran;
    }

    public ArrayList<Integer> getListScoringKriteriaTeknis() {
        return listScoringKriteriaTeknis;
    }

    public void setListScoringKriteriaTeknis(ArrayList<Integer> listScoringKriteriaTeknis) {
        this.listScoringKriteriaTeknis = listScoringKriteriaTeknis;
    }

    /**
     * Constructor 1 (default)
     */
    public oneRecordKriteria() {
        listScoringKriteriaAdministrasi = new ArrayList<Integer>();
        listScoringKriteriaAnggaran = new ArrayList<Integer>();
        listScoringKriteriaTeknis = new ArrayList<Integer>();
    }

    /**
     * Constructor 2
     * @param administrasiKriteria
     * @param teknisKriteria
     * @param anggaranKriteria
     */
    public oneRecordKriteria(ArrayList<Integer> administrasiKriteria, ArrayList<Integer> teknisKriteria, ArrayList<Integer> anggaranKriteria) {
        listScoringKriteriaAdministrasi = administrasiKriteria;
        listScoringKriteriaTeknis = teknisKriteria;
        listScoringKriteriaAnggaran = anggaranKriteria;
    }
}
