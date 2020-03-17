package at.snomapp.skeleton.importer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Importer {

    public static void importer_v1(String fileName)throws Exception{
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        String [] splittedLine = new String[7];
        while((s = bReader.readLine())!= null){
            splittedLine = s.split(";");
            for (int i = 0; i < splittedLine.length; i++) {
                System.out.print(splittedLine[i] +", ");
            }
            System.out.println();

        }
        bReader.close();

    }

    public static void main(String[] args) throws Exception {

        System.out.println("Test version 1:");
        importer_v1("src/main/resources/APPC_machinereadable.csv");
    }
}
