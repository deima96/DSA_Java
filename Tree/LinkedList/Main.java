package Tree.LinkedList;

import Tree.LinkedList.BinaryTree;

public class Main {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.insert("N1");
        tree.insert("N2");
        tree.insert("N3");
        tree.insert("N4");
        tree.insert("N5");
        tree.insert("N6");
        tree.insert("N7");
        tree.insert("N8");

        tree.levelOrder();
        tree.deleteNode("N3");
        tree.levelOrder();

    }
}
