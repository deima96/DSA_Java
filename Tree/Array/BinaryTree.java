package Tree.Array;



public class BinaryTree {
    String[] arr;
    int lastUsedIndex;

    BinaryTree(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
    }

    boolean isFull(){
        if(arr.length-1 == lastUsedIndex) return true;
        else return false;
    }

    public void insert(String value){
        if(!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("The " + value + " is successfully inserted.");
            return;
        }
        System.out.println("The Binary tree is full, it cannot be inserted.");
    }

    public void preOrderTraversal(int index){
        if(index>lastUsedIndex) return;

        System.out.print(arr[index] + " ");
        preOrderTraversal(2*index);
        preOrderTraversal((2*index)+1);
    }
    public void inOrder(int index){
        if(index>lastUsedIndex) return;

        inOrder(2*index);
        System.out.print(arr[index]);
        inOrder(2*index+1);
    }

    public void postOrder(int index){
        if(index>lastUsedIndex) return;

        postOrder(2*index);
        postOrder(2*index+1);
        System.out.print( arr[index] +" ");
    }

    public void levelOrder(){
        for(int i=1;i<=lastUsedIndex;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int Search(String value){
        for (int i=1;i<=lastUsedIndex;i++){
            if(arr[i].equals(value)){
                System.out.println("The " + value + " is found at location" + i);
                return i;
            }
        }
        System.out.println("The " +value+ " doesn't exist in the tree.");
        return -1;
    }

    public void delete(String value){
        int index = Search(value);
        if(index==-1) return;
        arr[index] = arr[lastUsedIndex];
        lastUsedIndex--;
        System.out.println("The " + value + " is successfully deleted.");
    }

    public void deleteBT(){
        try{
            arr=null;
            System.out.println("The tree is successfully deleted");
        }catch(Exception e){
            System.out.println("The tree is not deleted.");
        }
    }



}
