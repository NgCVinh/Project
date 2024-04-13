public class Ruler {
    public static void main(String[] args){
        String[]ruler=new String[6];
        ruler[1]="1";
        ruler[2]=ruler[1]+" 2 "+ruler[1];
        ruler[3]=ruler[2]+" 3 "+ruler[2];
        ruler[4]=ruler[3]+" 4 "+ruler[3];
        ruler[5]=ruler[4]+" 5 "+ruler[4];
        for(int i=1;i<=5;i++){
            System.out.println(ruler[i]);
        }
    }
}
