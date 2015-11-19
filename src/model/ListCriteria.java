package model;

import java.util.ArrayList;

/**
 * Created by steve on 19/11/2015.
 */
public class ListCriteria {
    double[] listBobotTiapKriteria;
    private final String kriteria1 = "administrasi";
    private final String kriteria2 = "teknis";
    private final String kriteria3 = "harga";

    /**
     * GETTER Bobot Kriteria 
     * @param indexKriteria
     * @return
     */
    public double getBobotKriteria(int indexKriteria) {
        return listBobotTiapKriteria[indexKriteria-1];
    }

    /**
     * Default Constructor
     */
    public ListCriteria() {
        listBobotTiapKriteria = new double[3];
        listBobotTiapKriteria[0] = 1.0;
        listBobotTiapKriteria[1] = 1.0;
        listBobotTiapKriteria[2] = 1.0;
    }

    /**
     * Second Constructor (with parameter)
     * @param bobotKriteria1
     * @param bobotKriteria2
     * @param bobotKriteria3
     */
    public ListCriteria(double bobotKriteria1,double bobotKriteria2,double bobotKriteria3) {
        listBobotTiapKriteria = new double[3];
        listBobotTiapKriteria[0] = bobotKriteria1;
        listBobotTiapKriteria[1] = bobotKriteria2;
        listBobotTiapKriteria[2] = bobotKriteria3;
    }
}
