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
    private KriteriaGrafTeknis clusterKriteriaTeknis;
    private ArrayList<Double[]> contractorTeknisEigenVector;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaTeknis;
    private double[] subCriteriaTeknisEigenVector;
    private double[][] matriksBerpasanganTeknis;

    /**
     * Default Konstruktor
     */
    public ControllerTeknis() {
        clusterKriteriaTeknis = new KriteriaGrafTeknis();
        contractorTeknisEigenVector = new ArrayList<Double[]>();
        matriksBerpasanganSubKriteriaTeknis = new ArrayList<Double[][]>();
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
        double[] nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(nextIterationEigenVector,thisIterationEigenVector,6)) {
            thisIterationEigenVector = nextIterationEigenVector;
            squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,6,6);
            nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        }
        subCriteriaTeknisEigenVector = nextIterationEigenVector;
    }
}
