package AHP.Utils;

import model.InputPairWiseComparison;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by steve on 15/12/2015.
 */
public class EksternalFileCSV {

    public static String readRawContentFile(String path) {
        StringBuffer rawFileContent = new StringBuffer();
        String  thisLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((thisLine = br.readLine()) != null) {
                rawFileContent.append(thisLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawFileContent.toString();
    }

    public static InputPairWiseComparison readHalfMatrix(String pathFile) {
        String rawContent = readRawContentFile(pathFile);
        InputPairWiseComparison inputCriteria = new InputPairWiseComparison();
        StringTokenizer nextLineToken = new StringTokenizer(rawContent,"\n");
        while (nextLineToken.hasMoreTokens()) {
            String line = nextLineToken.nextToken();
            StringTokenizer commaToken = new StringTokenizer(line,",");
            int[] arrayNumber = new int[3];
            int counter = 0;
            while (commaToken.hasMoreTokens()) {
                String number = commaToken.nextToken();
                arrayNumber[counter] = Integer.parseInt(number);
                counter++;
            }
            inputCriteria.insertInputPairWiseComparison(arrayNumber[0],arrayNumber[1],arrayNumber[2]);
        }
        return inputCriteria;
    }

    private static int numSubkriteria(String kriteria) {
        int numSubkriteria = 0;
        if (kriteria.equals("administrasi")) {
            numSubkriteria = 8;
        } else if (kriteria.equals("teknis")) {
            numSubkriteria = 6;
        } else if (kriteria.equals("anggaran")) {
            numSubkriteria = 3;
        }
        return numSubkriteria;
    }

    public static ArrayList<String[]> readInputPenilaian(String pathFile,String kriteria) {
        ArrayList<String[]> inputPenilaian = new ArrayList<String[]>();
        String rawContent = readRawContentFile(pathFile);
        StringTokenizer nextLineToken = new StringTokenizer(rawContent,"\n");
        while (nextLineToken.hasMoreTokens()) {
            String line = nextLineToken.nextToken();
            StringTokenizer commaToken = new StringTokenizer(line,",");
            String[] numberPerRow = new String[numSubkriteria(kriteria)];
            int counter = 0;
            while (commaToken.hasMoreTokens()) {
                String number = commaToken.nextToken();
                numberPerRow[counter] = number;
                counter++;
            }
            inputPenilaian.add(numberPerRow);
        }
        return inputPenilaian;
    }
}
