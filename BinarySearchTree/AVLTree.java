package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    BinaryNode root;

    AVLTree(){
        this.root = null;
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
    public int getHeight(BinaryNode node){
        if(node==null) return 0;

        return node.height;
    }
    public int getBalanced(BinaryNode node){
        if (node==null) return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insert(BinaryNode node, int value){
        if(node==null){
            node = new BinaryNode(value);
            return node;

        }
        else if (value<=node.value){
            node.left = insert(node.left,value);
        }
        else if(value>=node.value){
            node.right= insert(node.right, value);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalanced(node);


        if(balance>1 && value<node.left.value){
            return rotateRight(node);
        }
       if(balance>1 && value>node.right.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance<-1 && value<node.right.value){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        if(balance<-1 && value>node.right.value){
            return rotateLeft(node);
        }
        return node;

    }

    public void insert(int value){
        root = insert(root,value);
    }

    //rotate right
    private BinaryNode rotateRight(BinaryNode disbalancednode){
        BinaryNode newRoot = disbalancednode.left;
        disbalancednode.left = newRoot.right;
        newRoot.right = disbalancednode;
        disbalancednode.height = 1 + Math.max(getHeight(disbalancednode.left),getHeight(disbalancednode.right));
       newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }

    //rotateLeft
    private BinaryNode rotateLeft(BinaryNode disbalancednode){
        BinaryNode newRoot = disbalancednode.right;
        disbalancednode.right = newRoot.left;
        newRoot.left = disbalancednode;
        disbalancednode.height = 1 + Math.max(getHeight(disbalancednode.left),getHeight(disbalancednode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));
        return newRoot;
    }
     private BinaryNode minimumNode(BinaryNode node){
        if(node.left==null) return null;
        return minimumNode(root.left);
    }

    public void delete(int value){
        delete(root,value);
    }
    public BinaryNode delete(BinaryNode root, int value){
        if(root == null) {
            System.out.println("The AVL tree is empty");
            return null;
        }else if(root.value>value){
            root.left = delete(root.left,value);
        }
        else if(root.value<value){
            root.right = delete(root.right,value);
        }else{
            if(root.left!=null && root.right!=null){
                BinaryNode minNode = minimumNode(root.right);
                root.value = minNode.value;
                root.right = delete(root.right, minNode.value);
            }
            else if(root.left!=null){
                root = root.left;
            } else if (root.right!=null) {
                root=root.right;
            }else{
                root = null;
            }
        }

        int balance=getBalanced(root);

        if(balance>1 && getBalanced(root.left)>=0){
            return rotateRight(root);
        }
        else if (balance>1 && getBalanced(root.left)<0){
            root.left = rotateLeft(root.left);
            return rotateLeft(root);
        }
        else if(balance<-1 && getBalanced(root.right)<=0){
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        else if(balance<-1 && getBalanced(root.right)>0){
            return rotateLeft(root);
        }

        return root;

    }

}
