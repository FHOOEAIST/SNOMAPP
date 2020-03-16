package at.snomapp.skeleton.testapplication.repo;

import org.springframework.stereotype.Repository;

// interface for mock databank connection
// this would normally include methods that directly interface with an underlying database
@Repository
public interface Repo {
    boolean saveData(String s);
    String[]getData();
}
