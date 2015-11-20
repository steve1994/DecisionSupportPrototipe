package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steve on 20/11/2015.
 */
public class InputPairWiseComparison {
    private ArrayList<PairwiseComparisonElement> listPairwiseComparison;

    public ArrayList<PairwiseComparisonElement> getListPairwiseComparison() {
        return listPairwiseComparison;
    }

    public InputPairWiseComparison() {
        listPairwiseComparison = new ArrayList<PairwiseComparisonElement>();
    }

    public void insertInputPairWiseComparison(int indexBaris, int indexKolom, double PairValue) {
        PairwiseComparisonElement comparisonElement = new PairwiseComparisonElement();
        comparisonElement.setBaris(indexBaris);
        comparisonElement.setKolom(indexKolom);
        comparisonElement.setValueComparison(PairValue);
        listPairwiseComparison.add(comparisonElement);
    }

    public static void main(String[] arg) {
        InputPairWiseComparison a = new InputPairWiseComparison();
        a.insertInputPairWiseComparison(1,2,3.0);
        a.insertInputPairWiseComparison(1,3,6.0);
      /*  for (Map.Entry m : a.getListPairwiseComparison().entrySet()) {
            int baris = (Integer) m.getKey();
            HashMap<Integer,Double> relation = (HashMap) m.getValue();
            for (Map.Entry n : relation.entrySet()) {
                int kolom = (Integer) n.getKey();
                double value = (Double) n.getValue();
                System.out.println("Baris : " + baris + ", Kolom : " + kolom + ", value : " + value);
            }
        } */
    }
}
