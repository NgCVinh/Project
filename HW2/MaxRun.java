package New;

import java.util.Scanner;

public class MaxRun {
    public  static int maxRun(String str){
        int maxRun=1;
        int count=1;
        for(int i=0;i<str.length();i++){
            if(i==str.length()-1){
                if(count>maxRun)
                    maxRun=count;
            }
            else {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    if(count>maxRun)
                        maxRun=count;
                    count=1;
                }
            }
        }
        return maxRun;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(MaxRun.maxRun(s));
    }
}
