package at.snomapp.skeleton.importer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Importer {

    public static void importer_v1(String fileName)throws Exception{
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        String NameSparte;
        String code;
        String code1;
        String code2;
        String code3;
        String code4;
        String code5;
        String Beschreibung;
        int i = 0;
        //ArrayList<String> line = new ArrayList<String>();
        //String [] splittedLine = new String[7];
        while((s = bReader.readLine())!= null){
                NameSparte = s.split(";")[0];
                code = s.split(";")[1];
                code1 = s.split(";")[2];
                code2 = s.split(";")[3];
                code3 = s.split(";")[4];
                code4 = s.split(";")[5];
                code5 = s.split(";")[6];
                Beschreibung = s.split(";")[7];
                if(!NameSparte.isEmpty()){
                System.out.println(NameSparte);
                } else {
                System.out.println(" "+code +
                        ", " + code1 + " " +code2 +
                        " " + code3 + " " + code4 +
                        " " + code5 + ", "+Beschreibung);
                }
        }
        bReader.close();

    }

    public static void main(String[] args) throws Exception {
        importer_v1("src/main/resources/APPC_machinereadable.csv");
    }
}
