package Hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuadraticProbing {
    String[] hashtable;
    int usedCellNumber;

    QuadraticProbing(int size){
        hashtable = new String[size];
        usedCellNumber=0;
    }

    public int modASCIIHashFunction(String word, int index){
        char[] ch = word.toCharArray();
        int sum=0;
        for(int i=0;i<ch.length;i++){
            sum+=ch[i];
        }

        return sum%index;
    }

    public double getLoadFactor() {
        return usedCellNumber * 1.0 / hashtable.length;
    }

    public void rehashing(String word){
        usedCellNumber=0;
        ArrayList<String> data = new ArrayList<>();
        for(String str:hashtable){
            if(str!=null) data.add(str);
        }
        data.add(word);
        hashtable = new String[hashtable.length*2];
        for(String str:data){
            insert(str);
        }

    }

    public void insert(String str){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75){
            rehashing(str);
        }
        else{
            int index=modASCIIHashFunction(str,hashtable.length);
            System.out.println("Index: " +index);
            int counter=0;
            for(int i=index;i<index+hashtable.length;i++){
                //we use %hashtable.length down below because we gave i<index+hashtable.length so we
                //need to adjust by giving %hashtable.length
                int newIndex = (index +(counter*counter))%hashtable.length;
                if(hashtable[newIndex] == null){
                    hashtable[newIndex]=str;
                    System.out.println(str +" inserted Successfully at location: " + newIndex);
                    break;
                }else{
                    System.out.println("The cell is already occupied, trying to find the new_cell");
                }
                counter++;
            }
            usedCellNumber++;
        }
    }
    public void displayHashTable(){
        if(hashtable==null){
            System.out.println("HashTable is empty");
            return;
        }
        for(int i=0;i<hashtable.length;i++){
            System.out.println("Index: " + i + " Key: " + hashtable[i]);
        }
    }
    public static void main(String[] args){
        QuadraticProbing qp = new QuadraticProbing(11);
        qp.insert("The");
        qp.insert("quick");
        qp.insert("brown");
        qp.insert("fox");
        qp.insert("over");
        qp.insert("cunning");
        qp.insert("foxes");

        qp.displayHashTable();
    }

}
