package at.snomapp.skeleton.APPC;

import at.snomapp.skeleton.APPC.impl.AxisEntry;

import java.util.Set;

public interface FourAxisTree {
    String getLanguage();

    void setModality(AxisEntry modality);

    void setLaterality(AxisEntry laterality);

    void setProcedure(AxisEntry procedure);

    void setAnatomy(AxisEntry anatomy);

    // primitve search functionality, returns exact matches only
    Set<Entry> serach(String query);
}
