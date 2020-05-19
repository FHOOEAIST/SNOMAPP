package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.domain.APPC.APPCTree;
//interface for importer
public interface Importer {
    APPCTree importTree(String fileName) throws Exception;
}
