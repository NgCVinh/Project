package New;
import java.util.*;
public class ShapeClient {
    public static void main(String[] args) {

        String a = "0 0 0 1 1 1 1 0";
        Shape A = new Shape(a);
        String b = "10 10 10 11 11 11 11 10";
        Shape B = new Shape(b);
        String c = "0.5 0.5 0.5 -10 1.5 0";
        Shape C = new Shape(c);
        String d = "0.5 0.5 0.75 0.75 0.75 0.2";
        Shape D = new Shape(d);
        System.out.println(A.crosses(B));
        System.out.println(A.crosses(C));
        System.out.println(A.crosses(D));
        System.out.println(A.encircles(B));
        System.out.println(A.encircles(C));
        System.out.println(A.encircles(D));
    }
}
