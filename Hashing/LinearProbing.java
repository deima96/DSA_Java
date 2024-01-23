package Hashing;

import java.util.ArrayList;

public class LinearProbing {
        String[] hashtable;
        int usedCellNumber;

        LinearProbing(int size){
            hashtable = new String[size];
            usedCellNumber = 0;
        }

        public int modASCIIHashFunction(String word, int index){
            char[] ch;
            ch = word.toCharArray();
            int sum=0;
            for(int i=0;i<ch.length;i++){
                sum+=ch[i];
                System.out.println(sum);
            }

            return sum%index;
        }
        public double getLoadFactor(){
            return usedCellNumber*1.0/hashtable.length;
        }

        public void rehashKeys(String word){
            usedCellNumber=0;
            ArrayList<String> data = new ArrayList<>();
            for(String s:hashtable){
                if(s!=null){
                    data.add(s);
                }
                data.add(word);
                hashtable = new String[hashtable.length*2];
                for(String s:data){
                    //Insert function
                    insert(s);
                }
            }
        }

        public void insert(String word){
            double loadFactor = getLoadFactor();
            if(loadFactor > 0.75){
                rehashKeys(word);
            }
            else{
                int index=modASCIIHashFunction(word,hashtable.length);
                //Here we used i<index+hashtable.length so when i>hashtable.length
                for(int i=index;i<index+hashtable.length;i++){
                    int newIndex = i % hashtable.length; //it will calculate a new_index here to go to the starting position if those cells are not filled
                    if(hashtable[newIndex] == null){
                        hashtable[newIndex] = word;
                        System.out.println("The " + word+" is inserted successfully.");
                        break;
                    }else{
                        System.out.println("The cell is already occupied, trying to find the new_cell");
                    }
                }
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
            int index = modASCIIHashFunction(word,hashtable.length);
            for(int i=index;i<index+hashtable.length;i++){
                int new_index = i%hashtable.length;
                if(hashtable[new_index] != null && hashtable[index].equals(word)){
                    System.out.println("Found");
                    return true;
                }
            }
            System.out.println("The " + word + " doesn't exist in this hashtable");
            return false;
        }

        public void delete(String word){
            int index = modASCIIHashFunction(word,hashtable.length);
            for(int i=index;i<index+hashtable.length;i++){
                int new_index = i%hashtable.length;
                if(hashtable[new_index] != null && hashtable[index].equals(word)){
                    hashtable[new_index] = null;
                    System.out.println("Deleted");
                    return;
                }
            }
            System.out.println("The " + word + " doesn't exist in this hashtable");
        }


}
