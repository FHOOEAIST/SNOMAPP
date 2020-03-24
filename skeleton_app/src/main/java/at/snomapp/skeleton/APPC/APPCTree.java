package at.snomapp.skeleton.APPC;

import at.snomapp.skeleton.importer.CSVImporter;
import at.snomapp.skeleton.importer.Importer;

import java.util.HashSet;
import java.util.Set;

public class APPCTree {
    private String language;

    private Importer importer;

    public void setModality(AxisEntry modality) {
        this.modality = modality;
    }

    public void setLaterality(AxisEntry laterality) {
        this.laterality = laterality;
    }

    public void setProcedure(AxisEntry procedure) {
        this.procedure = procedure;
    }

    public void setAnatomy(AxisEntry anatomy) {
        this.anatomy = anatomy;
    }

    private AxisEntry modality;
    private AxisEntry laterality;
    private AxisEntry procedure;
    private AxisEntry anatomy;

    public APPCTree(String language){
        this.language = language;
        modality = null;
        laterality = null;
        procedure = null;
        anatomy = null;
        importer = new CSVImporter();
    }

    void buildTree(String filename){
        try {
            importer.importTree(filename, this);
        }catch(Exception e){
            System.out.println("error building tree");
        }
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
