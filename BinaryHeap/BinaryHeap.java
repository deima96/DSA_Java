package BinaryHeap;

public class BinaryHeap {
    int[] arr;
    int sizeOfTree;

    BinaryHeap(int size){
        this.arr = new int[size+1];
        this.sizeOfTree=0;
    }
    public boolean isEmpty(){
        if(sizeOfTree == 0) return true;
        return false;
    }
    public Integer peek(){
        if(isEmpty()){
            System.out.println("The Binary Heap Tree is empty");
            return null;
        }
        return arr[1];
    }
    public void levelOrder(){
        for(int i=1;i<=sizeOfTree;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void heapifyBottomToTop(int index,String heapType){
        if(index<=1) return;
        int parent = index/2;

        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[parent];
                arr[parent]=arr[index];
                arr[index] = temp;
            }
        } else if (heapType == "Max") {
            if(arr[index] > arr[parent]){
                int temp = arr[parent];
                arr[parent]=arr[index];
                arr[index] = temp;
            }
        }
         heapifyBottomToTop(parent,heapType);
    }

    public void insert(int value, String heapType){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree,heapType);
        System.out.println("Inserted at Binary Heap");
    }

    public void heapifyTopToBottom(int index, String heapType){
        int left = index*2;
        int right = index*2+1;
        int swapChild;
        if(sizeOfTree<left){
            return;
        }
        if(heapType == "Max"){
            //have only one child
            if(sizeOfTree==left){
                if(arr[index]<arr[left]){
                    int temp=arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            //have 2 children
            else {
                if(arr[left]>arr[right]){
                    swapChild=left;
                }
                else{
                    swapChild=right;
                }
                if(arr[index]<arr[swapChild]){
                    int temp =arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild]=temp;
                }
            }
        }
        else {
            //have only one child
            if(sizeOfTree==left){
                if(arr[index]>arr[left]){
                    int temp=arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            //have 2 children
            else {
                if(arr[left]<arr[right]){
                    swapChild=left;
                }
                else{
                    swapChild=right;
                }
                if(arr[index]>arr[swapChild]){
                    int temp =arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild]=temp;
                }
            }
        }
        heapifyTopToBottom(swapChild,heapType);
    }

    public Integer extractHeadofBH(String heapType){
        if(isEmpty()){
            System.out.println("The Binary Heap tree is empty");
            return null;
        }
        int num = arr[1];
        arr[1] = arr[sizeOfTree];
        sizeOfTree--;
        heapifyTopToBottom(1,heapType);

        return num;
    }

}
