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
     * Konstruktor 1
     */
    public Controller() {
        finalPrioritizedVectorEachCriteria = new double[6][3];
        weightEachCriteria = new double[3];
        weightEachCriteria[0] = 3.0;
        weightEachCriteria[1] = 2.0;
        weightEachCriteria[2] = 1.0;
    }

    /**
     * Konstruktor 2
     * @param weightCriteria1
     * @param weightCriteria2
     * @param weightCriteria3
     */
    public Controller(double weightCriteria1, double weightCriteria2, double weightCriteria3) {
        finalPrioritizedVectorEachCriteria = new double[6][3];
        weightEachCriteria = new double[3];
        weightEachCriteria[0] = weightCriteria1;
        weightEachCriteria[1] = weightCriteria2;
        weightEachCriteria[2] = weightCriteria3;
    }



    /**
     * Insert one criteria prioritized vector into CPI matrix
     * @param indexSubcriteria
     * @param prioritizedVectorThisCriteria
     */
    public void insertOneCriteriaPrioritizedVector(int indexSubcriteria, double[] prioritizedVectorThisCriteria) {
        for (int i=0;i<6;i++) {
            finalPrioritizedVectorEachCriteria[i][indexSubcriteria] = prioritizedVectorThisCriteria[i];
        }
    }


}
