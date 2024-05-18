package Stack;

public class Stack_test {
    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push("Hello");

        String s = (String) stack.pop();
        stack.isEmpty();
        System.out.println(s);
        System.out.println(stack.isEmpty());
    }
}
