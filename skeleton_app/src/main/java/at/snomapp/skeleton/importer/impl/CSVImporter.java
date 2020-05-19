package at.snomapp.skeleton.importer.impl;

import at.snomapp.skeleton.appc.APPCEntry;
import at.snomapp.skeleton.appc.APPCTree;
import at.snomapp.skeleton.appc.AxisEntry;
import at.snomapp.skeleton.appc.Entry;
import at.snomapp.skeleton.importer.Importer;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("CSVImporter")
public class CSVImporter implements Importer {

    public APPCTree importTree(String fileName) throws IOException {

        APPCTree tree = new APPCTree("englisch");

        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {

            // whole line of csv file
            String s;
            Entry current = null;

            // prevLayer to help with finding parent
            int prevLayer = 0;

            // read file line by line
            while ((s = bReader.readLine()) != null) {

                // split line in fields
                List<String> fields = new ArrayList<>(Arrays.asList(s.split(";")));

                // separate codes
                List<String> codes = fields.subList(2, 7);

                // get field values and replace all occurrences of unwanted UTF-8 characters
                String branchName = fields.get(0).replaceAll("[\uFEFF-\uFFFF]", "");
                String fullCode = fields.get(1).replaceAll("[\uFEFF-\uFFFF]", "");
                String displayName = fields.get(7).replaceAll("[\uFEFF-\uFFFF]", "");

                // get layer of code to determine position in tree structure
                int layer = 0;
                for (String code : codes) {
                    if (!code.isEmpty()) {
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

                // so we know on which layer the previous node was
                prevLayer = layer;
            }
        }

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
