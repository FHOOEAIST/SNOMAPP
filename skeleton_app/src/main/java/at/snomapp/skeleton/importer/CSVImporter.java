package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.APPC.FourAxisTree;
import at.snomapp.skeleton.APPC.impl.APPCEntry;
import at.snomapp.skeleton.APPC.impl.APPCTree;
import at.snomapp.skeleton.APPC.impl.AxisEntry;
import at.snomapp.skeleton.APPC.Entry;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@Component("CSVImporter")
public class CSVImporter implements Importer{

    public void importTree(String fileName, FourAxisTree tree) throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        String NameSparte;
        String Beschreibung;

        Entry current = null;
        int prevLayer = 0;

        ArrayList<String> codes = new ArrayList<>();
        while ((s = bReader.readLine()) != null) {
            NameSparte = s.split(";")[0];

            codes.addAll(Arrays.asList(s.split(";")).subList(1, 7));

            Beschreibung = s.split(";")[7];

            int layer = 0;
            for (int i = 1; i < 6; i++) {
                if (!codes.get(i).isEmpty()) {
                    layer++;
                }
            }

            if (layer <= prevLayer) {
                int steps = prevLayer - layer;
                for (int i = 0; i < steps + 1; i++) {
                    assert current != null;
                    current = current.getParent();
                }
            }

            if (!NameSparte.isEmpty()) {
                AxisEntry next = new AxisEntry(NameSparte);
                switch (NameSparte.toLowerCase()) {
                    case ("modality"):
                        tree.setModality(next);
                        break;
                    case ("laterality"):
                        tree.setLaterality(next);
                        break;
                    case ("procedures"):
                        tree.setProcedure(next);
                        break;
                    case ("anatomy"):
                        tree.setAnatomy(next);
                        break;
                    default:
                        assert false;
                }

                current = next;
            }

            APPCEntry next = new APPCEntry(Beschreibung, Integer.parseInt(codes.get(layer)));
            assert current != null;
            current.addChild(next);
            current = next;

            codes.clear();
            prevLayer = layer ;
        }
        bReader.close();

    }

    public static void main(String[] args) throws Exception {
        FourAxisTree tree = new APPCTree("englisch");
        Importer importer = new CSVImporter();
        importer.importTree("src/main/resources/APPC_machinereadable.csv", tree);
    }
}
