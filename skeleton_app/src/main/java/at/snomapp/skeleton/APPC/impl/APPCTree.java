package at.snomapp.skeleton.APPC.impl;

import at.snomapp.skeleton.APPC.Entry;
import at.snomapp.skeleton.APPC.impl.AxisEntry;

import java.util.HashSet;
import java.util.Set;

public class APPCTree implements at.snomapp.skeleton.APPC.FourAxisTree {
    private String language;

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public void setModality(AxisEntry modality) {
        this.modality = modality;
    }

    @Override
    public void setLaterality(AxisEntry laterality) {
        this.laterality = laterality;
    }

    @Override
    public void setProcedure(AxisEntry procedure) {
        this.procedure = procedure;
    }

    @Override
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
    @Override
    public Set<Entry> serach(String query){
        Set<Entry> result = new HashSet<>();
        result.addAll(modality.search(query));
        result.addAll(laterality.search(query));
        result.addAll(procedure.search(query));
        result.addAll(anatomy.search(query));

        return result;
    }

}
