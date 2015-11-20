package CPI;

import AHP.Utils.MatrixOperation;

/**
 * Created by steve on 20/11/2015.
 */
public class Controller {
    /**
     * Baris : Jumlah kontraktor (6 buah)
     * Kolom : Jumlah kriteria dipakai (3 buah)
     */
    private double[][] finalPrioritizedVectorEachCriteria;

    /**
     * Jumlah elemen 3 buah (dipakai 3 kriteria)
     */
    private double[] weightEachCriteria;

    /**
     * Konstruktor
     */
    public Controller() {
        finalPrioritizedVectorEachCriteria = new double[6][3];
        weightEachCriteria = new double[3];
    }

    public void insertOneCriteriaPrioritizedVector(int indexSubcriteria, double[] prioritizedVectorThisCriteria) {
        for (int i=0;i<6;i++) {
            finalPrioritizedVectorEachCriteria[i][indexSubcriteria] = prioritizedVectorThisCriteria[i];
        }
    }
}
