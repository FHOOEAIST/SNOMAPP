package at.snomapp.testapplication.repo;

import org.springframework.stereotype.Repository;

// mock implementation of a repository using in memory stack with limited space
@Repository("StackRepo")
public class mockRepoStack implements Repo {
    private String[] db;
    private int top;

    mockRepoStack(){
        this.top = 0;
        this.db = new String[10];
    }

    @Override
    public boolean saveData(String s) {
        if(top < db.length){
            db[top++] = s;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String[] getData() {
        return db;
    }
}
