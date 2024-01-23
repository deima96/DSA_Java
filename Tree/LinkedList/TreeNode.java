package Tree.LinkedList;


import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode child){
        this.children.add(child);
    }

    public String printTree(int level){
        String ret= " ".repeat(level) + this.data + "\n";
        for(TreeNode node : this.children){
            ret+=node.printTree(level+1);
        }
        return ret;
    }
}
