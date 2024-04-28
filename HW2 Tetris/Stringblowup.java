package New;

import java.util.Scanner;

public class Stringblowup {
    public static String String_blowup(String str){
        String s2=new String("");
        for(int i=0;i<str.length();i++){
            if((int)str.charAt(i)>=48&&(int)str.charAt(i)<=57&&i!=str.length()-1){
                for(int j=1;j<=(int)str.charAt(i)-48;j++){
                    s2=s2+str.charAt(i+1);
                }
            }
            else if(i==str.length()-1&&(int)str.charAt(i)>=48&&(int)str.charAt(i)<=57){
                break;
            }
            else{
                s2=s2+str.charAt(i);
            }
        }
        return s2;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        System.out.println(Stringblowup.String_blowup(s1));
    }
}
