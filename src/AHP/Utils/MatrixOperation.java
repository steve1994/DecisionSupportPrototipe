package AHP.Utils;

import AHP.Controller.ControllerAdministrasi;
import AHP.Controller.ControllerAnggaran;
import AHP.Controller.ControllerTeknis;
import model.InputPairWiseComparison;

import java.util.Random;

/**
 * Created by steve on 19/11/2015.
 */
public class MatrixOperation {

    /**
     * Hitung jumlah elemen per baris yang sama di matriks
     *
     * @param criteriaMatrixDependence
     * @param columnSize
     * @param rowSize
     * @return
     */
    private static double[] computeSumWeightEachRow(double[][] criteriaMatrixDependence, int columnSize, int rowSize) {
        double[] sumWeightEachRow = new double[columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                sumWeightEachRow[i] += criteriaMatrixDependence[i][j];
            }
        }
        return sumWeightEachRow;
    }

    /**
     * Hitung jumlah elemen di eigen vector
     *
     * @param sumWeightEachRow
     * @param rowSize
     * @return
     */
    private static double computeSumEigenVectorElement(double[] sumWeightEachRow, int rowSize) {
        double sumElementEigenVector = 0.0;
        for (int i = 0; i < rowSize; i++) {
            sumElementEigenVector += sumWeightEachRow[i];
        }
        return sumElementEigenVector;
    }

    /**
     * Hitung eigen vector (untuk setiap matriks kriteria berpasangan)
     *
     * @param squaredMatrix
     * @param columnSize
     * @param rowSize
     * @return
     */
    public static double[] computeEigenVector(double[][] squaredMatrix, int columnSize, int rowSize) {
        double[] eigenVectorFinal = new double[rowSize];
        double[] sumWeightEachRow = computeSumWeightEachRow(squaredMatrix, columnSize, rowSize);
        double sumEigenVector = computeSumEigenVectorElement(sumWeightEachRow, rowSize);
        for (int i = 0; i < rowSize; i++) {
            eigenVectorFinal[i] = sumWeightEachRow[i] / sumEigenVector;
        }
        return eigenVectorFinal;
    }

    /**
     * Hitung selisih 2 eigen vector yang dihasilkan dari setiap iterasi
     *
     * @param eigenVector1
     * @param eigenVector2
     * @param rowSize
     * @return
     */
    private static double[] computeEigenVectorDifference(double[] eigenVector1, double[] eigenVector2, int rowSize) {
        double[] eigenVectorDifference = new double[rowSize];
        for (int i = 0; i < rowSize; i++) {
            eigenVectorDifference[i] = eigenVector1[i] - eigenVector2[i];
        }
        return eigenVectorDifference;
    }

    /**
     * Fungsi untuk mengecek reweighting matriks perbandingan berpasangan dilanjutkan atau tidak
     *
     * @param eigenVector1
     * @param eigenVector2
     * @param rowSize
     * @return
     */
    public static boolean isIterationContinued(double[] eigenVector1, double[] eigenVector2, int rowSize) {
        double[] differenceEigenVector = computeEigenVectorDifference(eigenVector1, eigenVector2, rowSize);
        boolean isIterationContinued = false;
        for (double element : differenceEigenVector) {
            if (element < 0.00f) {
                isIterationContinued = true;
            }
        }
        return isIterationContinued;
    }

    /**
     * Matriks dikuadratkan sebelum dicari eigen vectornya
     * Hasil : Matrix x Matrix
     * @param normalizedMatrix
     * @param columnSize
     * @param rowSize
     * @return
     */
    public static double[][] computeMatrixSquare(double[][] normalizedMatrix, int columnSize, int rowSize) {
        double[][] matrix1 = normalizedMatrix;
        double[][] matrix2 = normalizedMatrix;
        double[][] squaredMatrixResult = new double[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                for (int k = 0; k < columnSize; k++) {
                    squaredMatrixResult[i][j] = squaredMatrixResult[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return squaredMatrixResult;
    }

    /**
     * Hitung perkalian matriks 2D dengan vektor 1D
     * Ukuran kolom matriks 2D = ukuran baris vektor 1D
     * @param matrix
     * @param vector
     * @param rowSize
     * @param columnSize
     * @return
     */
    public static double[] computeMatrixMultiplicationWithVector(double[][] matrix, double[] vector, int rowSize, int columnSize) {
        double[] multiplicationResultVector = new double[rowSize];
        for (int i = 0; i < rowSize; i++) {
            double computationResultThisRow = 0.0;
            for (int j = 0; j < columnSize; j++) {
                computationResultThisRow += matrix[i][j] * vector[j];
            }
            multiplicationResultVector[i] = computationResultThisRow;
        }
        return multiplicationResultVector;
    }

    public static void main(String[] arg) {
        int subCriteriaAdministrasi = 8;
        int subCriteriaAnggaran = 3;
        int subCriteriaTeknis = 6;
        int sumContractor = 6;
        // INPUT USER
        Random random = new Random();
        // ADMINISTRASI
        InputPairWiseComparison inputCriteriaAdministrasi = new InputPairWiseComparison();
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,4,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,5,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,6,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(1,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,4,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,5,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,6,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(2,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,4,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,5,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,6,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(3,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,5,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,6,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(4,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(5,6,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(5,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(5,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(6,7,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(6,8,random.nextInt(9)+1);
        inputCriteriaAdministrasi.insertInputPairWiseComparison(7,8,random.nextInt(9)+1);
        // TEKNIS
        InputPairWiseComparison inputCriteriaTeknis = new InputPairWiseComparison();
        inputCriteriaTeknis.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(1,4,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(1,5,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(1,6,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(2,4,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(2,5,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(2,6,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(3,4,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(3,5,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(3,6,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(4,5,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(4,6,random.nextInt(9)+1);
        inputCriteriaTeknis.insertInputPairWiseComparison(5,6,random.nextInt(9)+1);
        // ANGGARAN
        InputPairWiseComparison inputCriteriaAnggaran = new InputPairWiseComparison();
        inputCriteriaAnggaran.insertInputPairWiseComparison(1,2,random.nextInt(9)+1);
        inputCriteriaAnggaran.insertInputPairWiseComparison(1,3,random.nextInt(9)+1);
        inputCriteriaAnggaran.insertInputPairWiseComparison(2,3,random.nextInt(9)+1);

        // START AHP
        // ADMINISTRASI
        ControllerAdministrasi administrasi = new ControllerAdministrasi();
        administrasi.setMatriksBerpasanganAdministrasi(inputCriteriaAdministrasi);
        administrasi.computeFinalEigenVectorAdministrasi();
        for (int i=1;i<=8;i++) {
            System.out.println("administrasi : " + administrasi.getEigenVectorSubcriteria(i));
        }
        // TEKNIS
        ControllerTeknis teknis = new ControllerTeknis();
        teknis.setMatriksBerpasanganTeknis(inputCriteriaTeknis);
        teknis.computeFinalEigenVectorTeknis();
        for (int i=1;i<=6;i++) {
            System.out.println("teknis : " + teknis.getEigenVectorSubcriteria(i));
        }
        // ANGGARAN
        ControllerAnggaran anggaran = new ControllerAnggaran();
        anggaran.setMatriksBerpasanganAnggaran(inputCriteriaAnggaran);
        anggaran.computeFinalEigenVectorAnggaran();
        for (int i=1;i<=3;i++) {
            System.out.println("anggaran : " + anggaran.getEigenVectorSubcriteria(i));
        }
    }
}


