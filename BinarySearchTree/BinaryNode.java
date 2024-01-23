package BinarySearchTree;

public class BinaryNode {
    int value,height=0;
    BinaryNode left,right;

    BinaryNode(){
        this.height=0;
    }

    BinaryNode(int value){
        this.value = value;
        this.height+=1;
        this.left=null;
        this.right=null;
    }


}
