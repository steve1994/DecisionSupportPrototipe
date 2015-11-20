package model;

/**
 * Created by steve on 20/11/2015.
 */
public class PairwiseComparisonElement {
    private int baris;
    private int kolom;
    private double valueComparison;

    public int getBaris() {
        return baris;
    }

    public void setBaris(int baris) {
        this.baris = baris;
    }

    public int getKolom() {
        return kolom;
    }

    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public double getValueComparison() {
        return valueComparison;
    }

    public void setValueComparison(double valueComparison) {
        this.valueComparison = valueComparison;
    }
}
