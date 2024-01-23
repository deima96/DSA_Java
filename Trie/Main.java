package Trie;

public class Main {
    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("APIS");
        trie.insert("AP");
        trie.delete("APIS");
        trie.search("APIS");

    }
}
