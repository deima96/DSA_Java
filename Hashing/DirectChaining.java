package Hashing;

import  java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChain=5;

    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    public int modASCIIHashFunc(String word,int m){
        char ch[];
        ch = word.toCharArray();
        int i,sum;
        for(sum=0,i=0;i<word.length();i++){
            sum+=ch[i];
            System.out.println(sum);
        }
        return sum+m;
    }

    public void insert(String word){
        int index = modASCIIHashFunc(word,hashTable.length);

        if(hashTable[index]==null){
            hashTable[index] = new LinkedList<String>();
            hashTable[index].add(word);
        }else{
            hashTable[index].add(word);
        }
    }

    public void displayHashTable(){
        if(hashTable==null){
            System.out.println("HashTable is empty");
            return;
        }
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Index: " + i + "Key: " + hashTable[i]);
        }
    }


    public boolean search(String word){
        int index = modASCIIHashFunc(word,hashTable.length);

        if(hashTable!=null && hashTable[index].contains(word)){
            System.out.println("The "+word+"is found at location "+index);
            return true;
        }
        System.out.println("The "+word+"does not exist");
        return false;

    }

    public void delete(String word){
        int index = modASCIIHashFunc(word,hashTable.length);

        if(hashTable!=null && hashTable[index].contains(word)){
            hashTable[index].remove(word);
            System.out.println("Deleted Successfully");
            return;
        }
        System.out.println("The "+word+"does not exist");
    }


}
