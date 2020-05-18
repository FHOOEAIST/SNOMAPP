package at.snomapp.skeleton.importer.impl;

import at.snomapp.skeleton.appc.APPCEntry;
import at.snomapp.skeleton.appc.APPCTree;
import at.snomapp.skeleton.appc.AxisEntry;
import at.snomapp.skeleton.appc.Entry;
import at.snomapp.skeleton.importer.Importer;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@Component("CSVImporter")
public class CSVImporter implements Importer {

    public APPCTree importTree(String fileName) throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        APPCTree tree = new APPCTree("englisch");

        // whole line of csv file
        String s;
        String branchName;
        String displayName;
        Entry current = null;

        // prevLayer to help with finding parent
        int prevLayer = 0;

        // list of codes
        ArrayList<String> codes = new ArrayList<>();

        // read file line by line
        while ((s = bReader.readLine()) != null) {
            // get branchName and replace all occurrences of unwanted UTF-8 characters
            branchName = s.split(";")[0].replaceAll("[\uFEFF-\uFFFF]", "");

            // fills list with codes from this line
            codes.addAll(Arrays.asList(s.split(";")).subList(1, 7));
            String fullCode = codes.get(0);

            // get displayName and replace all occurrences of unwanted UTF-8 characters
            displayName = s.split(";")[7].replaceAll("[\uFEFF-\uFFFF]", "");

            //current layer
            int layer = 0;

            // get layer of current code (=depth in tree)
            for (int i = 1; i < 6; i++) {
                if (!codes.get(i).isEmpty()) {
                    layer++;
                }
            }

            // find out how many steps you need to go back to parent
            if (layer <= prevLayer) {
                int steps = prevLayer - layer;
                for (int i = 0; i < steps + 1; i++) {
                    assert current != null;
                    current = current.getParent();
                }
            }

            // create a new branch in tree if branch-node reached
            if (!branchName.isEmpty()) {
                AxisEntry next = new AxisEntry(branchName);
                switch (branchName.toLowerCase()) {
                    case ("laterality"):
                        tree.setLaterality(next);
                        break;
                    case ("modality"):
                        tree.setModality(next);
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

                // set branch to current node
                current = next;
            }
            //make new node and add it to tree
            APPCEntry next = new APPCEntry(displayName, fullCode);
            assert current != null;
            current.addChild(next);
            current = next;
            //clears code list so it's ready for new line
            codes.clear();
            //so we know on which layer the previous node was
            prevLayer = layer ;
        }
        bReader.close();
        return tree;
    }

 //for testing
    public static void main(String[] args) throws Exception {
        APPCTree tree = new APPCTree("englisch");
        Importer importer = new CSVImporter();
        tree = importer.importTree("src/main/resources/APPC_machinereadable.csv");
        //FileWriter writer = new FileWriter("importer_test_output.txt");
        //writer.write(tree.toString());
        //writer.close();
        System.out.println(tree.toString());
        System.out.println();
    }
}
