package ML.Controller;

import ML.Model.oneRecordKriteria;
import weka.clusterers.EM;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by steve on 21/11/2015.
 */
public class ControllerML {
    private ArrayList<oneRecordKriteria> listRawRecordsContractor;
    private Instances listRecordsArffForAdministrasi;
    private Instances listRecordsArffForTeknis;
    private Instances listRecordsArffForAnggaran;
    private SimpleKMeans simpleClusteringAdministrasi;
    private SimpleKMeans simpleClusteringTeknis;
    private SimpleKMeans simpleClusteringAnggaran;
    private EM EMClusteringAdministrasi;
    private EM EMClusteringTeknis;
    private EM EMClusteringAnggaran;

    // GETTER
    public Instances getListRecordsArffForAdministrasi() {
        return listRecordsArffForAdministrasi;
    }

    public Instances getListRecordsArffForTeknis() {
        return listRecordsArffForTeknis;
    }

    public Instances getListRecordsArffForAnggaran() {
        return listRecordsArffForAnggaran;
    }

    public EM getEMClusteringAdministrasi() {
        return EMClusteringAdministrasi;
    }

    public SimpleKMeans getSimpleClusteringAnggaran() {
        return simpleClusteringAnggaran;
    }

    public SimpleKMeans getSimpleClusteringTeknis() {
        return simpleClusteringTeknis;
    }

    public SimpleKMeans getSimpleClusteringAdministrasi() {
        return simpleClusteringAdministrasi;
    }

    public EM getEMClusteringTeknis() {
        return EMClusteringTeknis;
    }

    public EM getEMClusteringAnggaran() {
        return EMClusteringAnggaran;
    }

    // KONSTRUKTOR
    public ControllerML() {
        listRawRecordsContractor = new ArrayList<oneRecordKriteria>();
    }

    /**
     * Dipakai setiap kali ada kontraktor masuk
     * @param contractorRecord
     */
    public void insertNewRecordContractor(oneRecordKriteria contractorRecord) {
        listRawRecordsContractor.add(contractorRecord);
    }

    /**
     * Konfigurasi attribut pada dataset masing-masing instance 3 kriteria
     */
    public void configArffInstancesEachCriteria() {
        // Subkriteria ADMINISTRASI
        Attribute subKriteriaAdministrasi1 = new Attribute("adm1");
        Attribute subKriteriaAdministrasi2 = new Attribute("adm2");
        Attribute subKriteriaAdministrasi3 = new Attribute("adm3");
        Attribute subKriteriaAdministrasi4 = new Attribute("adm4");
        Attribute subKriteriaAdministrasi5 = new Attribute("adm5");
        Attribute subKriteriaAdministrasi6 = new Attribute("adm6");
        Attribute subKriteriaAdministrasi7 = new Attribute("adm7");
        Attribute subKriteriaAdministrasi8 = new Attribute("adm8");
        FastVector attributesInstanceAdministrasi = new FastVector();
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi1);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi2);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi3);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi4);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi5);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi6);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi7);
        attributesInstanceAdministrasi.addElement(subKriteriaAdministrasi8);
        listRecordsArffForAdministrasi = new Instances("Administrasi Dataset",attributesInstanceAdministrasi,0);
        // Subkriteria TEKNIS
        Attribute subKriteriaTeknis1 = new Attribute("tek1");
        Attribute subKriteriaTeknis2 = new Attribute("tek2");
        Attribute subKriteriaTeknis3 = new Attribute("tek3");
        Attribute subKriteriaTeknis4 = new Attribute("tek4");
        Attribute subKriteriaTeknis5 = new Attribute("tek5");
        Attribute subKriteriaTeknis6 = new Attribute("tek6");
        FastVector attributesInstanceTeknis = new FastVector();
        attributesInstanceTeknis.addElement(subKriteriaTeknis1);
        attributesInstanceTeknis.addElement(subKriteriaTeknis2);
        attributesInstanceTeknis.addElement(subKriteriaTeknis3);
        attributesInstanceTeknis.addElement(subKriteriaTeknis4);
        attributesInstanceTeknis.addElement(subKriteriaTeknis5);
        attributesInstanceTeknis.addElement(subKriteriaTeknis6);
        listRecordsArffForTeknis = new Instances("Teknis Dataset",attributesInstanceTeknis,0);
        // Subkriteria ANGGARAN
        Attribute subKriteriaAnggaran1 = new Attribute("ang1");
        Attribute subKriteriaAnggaran2 = new Attribute("ang2");
        Attribute subKriteriaAnggaran3 = new Attribute("ang3");
        FastVector attributesInstanceAnggaran = new FastVector();
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran1);
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran2);
        attributesInstanceAnggaran.addElement(subKriteriaAnggaran3);
        listRecordsArffForAnggaran = new Instances("Anggaran Dataset",attributesInstanceAnggaran,0);
    }

    /**
     * Fill in instances weka 3 criteria
     * Asumsi : instances 3 kriteria sudah diconfig sebelumnya
     */
    public void loadArffFromRawRecords() {
        for (oneRecordKriteria criteria : listRawRecordsContractor) {
            // ADMINISTRASI
            ArrayList<Integer> listAttributesAdministrasiScore = criteria.getListScoringKriteriaAdministrasi();
            double[] valuesAdministrasi = new double[listRecordsArffForAdministrasi.numAttributes()];
            for (int i=0;i<valuesAdministrasi.length;i++) {
                valuesAdministrasi[i] = listAttributesAdministrasiScore.get(i);
            }
            Instance administrasi = new Instance(1.0,valuesAdministrasi);
            listRecordsArffForAdministrasi.add(administrasi);
            // TEKNIS
            ArrayList<Integer> listAttributesTeknisScore = criteria.getListScoringKriteriaTeknis();
            double[] valuesTeknis = new double[listRecordsArffForTeknis.numAttributes()];
            for (int i=0;i<valuesTeknis.length;i++) {
                valuesTeknis[i] = listAttributesTeknisScore.get(i);
            }
            Instance teknis = new Instance(1.0,valuesTeknis);
            listRecordsArffForTeknis.add(teknis);
            // ANGGARAN
            ArrayList<Integer> listAttributesAnggaranScore = criteria.getListScoringKriteriaAnggaran();
            double[] valuesAnggaran = new double[listRecordsArffForAnggaran.numAttributes()];
            for (int i=0;i<valuesAnggaran.length;i++) {
                valuesAnggaran[i] = listAttributesAnggaranScore.get(i);
            }
            Instance anggaran = new Instance(1.0,valuesAnggaran);
            listRecordsArffForAnggaran.add(anggaran);
        }
    }

    /**
     * Harus digunakan sesaat sebelum proses pembangunan cluster
     * Asumsi : jumlah cluster 3 buah
     */
    private void configKMeansClustererEachCriteria() {
        // Administrasi
        simpleClusteringAdministrasi = new SimpleKMeans();
       // simpleClusteringAdministrasi.setSeed(5);
        simpleClusteringAdministrasi.setPreserveInstancesOrder(true);
        try {
            simpleClusteringAdministrasi.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Teknis
        simpleClusteringAnggaran = new SimpleKMeans();
       // simpleClusteringAnggaran.setSeed(5);
        simpleClusteringAnggaran.setPreserveInstancesOrder(true);
        try {
            simpleClusteringAnggaran.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Anggaran
        simpleClusteringTeknis = new SimpleKMeans();
       // simpleClusteringTeknis.setSeed(5);
        simpleClusteringTeknis.setPreserveInstancesOrder(true);
        try {
            simpleClusteringTeknis.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Harus dipanggil saat sebelum proses build cluster dilakukan
     * Asumsi : jumlah cluster 3 buah, iterasi maximum 5 kali
     */
    private void configEMClustererEachCriteria() {
        // Administrasi
        EMClusteringAdministrasi = new EM();
        EMClusteringAdministrasi.setSeed(3);
        try {
            EMClusteringAdministrasi.setMaxIterations(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EMClusteringAdministrasi.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Teknis
        EMClusteringTeknis = new EM();
        EMClusteringTeknis.setSeed(3);
        try {
            EMClusteringTeknis.setMaxIterations(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EMClusteringTeknis.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Anggaran
        EMClusteringAnggaran = new EM();
        EMClusteringAnggaran.setSeed(3);
        try {
            EMClusteringAnggaran.setMaxIterations(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            EMClusteringAnggaran.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Do clustering instances based on criteria and clustering type
     * @param indexCriteria : 0 (Administrasi), 1 (Teknis), 2 (Anggaran)
     * @param clusteringType : 1 (K-means), 2 (EM)
     */
    public void buildClusteringCriteria(int indexCriteria, int clusteringType) {
        if (clusteringType == 1) {
            configKMeansClustererEachCriteria();
        } else if (clusteringType == 2) {
            configEMClustererEachCriteria();
        }
        switch (indexCriteria) {
            case 0 :
                if (clusteringType == 1) {
                    try {
                        simpleClusteringAdministrasi.buildClusterer(listRecordsArffForAdministrasi);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {
                    try {
                        EMClusteringAdministrasi.buildClusterer(listRecordsArffForAdministrasi);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 1 :
                if (clusteringType == 1) {
                    try {
                        simpleClusteringTeknis.buildClusterer(listRecordsArffForTeknis);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {
                    try {
                        EMClusteringTeknis.buildClusterer(listRecordsArffForTeknis);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2 :
                if (clusteringType == 1) {
                    try {
                        simpleClusteringAnggaran.buildClusterer(listRecordsArffForAnggaran);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {
                    try {
                        EMClusteringAnggaran.buildClusterer(listRecordsArffForAnggaran);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void outputClusterResult(int indexCriteria, int clusteringType) {
        int[] assigmentThisCriteria = null;
        switch (indexCriteria) {
            case 0 :
                if (clusteringType == 1) {
                    try {
                        assigmentThisCriteria = simpleClusteringAdministrasi.getAssignments();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {
                    //assigmentThisCriteria = EMClusteringAdministrasi.g
                }
                break;
            case 1 :
                if (clusteringType == 1) {
                    try {
                        assigmentThisCriteria = simpleClusteringTeknis.getAssignments();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {

                }
                break;
            case 2 :
                if (clusteringType == 1) {
                    try {
                        assigmentThisCriteria = simpleClusteringAnggaran.getAssignments();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (clusteringType == 2) {

                }
                break;
        }
        int i=0;
        System.out.println("CLUSTERING KONTRAKTOR BERDASARKAN KRITERIA " + (indexCriteria+1));
        for(int clusterNum : assigmentThisCriteria) {
            System.out.printf("Contractor %d -> Cluster %d \n", (i+1), clusterNum);
            i++;
        }
    }

    /**
     * Build K means cluster dan output clustering result K-means
     * @param instances
     */
    public void outputKmeansClusteringResult(Instances instances) {
        SimpleKMeans kmeans = new SimpleKMeans();

        kmeans.setSeed(5);

        //important parameter to set: preserver order, number of cluster.
        kmeans.setPreserveInstancesOrder(true);
        try {
            kmeans.setNumClusters(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load data
        Instances data = instances;


        try {
            kmeans.buildClusterer(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // This array returns the cluster number (starting with 0) for each instance
        // The array has as many elements as the number of instances
        int[] assignments = new int[0];
        try {
            assignments = kmeans.getAssignments();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int i=0;
        for(int clusterNum : assignments) {
            System.out.printf("Contractor %d -> Cluster %d \n", (i+1), clusterNum);
            i++;
        }
    }

    public static void main(String[] arg) {
        Random random = new Random();
        ControllerML controller = new ControllerML();
        // INPUT SCORE KONTRAKTOR UNTUK SEMUA KRITERIA
        for (int i=0;i<6;i++) {
            oneRecordKriteria inputThisKontraktor = new oneRecordKriteria();
            inputThisKontraktor.insertAdministrasiScore(random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1);
            inputThisKontraktor.insertTeknisScore(random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1, random.nextInt(10) + 1);
            inputThisKontraktor.insertAnggaranScore(random.nextInt(10)+1,random.nextInt(10)+1,random.nextInt(10)+1);
            controller.insertNewRecordContractor(inputThisKontraktor);
        }
        // KONFIG INSTANCE WEKA SEMUA KRITERIA
        controller.configArffInstancesEachCriteria();
        // SESUDAH DICONFIG DATA SKOR DILOAD KE INSTANCE WEKA (DATA TERISI DI SINI)
        controller.loadArffFromRawRecords();
        // BENTUK CLUSTER K-MEANS TIAP KRITERIA, KELUARKAN HASIL
        System.out.println("HASIL CLUSTERING KONTRAKTOR UNTUK KRITERIA ADMINISTRASI : ");
        controller.outputKmeansClusteringResult(controller.getListRecordsArffForAdministrasi());
        System.out.println("HASIL CLUSTERING KONTRAKTOR UNTUK KRITERIA TEKNIS : ");
        controller.outputKmeansClusteringResult(controller.getListRecordsArffForTeknis());
        System.out.println("HASIL CLUSTERING KONTRAKTOR UNTUK KRITERIA ANGGARAN : ");
        controller.outputKmeansClusteringResult(controller.getListRecordsArffForAnggaran());
    }
}
