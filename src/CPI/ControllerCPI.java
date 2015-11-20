package CPI;

import AHP.Utils.MatrixOperation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by steve on 20/11/2015.
 */
public class ControllerCPI {
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
    public ControllerCPI() {
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
    public ControllerCPI(double weightCriteria1, double weightCriteria2, double weightCriteria3) {
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

    /**
     * Hitung bobot ranking tiap kriteria yang SUDAH diurutkan
     * @return
     */
    public Double[] getRankingWeightEachContractor() {
        Double[] weightRankingResult = new Double[6];
        for (int i=0;i<6;i++) {
            for (int j=0;j<3;j++) {
                weightRankingResult[i] = finalPrioritizedVectorEachCriteria[i][j] * weightEachCriteria[j];
            }
        }
        Arrays.sort(weightRankingResult, Collections.reverseOrder());
        return weightRankingResult;
    }
}
