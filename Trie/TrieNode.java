package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character,TrieNode> children;
    Boolean endOfString;

    TrieNode(){
        children = new HashMap<>();
        endOfString =false;
    }
}
