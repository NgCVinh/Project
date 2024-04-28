package New;

import org.junit.Test;
import java.util.*;
import java.util.Collection;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SameCountTest {

    @Test
    public void main() {
        ArrayList<String>A=new ArrayList<>();
        ArrayList<String>B=new ArrayList<>();
        A.add("a");
        A.add("b");
        A.add("a");
        A.add("b");
        A.add("c");
        B.add("c");
        B.add("a");
        B.add("a");
        B.add("d");
        B.add("b");
        B.add("b");
        B.add("b");
        Collection<String>a=new ArrayList<String>(A);
        assertEquals(2,SameCount.sameCount(A,B));

    }
}