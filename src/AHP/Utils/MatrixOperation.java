package AHP.Utils;

/**
 * Created by steve on 19/11/2015.
 */
public class MatrixOperation {

    /**
     * Hitung jumlah elemen per baris yang sama di matriks
     * @param criteriaMatrixDependence
     * @param columnSize
     * @param rowSize
     * @return
     */
    private static double[] computeSumWeightEachRow(double[][] criteriaMatrixDependence,int columnSize,int rowSize) {
        double[] sumWeightEachRow = new double[columnSize];
        for (int i=0;i<rowSize;i++) {
            for (int j=0;j<columnSize;j++) {
                sumWeightEachRow[i] += criteriaMatrixDependence[i][j];
            }
        }
        return sumWeightEachRow;
    }

    /**
     * Hitung jumlah elemen di eigen vector
     * @param sumWeightEachRow
     * @param rowSize
     * @return
     */
    private static double computeSumEigenVectorElement(double[] sumWeightEachRow,int rowSize) {
        double sumElementEigenVector = 0.0;
        for (int i=0;i<rowSize;i++) {
            sumElementEigenVector += sumWeightEachRow[i];
        }
        return sumElementEigenVector;
    }

    /**
     * Hitung eigen vector (untuk setiap matriks kriteria berpasangan)
     * @param squaredMatrix
     * @param columnSize
     * @param rowSize
     * @return
     */
    public static double[] computeEigenVector(double[][] squaredMatrix, int columnSize, int rowSize) {
        double[] eigenVectorFinal = new double[rowSize];
        double[] sumWeightEachRow = computeSumWeightEachRow(squaredMatrix,columnSize,rowSize);
        double sumEigenVector = computeSumEigenVectorElement(sumWeightEachRow,rowSize);
        for (int i=0;i<rowSize;i++) {
            eigenVectorFinal[i] = sumWeightEachRow[i] / sumEigenVector;
        }
        return eigenVectorFinal;
    }

    /**
     * Hitung selisih 2 eigen vector yang dihasilkan dari setiap iterasi
     * @param eigenVector1
     * @param eigenVector2
     * @param rowSize
     * @return
     */
    private static double[] computeEigenVectorDifference(double[] eigenVector1,double[] eigenVector2,int rowSize) {
        double[] eigenVectorDifference = new double[rowSize];
        for (int i=0;i<rowSize;i++) {
            eigenVectorDifference[i] = eigenVector1[i] - eigenVector2[i];
        }
        return eigenVectorDifference;
    }

    /**
     * Fungsi untuk mengecek reweighting matriks perbandingan berpasangan dilanjutkan atau tidak
     * @param eigenVector1
     * @param eigenVector2
     * @param rowSize
     * @return
     */
    public static boolean isIterationContinued(double[] eigenVector1,double[] eigenVector2,int rowSize) {
        double[] differenceEigenVector = computeEigenVectorDifference(eigenVector1,eigenVector2,rowSize);
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
     * @param normalizedMatrix
     * @param columnSize
     * @param rowSize
     * @return
     */
    public static double[][] computeSquaredMatrix(double[][] normalizedMatrix,int columnSize,int rowSize) {
        double[][] matrix1 = normalizedMatrix;
        double[][] matrix2 = normalizedMatrix;
        double[][] squaredMatrixResult = new double[rowSize][columnSize];
        for (int i=0;i<rowSize;i++) {
            for (int j=0;j<columnSize;j++) {
                for (int k=0;k<columnSize;k++) {
                    squaredMatrixResult[i][j] = squaredMatrixResult[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return squaredMatrixResult;
    }


}
