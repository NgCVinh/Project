package New;

import java.util.Scanner;

public class TetrisGrid {
    private int row;
    private int col;
    private boolean[][]table;
    private boolean[][]grid;
    public TetrisGrid(boolean[][] grid){
        this.grid=grid;
    }
    public TetrisGrid(boolean[][] table,int row,int col){
        this.table=table;
        this.col=col;
        this.row=row;
    }
    public void clearRows(){
        boolean[] RowFound = new boolean[row];
        for (int r = 0; r < row; r++) {
            while (!RowFound[r]) {
                for (int j = 0; j < col; j++) {
                    if (table[r][j] != true) {
                        RowFound[r] = true;
                        break;
                    }
                }
                if (RowFound[r] == false) {
                    for (int k = r; k < row; k++) {
                        if (k == row - 1) {
                            for (int j = 0; j < col; j++) {
                                table[k][j] = false;
                            }
                        } else {
                            for (int j = 0; j < col; j++) {
                                boolean tmp=table[k + 1][j];
                                table[k][j]=tmp;
                            }
                        }
                    }
                }
            }
        }
    }
    public boolean[][] getGrid(){
        return table;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        boolean[][] table = new boolean[row][col];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                table[i][j] = sc.nextBoolean();
            }
        }
        TetrisGrid tetrisGrid=new TetrisGrid(table,row,col);
        tetrisGrid.clearRows();
        boolean[][]grid=tetrisGrid.getGrid();
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<col;j++){
                System.out.print(grid[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}



