package Expression;

public class Square implements Expression {
    private Expression expression;
    public Square(Expression expression) {
        this.expression=expression;
    }
    public String toString() {
        return expression.toString()+"^2";
    }
    public int evaluate() {
        return (int) Math.pow(expression.evaluate(),2);
    }
}
