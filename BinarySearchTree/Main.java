package BinarySearchTree;

public class Main {
    public static void main(String[] args){
      //  BinarySearchTree bst = new BinarySearchTree();
        AVLTree avl = new AVLTree();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);

        avl.levelOrder();

//        bst.insert(70);
//        bst.insert(50);
//        bst.insert(30);
//        bst.insert(20);
//        bst.insert(40);
//        bst.insert(90);
//        bst.insert(95);
//        bst.insert(80);
//        bst.insert(100);
//        bst.insert(60);
//
//        bst.levelOrder();
//        bst.delete(bst.root,90);
//        bst.levelOrder();
    }
}
