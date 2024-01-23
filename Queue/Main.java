package Queue;

public class Main {

    public static  void main(String[] args){
        Queue queue = new Queue();

        System.out.println(queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);


        System.out.println(queue.deQueue());
        System.out.println(queue.peek());



    }

}
