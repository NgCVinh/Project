package New;

import java.util.HashSet;
import java.util.Scanner;

public class StringIntersect {
    public static boolean stringIntersect(String a,String b,int len){
        HashSet<String> list=new HashSet<String>();
        for(int i=0;i<a.length()-len+1;i++){
            String s=a.substring(i,i+len-1);
            list.add(s);
        }
        for(String s: list){
            if(b.contains(s)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        sc.nextLine();
        String a=sc.nextLine();
        String b=sc.nextLine();
        System.out.print(StringIntersect.stringIntersect(a,b,len));
    }
}
