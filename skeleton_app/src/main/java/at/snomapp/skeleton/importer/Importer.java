package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.APPC.APPCTree;
//interface for importer
public interface Importer {
    void importTree(String fileName, APPCTree tree) throws Exception;
}
