package behavioral.interpreter;

public class Sub implements Expression {
    
    private Expression left;

    private Expression right;

    public Sub(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }

}
