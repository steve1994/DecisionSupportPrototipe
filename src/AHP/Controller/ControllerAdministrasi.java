package AHP.Controller;

import AHP.Model.KriteriaGrafAdministrasi;
import AHP.Model.KriteriaGrafAnggaran;
import AHP.Model.KriteriaGrafTeknis;
import AHP.Utils.MatrixOperation;
import jdk.internal.util.xml.impl.Input;
import model.InputPairWiseComparison;
import model.PairwiseComparisonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 18/11/2015.
 */
public class ControllerAdministrasi {
    private ArrayList<double[]> contractorAdministrasiEigenVector;
    private ArrayList<double[][]> matriksBerpasanganSubKriteriaAdministrasi;
    private double[] subCriteriaAdministrasiEigenVector;
    private double[][] matriksBerpasanganAdministrasi;

    /**
     * Getter 1
     * @param indexSubcriteria
     * @param indexContractor
     * @return
     */
    public double getEigenVectorContractorThisSubcriteria(int indexSubcriteria, int indexContractor) {
        return contractorAdministrasiEigenVector.get(indexSubcriteria)[indexContractor];
    }

    /**
     * Getter 2
     * @param indexSubcriteria
     * @return
     */
    public double getEigenVectorSubcriteria(int indexSubcriteria) {
        return subCriteriaAdministrasiEigenVector[indexSubcriteria];
    }

    /**
     * Default Konstruktor
     */
    public ControllerAdministrasi() {
        contractorAdministrasiEigenVector = new ArrayList<double[]>();
        matriksBerpasanganSubKriteriaAdministrasi = new ArrayList<double[][]>();
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
    public void setMatriksBerpasanganAdministrasi(InputPairWiseComparison listPairwiseComparison) {
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
        for (PairwiseComparisonElement element : listPairwiseComparison.getListPairwiseComparison()) {
            int indexBaris = element.getBaris();
            int indexKolom = element.getKolom();
            double pairWiseValue = element.getValueComparison();
            matriksBerpasanganAdministrasi[indexBaris][indexKolom] = pairWiseValue;
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
     * Masukkan matriks pairwise comparison antarsubkriteria
     * ke matriks berpasangan kontraktor terkait subkriteria dengan index tertentu
     * @param listPairwiseComparison
     * @param indexSubcriteria : 1-8 (lihat KriteriaGrafAdministrasi)
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
        matriksBerpasanganSubKriteriaAdministrasi.add(indexSubcriteria,pairwiseMatrixForSubcriteria);
    }


    /**
     * FUNGSI UNTUK MENG-HITUNG PRIORITIZED VECTOR PER CRITERIA
     */

    /**
     * Compute Final Eigen Vector for criteria ADMINISTRASI
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
        subCriteriaAdministrasiEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,8,8);
        // Jika eigen vector final belum akurat, lanjutkan iterasi
        while (MatrixOperation.isIterationContinued(subCriteriaAdministrasiEigenVector,thisIterationEigenVector,8)) {
            for (int i=0;i<6;i++) {
                thisIterationEigenVector[i] = subCriteriaAdministrasiEigenVector[i];
            }
            double[][] thisIterationMatrixSquared = MatrixOperation.computeMatrixSquare(squaredMatrixThisIteration,8,8);
            for (int i=0;i<6;i++) {
                for (int j=0;j<6;j++) {
                    squaredMatrixThisIteration[i][j] = thisIterationMatrixSquared[i][j];
                }
            }
            subCriteriaAdministrasiEigenVector = MatrixOperation.computeEigenVector(squaredMatrixThisIteration,8,8);
        }
    }

    /**
     * Compute Final Eigen Vector for subcriteria under criteria ADMINISTRASI
     * @param indexSubcriteria : 1-8 (lihat KriteriaGrafAdministrasi)
     */
    public void computeFinalEigenVectorSubcriteria(int indexSubcriteria) {
        double[][] matriksBerpasangan = matriksBerpasanganSubKriteriaAdministrasi.get(indexSubcriteria);
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
        contractorAdministrasiEigenVector.add(indexSubcriteria,nextIterationEigenVector);
    }
}
