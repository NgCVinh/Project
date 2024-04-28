package New;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class countPlusTest {

    @Test
    public void main() {
        char[][]grid=new char[][]{
                {' ',' ','p',' ',' ',' ',' ',' ',' '},
                {' ',' ','p',' ',' ',' ',' ','x',' '},
                {'p','p','p','p','p',' ','x','x','x'},
                {' ',' ','p',' ',' ','y',' ','x',' '},
                {' ',' ','p',' ','y','y','y',' ',' '},
                {'z','z','z','z','z','y','z','z','z'},
                {' ',' ','x','x',' ','y',' ',' ',' '}
        };
        countPlus count=new countPlus(grid,7,9);
        assertEquals(2,count.CountPlus());

    }
}