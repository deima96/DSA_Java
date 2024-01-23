package HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    ArrayList<KeyValue>[] data;
    int currentLength;

    HashTable(int size){
        data = new ArrayList[size];
        currentLength=0;
    }

    public int _hashing(String key){
        int hash=0;
        for(int i=0;i<key.length();i++){
            hash = (hash+key.codePointAt(i))% data.length;
        }
        return hash;
    }

    public void set(String key,int value){
        int index = _hashing(key);

        if(data[index]==null){
            ArrayList<KeyValue> arr = new ArrayList<KeyValue>();
            data[index] = arr;
            currentLength++;
        }
        KeyValue pair = new KeyValue(key,value);
        data[index].add(pair);
    }

    public Integer get(String key){
        int index = _hashing(key);

        ArrayList<KeyValue> bucket = data[index];

        if(bucket != null){
            for(KeyValue keyValue:bucket){
                if(keyValue.getKey().equals(key)){
                    return keyValue.getValue();
                }

            }
        }
        return null;
    }

    public String[] keys(){
        ArrayList<KeyValue>[] bucket = data;
        String[] keysArray = new String[currentLength];
        int count=0;

        for(ArrayList<KeyValue> keyValues:bucket){
            if(keyValues != null){
                keysArray[count] = keyValues.get(0).getKey();
                count++;
            }
        }
        return keysArray;
    }

    public static void main(String[] args){
        HashTable hashTable = new HashTable(5);

        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three",3);

        System.out.println(hashTable.get("three"));
//        System.out.println(hashTable.currentLength);

        System.out.println(Arrays.toString(hashTable.keys()));


    }


}
