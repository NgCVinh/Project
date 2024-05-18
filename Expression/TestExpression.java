package Expression;

import java.util.Scanner;

public class TestExpression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a1=sc.nextInt();
        int a2=sc.nextInt();
        Numeral firstElement=new Numeral(a1);
        Numeral secondElement=new Numeral(a2);
        Square firstSquare=new Square(firstElement);
        Expression newExpression=new Addition(firstSquare,secondElement);
        System.out.println(newExpression.toString()+" = "+newExpression.evaluate());
    }
}
