package AHP.Controller;

import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import AHP.Utils.MatrixOperation;
import model.InputPairWiseComparison;
import model.PairwiseComparisonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 20/11/2015.
 */
public class ControllerAnggaran {
    private ArrayList<double[]> contractorAnggaranEigenVector;
    private ArrayList<double[][]> matriksBerpasanganSubKriteriaAnggaran;
    private double[] subCriteriaAnggaranEigenVector;
    private double[][] matriksBerpasanganAnggaran;

    /**
     * Getter 1
     * @param indexSubcriteria
     * @param indexContractor
     * @return
     */
    public double getEigenVectorContractorThisSubcriteria(int indexSubcriteria, int indexContractor) {
        return contractorAnggaranEigenVector.get(indexSubcriteria)[indexContractor];
    }

    /**
     * Getter 2
     * @param indexSubcriteria
     * @return
     */
    public double getEigenVectorSubcriteria(int indexSubcriteria) {
        return subCriteriaAnggaranEigenVector[indexSubcriteria];
    }

    /**
     * Getter 3
     * @return
     */
    public ArrayList<double[]> getContractorAdministrasiEigenVector() {
        return contractorAnggaranEigenVector;
    }

    /**
     * Getter 4
     * @return
     */
    public double[] getSubCriteriaAdministrasiEigenVector() {
        return subCriteriaAnggaranEigenVector;
    }

    /**
     * Default Konstruktor
     */
    public ControllerAnggaran() {
        contractorAnggaranEigenVector = new ArrayList<double[]>();
        matriksBerpasanganSubKriteriaAnggaran = new ArrayList<double[][]>();
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
    public void setMatriksBerpasanganAnggaran(InputPairWiseComparison listPairwiseComparison) {
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
        for (PairwiseComparisonElement element : listPairwiseComparison.getListPairwiseComparison()) {
            int indexBaris = element.getBaris();
            int indexKolom = element.getKolom();
            double pairWiseValue = element.getValueComparison();
            matriksBerpasanganAnggaran[indexBaris][indexKolom] = pairWiseValue;
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
     * Masukkan matriks pairwise comparison antarsubkriteria
     * ke matriks berpasangan kontraktor terkait subkriteria dengan index tertentu
     * @param listPairwiseComparison
     * @param indexSubcriteria : 1-3 (lihat KriteriaGrafAnggaran)
     */
    public void setMatriksBerpasanganSubcriteria(InputPairWiseComparison listPairwiseComparison, int indexSubcriteria) {
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
        for (PairwiseComparisonElement element : listPairwiseComparison.getListPairwiseComparison()) {
            int indexBaris = element.getBaris();
            int indexKolom = element.getKolom();
            double pairWiseValue = element.getValueComparison();
            pairwiseMatrixForSubcriteria[indexBaris][indexKolom] = pairWiseValue;
        }
        // Isi matriks sisa
        for (int i=0;i<6;i++) {
            for (int j=0;j<6;j++) {
                if (pairwiseMatrixForSubcriteria[i][j] == 0.0) {
                    pairwiseMatrixForSubcriteria[i][j] = 1.0 / (double) pairwiseMatrixForSubcriteria[j][i];
                }
            }
        }
        matriksBerpasanganSubKriteriaAnggaran.add(indexSubcriteria, pairwiseMatrixForSubcriteria);
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
        subCriteriaAnggaranEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,3,3);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(subCriteriaAnggaranEigenVector,thisIterationEigenVector,3)) {
            for (int i=0;i<3;i++) {
                thisIterationEigenVector[i] = subCriteriaAnggaranEigenVector[i];
            }
            double[][] thisIterationMatrixSquared = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,3,3);
            for (int i=0;i<3;i++) {
                for (int j=0;j<3;j++) {
                    squaredMatrixThisIteration[i][j] = thisIterationMatrixSquared[i][j];
                }
            }
            subCriteriaAnggaranEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,3,3);
        }
    }

    /**
     * Compute Final Eigen Vector for subcriteria under criteria ANGGARAN
     * @param indexSubcriteria : 1-3 (lihat KriteriaGrafAnggaran)
     */
    public void computeFinalEigenVectorSubcriteria(int indexSubcriteria) {
        double[][] matriksBerpasangan = matriksBerpasanganSubKriteriaAnggaran.get(indexSubcriteria);
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
            for (int i=0;i<6;i++) {
                thisIterationEigenVector[i] = nextIterationEigenVector[i];
            }
            double[][] thisIterationMatrixSquared = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,6,6);
            for (int i=0;i<6;i++) {
                for (int j=0;j<6;j++) {
                    squaredMatrixThisIteration[i][j] = thisIterationMatrixSquared[i][j];
                }
            }
            nextIterationEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,6,6);
        }
        contractorAnggaranEigenVector.add(indexSubcriteria, nextIterationEigenVector);
    }
}
