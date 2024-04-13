import java.util.*;
public class HarmonicNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double res=0;
        for(int i=1;i<=n;i++){
            res=res+1.0/i;
        }
        System.out.println(res);
    }
}
