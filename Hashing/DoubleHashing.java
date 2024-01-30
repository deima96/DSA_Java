package Hashing;

import java.util.ArrayList;

public class DoubleHashing {
    String[] hashtable;
    int usedCellNumber;

    DoubleHashing(int size){
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

    public void displayHashTable(){
        if(hashtable==null){
            System.out.println("HashTable is empty");
            return;
        }
        for(int i=0;i<hashtable.length;i++){
            System.out.println("Index: " + i + " Key: " + hashtable[i]);
        }
    }

    private int addAllDigitsTogether(int sum){
        int value=0;
        while (sum>0){
            value+=sum%10;
            sum/=10;
        }
        return value;
    }

    public int secondHashing(String str, int index){
        char ch[] = str.toCharArray();
        int sum=0;
        for(int i=0;i<str.length();i++){
            sum+=ch[i];
        }
        while (sum>hashtable.length){
            sum = addAllDigitsTogether(sum);
        }
        return sum%index;
    }

    public void insert(String value){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashing(value);
        }else{
            int x = modASCIIHashFunction(value,hashtable.length);
            int y = secondHashing(value,hashtable.length);
            for(int i=0;i<hashtable.length;i++){
                int newIndex = (x + (i*y))%hashtable.length;
                if(hashtable[newIndex] == null){
                    hashtable[newIndex] = value;
                    System.out.println(value +" inserted Successfully at location: " + newIndex);
                }
                else{
                    System.out.println("The cell is already occupied, trying to find the new_cell");
                }
            }
            usedCellNumber++;

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
