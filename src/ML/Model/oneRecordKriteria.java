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
    public void insertAdministrasiScore(int sub1, int sub2, int sub3, int sub4, int sub5, int sub6, int sub7, int sub8) {
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
    public void insertTeknisScore(int sub1, int sub2, int sub3, int sub4, int sub5, int sub6) {
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
