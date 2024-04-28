package New;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TabooClientTest {

    @Test
    public void main() {

        List<String> myRule = new ArrayList<>();
        myRule.add("a");
        myRule.add("c");
        myRule.add("a");
        myRule.add("b");
        Taboo myTaboo = new Taboo(myRule);
        List<String> newList = new ArrayList<>();
        newList.add("a");
        newList.add("c");
        newList.add("b");
        newList.add("x");
        newList.add("c");
        newList.add("a");
        Set<String>Solution1=new HashSet<>();
        Solution1.add("b");
        Solution1.add("c");
        List<String>Solution2=new ArrayList<>();
        Solution2.add("a");
        Solution2.add("x");
        Solution2.add("c");
        assertEquals(Solution1,myTaboo.noFollow("a"));
        assertEquals(Solution2,myTaboo.reduce(newList));

    }
}