package Stack;

public class Main {

    public static void main(String[] args){
        Stack stack = new Stack(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());


        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        stack.delete(3);
        System.out.println(stack.peek());
    }
}
