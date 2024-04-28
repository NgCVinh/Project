package New;

import org.junit.Test;

import static org.junit.Assert.*;

public class TetrisGridTest {

    @Test
    public void main() {
        boolean[][] table=new boolean[][]{
                {true,true,true},
                {true,true,false},
                {true,true,true},
                {false,true,true},
                {true,false,false},
                {false,false,false},
                {false,false,false},
        };
        TetrisGrid TG=new TetrisGrid(table,7,3);
        TG.clearRows();
        boolean[][]grid=TG.getGrid();
        boolean[][] trueTable=new boolean[][]{
                {true,true,false},
                {false,true,true},
                {true,false,false},
                {false,false,false},
                {false,false,false},
                {false,false,false},
                {false,false,false}
        };
        assertEquals(trueTable,grid);
    }
}