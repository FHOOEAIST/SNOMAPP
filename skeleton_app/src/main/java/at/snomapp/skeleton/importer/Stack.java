package at.snomapp.skeleton.importer;

public class Stack {

    protected String [][] stck = new String[10][10];
    protected int tos = -1;

    public Stack() {
        tos = -1;
    }

    //push an item onto the stack
    public void push(String [] item){
        stck[++tos] = item;
    }
}
