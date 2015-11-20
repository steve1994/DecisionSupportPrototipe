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
public class Controller {
    private KriteriaGrafAdministrasi clusterKriteriaAdministrasi;
    private KriteriaGrafAnggaran clusterKriteriaAnggaran;
    private KriteriaGrafTeknis clusterKriteriaTeknis;
    private ArrayList<Double[]> contractorAdministrasiEigenVector;
    private ArrayList<Double[]> contractorAnggaranEigenVector;
    private ArrayList<Double[]> contractorTeknisEigenVector;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaAdministrasi;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaAnggaran;
    private ArrayList<Double[][]> matriksBerpasanganSubKriteriaTeknis;
    private double[] subCriteriaAdministrasiEigenVector;
    private double[] subCriteriaAnggaranEigenVector;
    private double[] subCriteriaTeknisEigenVector;
    private double[][] matriksBerpasanganAdministrasi;
    private double[][] matriksBerpasanganAnggaran;
    private double[][] matriksBerpasanganTeknis;

    /**
     * Default Konstruktor
     */
    public Controller() {
        clusterKriteriaAdministrasi = new KriteriaGrafAdministrasi();
        clusterKriteriaAnggaran = new KriteriaGrafAnggaran();
        clusterKriteriaTeknis = new KriteriaGrafTeknis();
        contractorAdministrasiEigenVector = new ArrayList<Double[]>();
        contractorAnggaranEigenVector = new ArrayList<Double[]>();
        contractorTeknisEigenVector = new ArrayList<Double[]>();
        matriksBerpasanganSubKriteriaAdministrasi = new ArrayList<Double[][]>();
        matriksBerpasanganSubKriteriaAnggaran = new ArrayList<Double[][]>();
        matriksBerpasanganSubKriteriaTeknis = new ArrayList<Double[][]>();
        subCriteriaAdministrasiEigenVector = new double[8];
        subCriteriaAnggaranEigenVector = new double[3];
        subCriteriaTeknisEigenVector = new double[6];
        matriksBerpasanganAdministrasi = new double[8][8];
        matriksBerpasanganAnggaran = new double[3][3];
        matriksBerpasanganTeknis = new double[6][6];
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

    /**
     * Compute Final Eigen Vector for subcriteria ANGGARAN
     */
    public void computeFinalEigenVectorAnggaran() {
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasanganAnggaran,3,3);
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

    /**
     * Compute Final Eigen Vector for subcriteria TEKNIS
     */
    public void computeFinalEigenVectorTeknis() {
        // Kuadratkan matriks berpasangan untuk kriteria administrasi
        double[][] squaredMatrixThisIteration = MatrixOperation.computeMatrixSquare(matriksBerpasanganTeknis,6,6);
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
