package Queue;

public class QueueArray {

    Object[] queue;
    int beginningOfQueue;
    int endOfQueue;


    QueueArray(int size){
        queue = new Object[size];
        beginningOfQueue=-1;
        endOfQueue=-1;
    }

    public boolean isEmpty(){
        if(beginningOfQueue==-1 && beginningOfQueue<endOfQueue) return true;
        else return false;
    }

    public boolean isFull(){
        if(endOfQueue == queue.length-1) return true;
        else return false;
    }

    public void enQueue(Object obj){
        if(!isFull()){
            queue[endOfQueue+1] = obj;
            endOfQueue++;
            if(isEmpty()) beginningOfQueue+=1;
            return;
        }
        System.out.println("The queue is full.");
    }

    public Object deQueue(){
        if(!isEmpty()){
            Object obj = queue[beginningOfQueue];
            beginningOfQueue++;

            if(beginningOfQueue>endOfQueue){
                beginningOfQueue = endOfQueue = -1;
            }

            return obj;
        }
        System.out.println("The Queue is Empty");
        return null;
    }


}
