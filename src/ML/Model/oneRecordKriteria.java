package ML.Model;

import java.util.ArrayList;

/**
 * Created by steve on 21/11/2015.
 */
public class oneRecordKriteria {
    /**
     * 8 Buah Kriteria terkait Administrasi
     */
    private ArrayList<String> listScoringKriteriaAdministrasi;
    /**
     * 6 Buah Kriteria terkait Teknis
     */
    private ArrayList<String> listScoringKriteriaTeknis;
    /**
     * 3 Buah Kriteria terkait Anggaran
     */
    private ArrayList<Integer> listScoringKriteriaAnggaran;

    /**
     * GETTER DAN SETTER
     */

    public ArrayList<String> getListScoringKriteriaAdministrasi() {
        return listScoringKriteriaAdministrasi;
    }

    public void setListScoringKriteriaAdministrasi(ArrayList<String> listScoringKriteriaAdministrasi) {
        this.listScoringKriteriaAdministrasi = listScoringKriteriaAdministrasi;
    }

    public ArrayList<Integer> getListScoringKriteriaAnggaran() {
        return listScoringKriteriaAnggaran;
    }

    public void setListScoringKriteriaAnggaran(ArrayList<Integer> listScoringKriteriaAnggaran) {
        this.listScoringKriteriaAnggaran = listScoringKriteriaAnggaran;
    }

    public ArrayList<String> getListScoringKriteriaTeknis() {
        return listScoringKriteriaTeknis;
    }

    public void setListScoringKriteriaTeknis(ArrayList<String> listScoringKriteriaTeknis) {
        this.listScoringKriteriaTeknis = listScoringKriteriaTeknis;
    }

    /**
     * Constructor 1 (default)
     */
    public oneRecordKriteria() {
        listScoringKriteriaAdministrasi = new ArrayList<String>();
        listScoringKriteriaAnggaran = new ArrayList<Integer>();
        listScoringKriteriaTeknis = new ArrayList<String>();
    }

    /**
     * Constructor 2
     * @param administrasiKriteria
     * @param teknisKriteria
     * @param anggaranKriteria
     */
    public oneRecordKriteria(ArrayList<String> administrasiKriteria, ArrayList<String> teknisKriteria, ArrayList<Integer> anggaranKriteria) {
        listScoringKriteriaAdministrasi = administrasiKriteria;
        listScoringKriteriaTeknis = teknisKriteria;
        listScoringKriteriaAnggaran = anggaranKriteria;
    }

    // INSERT LIST SCORING EACH CRITERIA

    /**
     * Insert scoring about administrasi criteria sebanyak 8 buah subkriteria
     * @param sub1
     * @param sub2
     * @param sub3
     * @param sub4
     * @param sub5
     * @param sub6
     * @param sub7
     * @param sub8
     */
    public void insertAdministrasiScore(String sub1, String sub2, String sub3, String sub4, String sub5, String sub6, String sub7, String sub8) {
        listScoringKriteriaAdministrasi.add(sub1);
        listScoringKriteriaAdministrasi.add(sub2);
        listScoringKriteriaAdministrasi.add(sub3);
        listScoringKriteriaAdministrasi.add(sub4);
        listScoringKriteriaAdministrasi.add(sub5);
        listScoringKriteriaAdministrasi.add(sub6);
        listScoringKriteriaAdministrasi.add(sub7);
        listScoringKriteriaAdministrasi.add(sub8);
    }

    /**
     * Insert scoring about teknis criteria sebanyak 6 buah subkriteria
     * @param sub1
     * @param sub2
     * @param sub3
     * @param sub4
     * @param sub5
     * @param sub6
     */
    public void insertTeknisScore(String sub1, String sub2, String sub3, String sub4, String sub5, String sub6) {
        listScoringKriteriaTeknis.add(sub1);
        listScoringKriteriaTeknis.add(sub2);
        listScoringKriteriaTeknis.add(sub3);
        listScoringKriteriaTeknis.add(sub4);
        listScoringKriteriaTeknis.add(sub5);
        listScoringKriteriaTeknis.add(sub6);
    }

    /**
     * Insert scoring about anggaran criteria sebanyak 3 buah subkriteria
     * @param sub1
     * @param sub2
     * @param sub3
     */
    public void insertAnggaranScore(int sub1, int sub2, int sub3) {
        listScoringKriteriaAnggaran.add(sub1);
        listScoringKriteriaAnggaran.add(sub2);
        listScoringKriteriaAnggaran.add(sub3);
    }
}
