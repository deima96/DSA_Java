package Queue;

public class CircularQueue {

    Object[] queue;
    int beginningOfQueue;
    int endOfQueue;


    CircularQueue(int size){
        queue = new Object[size];
        beginningOfQueue=-1;
        endOfQueue=-1;
    }

    public boolean isEmpty(){
        if(endOfQueue==-1) return true;

        return false;
    }

    public boolean isFull(){
        if(beginningOfQueue==0 && endOfQueue==queue.length-1) return true;
        else if(endOfQueue+1==beginningOfQueue) return true;

        return false;
    }

    public void enQueue(Object obj){
        if(!isFull()){
            if(isEmpty()){
                beginningOfQueue=0;
                endOfQueue++;
                queue[endOfQueue] = obj;
            }
            else{
                if(endOfQueue+1==queue.length){
                    endOfQueue=0;
                }
                else{
                    endOfQueue++;
                }
                queue[endOfQueue]= obj;
            }

        }
        System.out.println("The queue is full.");
    }
    public Object deQueue(){
        if(!isEmpty()){
            Object obj = queue[beginningOfQueue];
            if(beginningOfQueue==endOfQueue){
               beginningOfQueue = endOfQueue = -1;
            }
            else if(beginningOfQueue+1==queue.length){
                beginningOfQueue=0;
            }
            else{
                beginningOfQueue++;
            }

            return obj;
        }
        System.out.println("The queue is empty.");
        return null;
    }
    public Object peek(){
        if(!isEmpty()){
            return queue[beginningOfQueue];
        }
        System.out.println("The queue is empty.");
        return null;
    }

}
