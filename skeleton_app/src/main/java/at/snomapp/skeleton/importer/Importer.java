package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.APPC.FourAxisTree;

public interface Importer {
    void importTree(String fileName, FourAxisTree tree) throws Exception;
}
