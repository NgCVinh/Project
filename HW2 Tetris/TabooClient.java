package New;

import java.util.ArrayList;
import java.util.List;

public class TabooClient {
    public static void main(String[] args){
        List<String> myRule=new ArrayList<>();
        myRule.add("a");
        myRule.add("c");
        myRule.add("a");
        myRule.add("b");
        Taboo myTaboo=new Taboo(myRule);
        List<String> newList=new ArrayList<>();
        newList.add("a");
        newList.add("c");
        newList.add("b");
        newList.add("x");
        newList.add("c");
        newList.add("a");
        System.out.println(myTaboo.noFollow("a"));
        System.out.println(myTaboo.reduce(newList));


    }
}
