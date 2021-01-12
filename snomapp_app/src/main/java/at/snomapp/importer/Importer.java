package at.snomapp.importer;

import at.snomapp.domain.appc.APPCTree;
//interface for importer
public interface Importer {
    APPCTree importTree(String from) throws Exception;
}
