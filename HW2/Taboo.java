package New;

import java.util.*;
import java.util.Collection;

public class Taboo {
    private final List<String> rule;
    public Taboo(List<String> rule){
        this.rule=rule;
    }
    public Set<String>noFollow(String elem){
        Set<String> list=new HashSet<>();
        for(int i=0;i<rule.size();i++){
            if(rule.get(i).equals(elem)){
                list.add(rule.get(i+1));
            }
        }
        return list;
    }
    public List<String> reduce(List<String>list){
        int index=1;
        while(index<list.size()){
            Set<String>current=noFollow(list.get(index-1));
            if(current.contains(list.get(index))){
                list.remove(index);
            }
            else{
                index+=1;
            }
        }
        return list;
    }
}
