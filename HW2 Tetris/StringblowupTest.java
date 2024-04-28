package New;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringblowupTest {

    @Test
    public void main() {
        String s1="a3tx2z";
        String s2="attttxzzz";
        assertEquals("attttxzzz",s2);
    }

    @Test
    public void testMain() {
        String s3="12x";
        String s4="2xxx";
        assertEquals("2xxx",s4);
    }
}