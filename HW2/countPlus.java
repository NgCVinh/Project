package New;

import java.util.Scanner;

public class countPlus {
    private char[][] grid;
    private int row;
    private int col;
    public countPlus(char[][] grid,int row,int col){
        this.grid=grid;
        this.col=col;
        this.row=row;
    }
    public int CountPlus(){
        int countTop=0;
        int countBot=0;
        int countRight=0;
        int countLeft=0;
        int cnt=0;
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                for (int k = j; k >= 0; k--) {
                    if (grid[i][k] == grid[i][j])
                        countLeft++;
                    else
                        break;
                }
                for (int k = j; k < col; k++) {
                    if (grid[i][k] == grid[i][j])
                        countRight++;
                    else
                        break;
                }
                for (int k = i; k < row; k++) {
                    if (grid[k][j] == grid[i][j])
                        countBot++;
                    else
                        break;
                }
                for (int k = i; k >= 0; k--) {
                    if (grid[k][j] == grid[i][j])
                        countTop++;
                    else
                        break;
                }
                if (countBot == countTop && countBot == countRight && countBot == countLeft && countBot >= 2)
                    cnt++;
                countBot = 0;
                countLeft = 0;
                countRight = 0;
                countTop = 0;
            }
        }
            return cnt;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        sc.nextLine();
        char[][] grid=new char[row][col];
        for(int i=0;i<row;i++){
            String input=sc.nextLine();
            for(int j=0;j<input.length();j++){
                grid[i][j]=input.charAt(j);
            }
        }
        countPlus Count=new countPlus(grid,row,col);
        System.out.println(Count.CountPlus());
    }
}
