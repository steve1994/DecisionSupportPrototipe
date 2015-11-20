package AHP;

import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import AHP.Utils.MatrixOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 18/11/2015.
 */
public class ControllerAdministrasi {
    private KriteriaGrafAdministrasi clusterKriteriaAdministrasi;
    private ArrayList<Double[]> contractorAdministrasiEigenVector;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaAdministrasi;
    private double[] subCriteriaAdministrasiEigenVector;
    private double[][] matriksBerpasanganAdministrasi;

    /**
     * Default Konstruktor
     */
    public ControllerAdministrasi() {
        clusterKriteriaAdministrasi = new KriteriaGrafAdministrasi();
        contractorAdministrasiEigenVector = new ArrayList<Double[]>();
        matriksBerpasanganSubKriteriaAdministrasi = new ArrayList<Double[][]>();
        subCriteriaAdministrasiEigenVector = new double[8];
        matriksBerpasanganAdministrasi = new double[8][8];
    }

    /**
     * FUNGSI UNTUK MENG-ASSIGN INPUT DARI USER
     */

    /**
     * Masukkan input pairwise comparison antarsubkriteria
     * ke matriks berpasangan kriteria ADMINISTRASI
     * @param listPairwiseComparison
     */
    public void setMatriksBerpasanganAdministrasi(HashMap<Integer,HashMap<Integer,Integer>> listPairwiseComparison) {
        // Isi nol semua elemen matriks
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (i == j) {
                    matriksBerpasanganAdministrasi[i][j] = 1.0;
                } else {
                    matriksBerpasanganAdministrasi[i][j] = 0.0;
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
                matriksBerpasanganAdministrasi[indexBaris-1][indexKolom-1] = pairWiseValue;
            }
        }
        // Isi matriks sisa
        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (matriksBerpasanganAdministrasi[i][j] == 0.0) {
                    matriksBerpasanganAdministrasi[i][j] = 1.0 / (double) matriksBerpasanganAdministrasi[j][i];
                }
            }
        }
    }

    /**
     * FUNGSI UNTUK MENG-HITUNG PRIORITIZED VECTOR PER CRITERIA
     */

    /**
     * Compute Final Eigen Vector for subcriteria ADMINISTRASI
     */
    public void computeFinalEigenVectorAdministrasi() {
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasanganAdministrasi,8,8);
        // Inisialisasi eigen vector awal
        double[] thisIterationEigenVector = new double[8];
        for (int i=0;i<8;i++) {
            thisIterationEigenVector[i] = 0.0;
        }
        // Hitung eigen vector final
        double[] nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,8,8);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(nextIterationEigenVector,thisIterationEigenVector,8)) {
            thisIterationEigenVector = nextIterationEigenVector;
            squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,8,8);
            nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,8,8);
        }
        subCriteriaAdministrasiEigenVector = nextIterationEigenVector;
    }
}
