package behavioral.chainofresponsibility;

public abstract class Support {

    protected Support nextLevel;

    public void setNextLevel(Support nextLevel) {
        this.nextLevel = nextLevel;
    }

    public abstract void solveProblem(String problemType);
    
}
