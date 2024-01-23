package Queue;

public class Queue {
    Node first,last;
    int size;


    Queue(){
        first = last = null;
        size=0;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }
    public void enQueue(int value){
        Node queue = new Node(value);
        if(size==0){
            first = last = queue;
        }
        else{
            last.next = queue;
            last = queue;
        }
        size++;
    }

    public int deQueue(){
        if(!isEmpty()){
            int value = first.value;
            if(size==1){
                first = last =null;
                return value;
            }
            first=first.next;
            System.out.println(first.value);
            size--;

            return value;
        }
        System.out.println("The queue is empty");
        return -1;
    }

    public int peek(){
        if(!isEmpty()){
            return first.value;
        }
        System.out.println("The queue is empty");
        return -1;
    }




}
