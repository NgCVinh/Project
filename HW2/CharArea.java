package New;
import java.util.Scanner;

public class CharArea {
    public static int row;
    public static int col;
    public static char[][]grid;
    public CharArea(int row,int col,char[][] grid){
        this.col=col;
        this.row=row;
        this.grid=grid;
    }
    public static int charArea(char ch,char[][] grid,int row,int col){
        int minRight=0;
        int minLeft=0;
        int minTop=0;
        int minBot=0;
        boolean valid=false;
        boolean used=false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==ch){
                    used=true;
                    if(valid==true){
                        if(minRight<j)
                            minRight=j;
                        if(minLeft>j)
                            minLeft=j;
                        if(minTop>i)
                            minTop=i;
                        if(minBot<i)
                            minBot=i;
                    }
                    else{
                        minRight=j;
                        minLeft=j;
                        minTop=i;
                        minBot=i;
                        valid=true;
                    }
                }
            }
        }
        if(!used)
            return 0;
        else{
            return (minBot-minTop+1)*(minRight-minLeft+1);
        }
    }
    public static int chararea(char ch){
        return charArea(ch,grid,row,col);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        sc.nextLine();
        char[][] grid=new char[row][col];
        for(int i=0;i<row;i++){
            String s=sc.nextLine();
            for(int j=0;j<s.length();j++){
                grid[i][j]=s.charAt(j);
            }
        }
        CharArea ca=new CharArea(row,col,grid);
        char ch=sc.next().charAt(0);
        System.out.print(ca.chararea(ch));
    }
}




