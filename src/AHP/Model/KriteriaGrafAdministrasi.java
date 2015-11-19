package AHP.Model;

/**
 * Created by steve on 19/11/2015.
 */
public class KriteriaGrafAdministrasi {
    /**
     * Daftar subkriteria pada kriteria administrasi :
     * 1. Kelengkapan Data Administrasi
     * 2. Status Perpajakan
     * 3. Struktur Organisasi Perusahaan
     * 4. Stabilitas Finansial
     * 5. Reputasi Perusahaan
     * 6. Pekerjaan Yang Sedang Dilaksanakan
     * 7. Jaminan Bank
     * 8. Sertifikat Keahlian dan Sertifikat Bidang Usaha.
     */
    private double[] eigenValueEachSubcriteria;

    /**
     * Daftar kontraktor diasumsikan sejumlah 6 badan yang dimasukkan
     */
    private double[][] eigenValueEachContractorForThisSubcriteria;

    /**
     * Constructor Default
     */
    public KriteriaGrafAdministrasi() {
        eigenValueEachSubcriteria = new double[8];
        eigenValueEachContractorForThisSubcriteria = new double[6][8];
    }

    /**
     * Insert Eigen Vector for One Subcriteria into eigenValueEachContractorForThisSubcriteria
     * @param indexSubcriteria : 1-8 (lihat daftar kriteria di atas)
     * @param eigenVectorThisSubcriteria : asumsi berjumlah 6 element (contractor)
     */
    public void insertSubcriteriaValueContractor(int indexSubcriteria, double[] eigenVectorThisSubcriteria) {
        for (int i=0;i<6;i++) {
            eigenValueEachContractorForThisSubcriteria[i][indexSubcriteria-1] = eigenVectorThisSubcriteria[i];
        }
    }

    /**
     * Insert final eigen value for each subcriteria
     * @param indexSubcriteria : 1-8 (lihat daftar kriteria di atas)
     * @param eigenValue : didapat dari eigen vector kriteria ini
     */
    public void insertSubcriteriaEigenValue(int indexSubcriteria, double eigenValue) {
        eigenValueEachSubcriteria[indexSubcriteria-1] = eigenValue;
    }

    
}
