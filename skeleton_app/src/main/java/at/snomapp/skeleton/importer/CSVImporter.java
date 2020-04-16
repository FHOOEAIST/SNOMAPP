package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.APPC.APPCEntry;
import at.snomapp.skeleton.APPC.APPCTree;
import at.snomapp.skeleton.APPC.AxisEntry;
import at.snomapp.skeleton.APPC.Entry;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@Component("CSVImporter")
public class CSVImporter implements Importer{

    public APPCTree importTree(String fileName) throws Exception {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        APPCTree tree = new APPCTree("englisch");
        String s;
        String BranchName;
        String Description;
        //empty entry, prevLayer to help with finding parent
        Entry current = null;
        int prevLayer = 0;
        //List of Codes
        ArrayList<String> codes = new ArrayList<>();

        //reading csvfile per line
        while ((s = bReader.readLine()) != null) {
            BranchName = s.split(";")[0];

            //fills list with codes from this line
            codes.addAll(Arrays.asList(s.split(";")).subList(1, 7));

            Description = s.split(";")[7];
            //current layer
            int layer = 0;
            for (int i = 1; i < 6; i++) {
                if (!codes.get(i).isEmpty()) {
                    layer++;
                }
            }
            //find out how much steps you need to go back to parent
            if (layer <= prevLayer) {
                int steps = prevLayer - layer;
                for (int i = 0; i < steps + 1; i++) {
                    assert current != null;
                    current = current.getParent();
                }
            }
            //create a new branch in tree
            if (!BranchName.isEmpty()) {
                AxisEntry next = new AxisEntry(BranchName);
                switch (BranchName.toLowerCase()) {
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
                //set branch to current node
                current = next;
            }
            //make new node and add it to tree
            APPCEntry next = new APPCEntry(Description, Integer.parseInt(codes.get(layer)));
            assert current != null;
            current.addChild(next);
            current = next;
            //clears codelist so it's ready for new line
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

        System.out.println(tree.toString());
        System.out.println();
    }
}
