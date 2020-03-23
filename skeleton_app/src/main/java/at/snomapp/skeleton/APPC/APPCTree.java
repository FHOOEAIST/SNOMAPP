package at.snomapp.skeleton.APPC;

import java.util.HashSet;
import java.util.Set;

public class APPCTree {
    private String language;
    private AxisEntry modality;
    private AxisEntry laterality;
    private AxisEntry procedure;
    private AxisEntry anatomy;

    APPCTree(String language){
        this.language = language;
        modality = null;
        laterality = null;
        procedure = null;
        anatomy = null;
    }

    void buildTree(String filename){
        //TODO
    }

    // primitve search functionality, returns exact matches only
    Set<Entry> serach(String query){
        Set<Entry> result = new HashSet<>();
        result.addAll(modality.search(query));
        result.addAll(laterality.search(query));
        result.addAll(procedure.search(query));
        result.addAll(anatomy.search(query));

        return result;
    }

}
