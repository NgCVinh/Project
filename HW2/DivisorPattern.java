import java.util.*;
public class DivisorPattern {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if((i%j==0)||(j%i==0)){
                    System.out.print("* ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println(i);
        }
    }
}
