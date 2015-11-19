package AHP.Utils;

/**
 * Created by steve on 19/11/2015.
 */
public class MatrixOperation {
    public static double[] computeSumWeightEachColumn(double[][] criteriaMatrixDependence,int columnSize,int rowSize) {
        double[] sumWeightEachColumn = new double[columnSize];
        for (int i=0;i<columnSize;i++) {
            double sumWeightThisColumn = 0.0;
            for (int j=0;j<rowSize;j++) {
                sumWeightEachColumn[i] += criteriaMatrixDependence[j][i];
            }
        }
        return sumWeightEachColumn;
    }

    public static double[][] computeMatrixNormalization(double[][] criteriaMatrixDependence,int columnSize,int rowSize) {
        double[][] normalizeMatrix = new double[][]
    }
}
