package at.snomapp.skeleton.APPC;

import java.util.HashSet;
import java.util.Set;

public class APPCTree {
    private String language;

    public String getLanguage() {
        return language;
    }

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
    }

    // primitve search functionality, returns exact matches only
    Set<Entry> search(String query){
        Set<Entry> result = new HashSet<>();
        result.addAll(modality.search(query));
        result.addAll(laterality.search(query));
        result.addAll(procedure.search(query));
        result.addAll(anatomy.search(query));

        return result;
    }

    @Override
    public String toString() {
        return "APPCTree{" +
                "language='" + language + '\'' +
                "\n modality=" + modality +
                "\n laterality=" + laterality +
                "\n procedure=" + procedure +
                "\n anatomy=" + anatomy +
                '}';
    }
}
