package Expression;

public class Numeral implements Expression {
    private int value;
    public Numeral(int value) {
        this.value=value;
    }
    public String toString() {
        return Integer.toString(value);
    }
    public int evaluate() {
        return value;
    }
}
