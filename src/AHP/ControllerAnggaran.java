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
public class ControllerAnggaran {
    private KriteriaGrafAnggaran clusterKriteriaAnggaran;
    private ArrayList<Double[]> contractorAnggaranEigenVector;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaAnggaran;
    private double[] subCriteriaAnggaranEigenVector;
    private double[][] matriksBerpasanganAnggaran;

    /**
     * Default Konstruktor
     */
    public ControllerAnggaran() {
        clusterKriteriaAnggaran = new KriteriaGrafAnggaran();
        contractorAnggaranEigenVector = new ArrayList<Double[]>();
        matriksBerpasanganSubKriteriaAnggaran = new ArrayList<Double[][]>();
        subCriteriaAnggaranEigenVector = new double[3];
        matriksBerpasanganAnggaran = new double[3][3];
    }

    /**
     * FUNGSI UNTUK MENG-ASSIGN INPUT DARI USER
     */

    /**
     * Masukkan input pairwise comparison antarsubkriteria
     * ke matriks berpasangan kriteria ANGGARAN
     * @param listPairwiseComparison
     */
    public void setMatriksBerpasanganAnggaran(HashMap<Integer,HashMap<Integer,Integer>> listPairwiseComparison) {
        // Isi nol semua elemen matriks
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (i == j) {
                    matriksBerpasanganAnggaran[i][j] = 1.0;
                } else {
                    matriksBerpasanganAnggaran[i][j] = 0.0;
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
                matriksBerpasanganAnggaran[indexBaris-1][indexKolom-1] = pairWiseValue;
            }
        }
        // Isi matriks sisa
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (matriksBerpasanganAnggaran[i][j] == 0.0) {
                    matriksBerpasanganAnggaran[i][j] = 1.0 / (double) matriksBerpasanganAnggaran[j][i];
                }
            }
        }
    }

    /**
     * FUNGSI UNTUK MENG-HITUNG PRIORITIZED VECTOR PER CRITERIA
     */

    /**
     * Compute Final Eigen Vector for subcriteria ANGGARAN
     */
    public void computeFinalEigenVectorAnggaran() {
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasanganAnggaran, 3, 3);
        // Inisialisasi eigen vector awal
        double[] thisIterationEigenVector = new double[8];
        for (int i=0;i<3;i++) {
            thisIterationEigenVector[i] = 0.0;
        }
        // Hitung eigen vector final
        double[] nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,3,3);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(nextIterationEigenVector,thisIterationEigenVector,3)) {
            thisIterationEigenVector = nextIterationEigenVector;
            squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,3,3);
            nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,3,3);
        }
        subCriteriaAnggaranEigenVector = nextIterationEigenVector;
    }
}
