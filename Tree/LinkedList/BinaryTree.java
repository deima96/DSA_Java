package Tree.LinkedList;

import Tree.LinkedList.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BinaryNode root;

    BinaryTree(){
        this.root = null;
    }

    //PreOrder Traversal
    void preOrder(BinaryNode node){
        if(node==null){
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);

    }
    //Inorder
    void inOrder(BinaryNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.data + " ");
        inOrder(node.right);
    }

    void postOrder(BinaryNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");

            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println();

    }
    //search method using level order traversal
    void search(String data){
        Queue<BinaryNode> queue = new LinkedList<>();
        int level =1;
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.data == data){
                System.out.println(data + " is found");
                return;
            }
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println("The " + data + " is not present i the tree.");
    }

    void insert(String data){
        BinaryNode node = new BinaryNode();
        node.data=data;
        if(root == null){
            root = node;
        }else{
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                BinaryNode presentNode = queue.remove();
                if(presentNode.left==null){
                    presentNode.left = node;
                    return;
                }
                else if(presentNode.right==null){
                    presentNode.right=node;
                    return;
                }
                else{
                    queue.add(presentNode.left);
                    queue.add(presentNode.right);
                }

            }
        }
    }

    public BinaryNode findDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode = null;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            if(presentNode.left!=null) queue.add(presentNode.left);
            if(presentNode.right != null) queue.add(presentNode.right);
        }
        return presentNode;
    }
    public void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode previousNode,presentNode = null;
        while(!queue.isEmpty()){
            previousNode = presentNode;
            presentNode = queue.remove();
            if(presentNode.left==null){
                 previousNode.right=null;
                 return;
            } else if (presentNode.right==null) {
                presentNode.left=null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }
    void deleteNode(String data){
        Queue<BinaryNode> queue = new LinkedList<>();
        int level =1;
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.data == data){
                presentNode.data = findDeepestNode().data;
                deleteDeepestNode();
                System.out.println(data + " is deleted");
                return;
            }
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println("The " + data + " is not present in the tree so it cna't be deleted. ");
    }





}
