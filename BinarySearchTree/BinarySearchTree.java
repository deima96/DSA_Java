package BinarySearchTree;



import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree(){
        this.root=null;
    }

    private BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode==null){
            BinaryNode node = new BinaryNode(value);
            return node;
        }
        else if(value <= currentNode.value){
            currentNode.left = insert(currentNode.left, value);
            return  currentNode;
        }
        else{
            currentNode.right = insert(currentNode.right,value);
            return currentNode;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }
    void preOrder(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);

    }
    //Inorder
    void inOrder(BinaryNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    void postOrder(BinaryNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if(presentNode.left!=null) queue.add(presentNode.left);
            if(presentNode.right!=null) queue.add(presentNode.right);
        }
        System.out.println();
    }

    BinaryNode search(BinaryNode node,int value){
        if(node==null){
            System.out.println("The "+value+ " is not in the BST");
            return null;
        }else if(node.value==value){
            System.out.println(value + "found");
            return node;
        }
        else if(value< node.value){
            return search(node.left,value);
        }
        else{
            return search(node.right,value);
        }

    }

    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left==null){
            return root;
        }else{
            return minimumNode(root.left);
        }
    }

    BinaryNode delete(BinaryNode root,int value){
        if(root==null){
            System.out.println("The BST is empty");
            return null;
        }
        if(value < root.value){
            root.left =  delete(root.left,value);
        }
        else if(value > root.value){
            root.right = delete(root.right,value);
        }
        else{
            if(root.left !=null && root.right!=null){
                BinaryNode min = minimumNode(root.right);
                root.value = min.value;
                root.right = delete(root.right,min.value);
            }
            else if(root.left != null){
                root = root.left;
            }
            else if(root.right != null){
                root =root.right;
            }
            else{
                root = null;
            }
        }
        return root;
    }
    void deleteBST(){
        root =null;
        System.out.println("The BST is deleted!");
    }

}
