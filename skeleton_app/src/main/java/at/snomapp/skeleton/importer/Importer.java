package at.snomapp.skeleton.importer;

import at.snomapp.skeleton.domain.appc.APPCTree;
//interface for importer
public interface Importer {
    APPCTree importTree(String from) throws Exception;
}
