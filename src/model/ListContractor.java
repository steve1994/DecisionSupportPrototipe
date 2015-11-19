package model;

import java.util.ArrayList;

/**
 * Created by steve on 19/11/2015.
 */
public class ListContractor {
    ArrayList<Contractor> listContractorInDSS;
    int numContractor;

    // GETTER dan SETTER
    public ArrayList<Contractor> getListContractorInDSS() {
        return listContractorInDSS;
    }

    public void setListContractorInDSS(ArrayList<Contractor> listContractorInDSS) {
        this.listContractorInDSS = listContractorInDSS;
    }

    public int getNumContractor() {
        return numContractor;
    }

    public void setNumContractor(int numContractor) {
        this.numContractor = numContractor;
    }

    // KONSTRUKTOR 1
    public ListContractor() {
        numContractor = 0;
        listContractorInDSS = new ArrayList<Contractor>();
    }

    // INSERT NEW CONTRACTOR
    public void insertNewContractor(Contractor newContractor) {
        numContractor++;
        listContractorInDSS.add(newContractor);
    }
}
