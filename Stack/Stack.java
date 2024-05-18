package Stack;


import java.util.ArrayList;
import java.lang.String;

public class Stack<String>{
    private Node<String> top;
    public ArrayList<Node<String>>list;
    public Stack(){
        this.list=new ArrayList<>();
    }

    public void push(String string){
        if(list.isEmpty()){
            top=new Node<>(string);
            list.add(top);
        }
        else {
            Node<String> newNode = new Node<>(string);
            top.nextNode = newNode;
            newNode.nextNode = null;
            top = newNode;
            list.add(newNode);
        }
    }
    public String pop(){
        String string=top.string;
        list.remove(list.size()-1);
        if(list.size()>=1) {
            top = list.get(list.size()-1);
            top.nextNode=null;
        }
        return string;
    }
    public boolean isEmpty(){
        if(list.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
