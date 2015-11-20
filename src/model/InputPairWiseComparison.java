package model;

import java.util.HashMap;

/**
 * Created by steve on 20/11/2015.
 */
public class InputPairWiseComparison {
    private HashMap<Integer,HashMap<Integer,Double>> listPairwiseComparison;

    public HashMap<Integer, HashMap<Integer, Double>> getListPairwiseComparison() {
        return listPairwiseComparison;
    }

    public InputPairWiseComparison() {
        listPairwiseComparison = new HashMap<Integer, HashMap<Integer,Double>>();
    }

    public void insertInputPairWiseComparison(int indexBaris, int indexKolom, double PairValue) {
        HashMap<Integer,Double> relation = new HashMap<Integer, Double>();
        relation.put(indexKolom,PairValue);
        listPairwiseComparison.put(indexBaris,relation);
    }
}
