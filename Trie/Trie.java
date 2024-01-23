package Trie;

public class Trie {
    TrieNode root;

    Trie(){
        root = new TrieNode();
        System.out.println("Trie has been created");
    }

    public void insert(String str){
        TrieNode current=root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null){
                node=new TrieNode();
                current.children.put(ch,node);
            }
            current=node;
        }
        current.endOfString=true;
        System.out.println("Successfully Inserted!");
    }

    public boolean search(String str){
        TrieNode current  = root;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node==null) {
                System.out.println(str+" doesn't exist.");
                return false;
            }
            current=node;
        }
        if(!current.endOfString){
            System.out.println("The "+str+" doesn't exist.");
            return false;
        }
        System.out.println(str+" found.");
        return true;
    }

    private boolean delete(TrieNode parentNode,String str, int index){
        char ch = str.charAt(index);
        TrieNode current = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;
        //1st case
        if(current.children.size()>1){
            System.out.println("1st Case");
            delete(current,str,index+1);
            return false;
        }
        //2nd case
        if(index == str.length()-1){
            System.out.println("2nd Case"+index);
            if(current.children.size()>1){
                current.endOfString =false;
                return false;
            }
            else{
                parentNode.children.remove(ch);
                return true;
            }
        }
        //third case
        if(current.endOfString==true){
            System.out.println("3rd Case" + index); //P
            delete(current,str,index+1);
            return false;
        }
        //fourth case

        canThisNodeBeDeleted = delete(current,str,index+1); // A I
        if(canThisNodeBeDeleted){
            System.out.println("4th Case");
            parentNode.children.remove(ch);
            return true;
        }
        return false;
    }
    public void delete(String str){
        if(search(str)){
            delete(root,str,0);
        }
        else {
            System.out.println(str + " doesn't exist");
        }
    }
}
