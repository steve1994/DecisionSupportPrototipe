package AHP;

import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import AHP.Utils.MatrixOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 20/11/2015.
 */
public class ControllerTeknis {
    private ArrayList<double[]> contractorTeknisEigenVector;
    private ArrayList<double[][]> matriksBerpasanganSubKriteriaTeknis;
    private double[] subCriteriaTeknisEigenVector;
    private double[][] matriksBerpasanganTeknis;

    /**
     * Default Konstruktor
     */
    public ControllerTeknis() {
        contractorTeknisEigenVector = new ArrayList<double[]>();
        matriksBerpasanganSubKriteriaTeknis = new ArrayList<double[][]>();
        subCriteriaTeknisEigenVector = new double[6];
        matriksBerpasanganTeknis = new double[6][6];
    }

    /**
     * FUNGSI UNTUK MENG-ASSIGN INPUT DARI USER
     */

    /**
     * Masukkan input pairwise comparison antarsubkriteria
     * ke matriks berpasangan kriteria TEKNIS
     * @param listPairwiseComparison
     */
    public void setMatriksBerpasanganTeknis(HashMap<Integer,HashMap<Integer,Integer>> listPairwiseComparison) {
        // Isi nol semua elemen matriks
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++) {
                if (i == j) {
                    matriksBerpasanganTeknis[i][j] = 1.0;
                } else {
                    matriksBerpasanganTeknis[i][j] = 0.0;
                }
            }
        }
        // Isi segitiga atas matriks
        for (Map.Entry m : listPairwiseComparison.entrySet()) {
            int indexBaris = (Integer) m.getKey();
            HashMap<Integer,Integer> relation = (HashMap<Integer,Integer>) m.getValue();
            for (Map.Entry n : relation.entrySet()) {
                int indexKolom = (Integer) n.getKey();
                int pairWiseValue = (Integer) n.getValue();
                matriksBerpasanganTeknis[indexBaris-1][indexKolom-1] = pairWiseValue;
            }
        }
        // Isi matriks sisa
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++) {
                if (matriksBerpasanganTeknis[i][j] == 0.0) {
                    matriksBerpasanganTeknis[i][j] = 1.0 / (double) matriksBerpasanganTeknis[j][i];
                }
            }
        }
    }

    /**
     * Masukkan matriks pairwise comparison antarsubkriteria
     * ke matriks berpasangan kontraktor terkait subkriteria dengan index tertentu
     * @param listPairwiseComparison
     * @param indexSubcriteria : 1-6 (lihat KriteriaGrafTeknis)
     */
    public void setMatriksBerpasanganSubcriteria(HashMap<Integer,HashMap<Integer,Integer>> listPairwiseComparison, int indexSubcriteria) {
        // Asumsi jumlah kontraktor 6
        double[][] pairwiseMatrixForSubcriteria = new double[6][6];
        // Isi nol semua elemen matriks
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++) {
                if (i == j) {
                    pairwiseMatrixForSubcriteria[i][j] = 1.0;
                } else {
                    pairwiseMatrixForSubcriteria[i][j] = 0.0;
                }
            }
        }
        // Isi segitiga atas matriks
        for (Map.Entry m : listPairwiseComparison.entrySet()) {
            int indexBaris = (Integer) m.getKey();
            HashMap<Integer,Integer> relation = (HashMap<Integer,Integer>) m.getValue();
            for (Map.Entry n : relation.entrySet()) {
                int indexKolom = (Integer) n.getKey();
                int pairWiseValue = (Integer) n.getValue();
                pairwiseMatrixForSubcriteria[indexBaris-1][indexKolom-1] = pairWiseValue;
            }
        }
        // Isi matriks sisa
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++) {
                if (pairwiseMatrixForSubcriteria[i][j] == 0.0) {
                    pairwiseMatrixForSubcriteria[i][j] = 1.0 / (double) pairwiseMatrixForSubcriteria[j][i];
                }
            }
        }
        matriksBerpasanganSubKriteriaTeknis.add(indexSubcriteria - 1, pairwiseMatrixForSubcriteria);
    }

    /**
     * FUNGSI UNTUK MENG-HITUNG PRIORITIZED VECTOR PER CRITERIA
     */

    /**
     * Compute Final Eigen Vector for subcriteria TEKNIS
     */
    public void computeFinalEigenVectorTeknis() {
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasanganTeknis, 6, 6);
        // Inisialisasi eigen vector awal
        double[] thisIterationEigenVector = new double[6];
        for (int i=0;i<6;i++) {
            thisIterationEigenVector[i] = 0.0;
        }
        // Hitung eigen vector final
        subCriteriaTeknisEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(subCriteriaTeknisEigenVector,thisIterationEigenVector,6)) {
            thisIterationEigenVector = subCriteriaTeknisEigenVector;
            squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,6,6);
            subCriteriaTeknisEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        }
    }

    /**
     * Compute Final Eigen Vector for subcriteria under criteria TEKNIS
     * @param indexSubcriteria : 1-6 (lihat KriteriaGrafTeknis)
     */
    public void computeFinalEigenVectorSubcriteria(int indexSubcriteria) {
        double[][] matriksBerpasangan = matriksBerpasanganSubKriteriaTeknis.get(indexSubcriteria-1);
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasangan,6,6);
        // Inisialisasi eigen vector awal
        double[] thisIterationEigenVector = new double[6];
        for (int i=0;i<6;i++) {
            thisIterationEigenVector[i] = 0.0;
        }
        // Hitung eigen vector final
        double[] nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(nextIterationEigenVector,thisIterationEigenVector,6)) {
            thisIterationEigenVector = nextIterationEigenVector;
            squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,6,6);
            nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        }
        contractorTeknisEigenVector.add(indexSubcriteria-1,nextIterationEigenVector);
    }
}
