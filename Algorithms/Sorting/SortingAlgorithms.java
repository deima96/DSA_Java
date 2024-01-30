package Algorithms.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgorithms {
    int[] arr;

    SortingAlgorithms(){
        
    }

    SortingAlgorithms(int[] arr){
        this.arr = arr;
    }

    public void bubbleSort(int[] arr){
        int size = arr.length;
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void selectionSort(int[] arr){
        int size= arr.length;
        for(int i=0;i<size;i++){
            int minIndex = i;
            for(int j=i+1;j<size;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }

            }
            if (minIndex != i){
                int temp=arr[minIndex];
                arr[minIndex]=arr[i];
                arr[i]=temp;
            }
        }
    }

    public void insertionSort(int[] arr){
        int size = arr.length;
        for(int i=1;i<size;i++){
            int temp = arr[i], j=i;
            while(j>0 && arr[j-1]>temp){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void printBucket(ArrayList<Integer>[] buckets ){
        for(int i =0;i<buckets.length;i++){
            for(int j=0;j< buckets[i].size();j++){
                System.out.println(buckets[i].get(j) + " ");
            }
        }

    }

    public void BucketSort(){
         int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for(int value: arr){
            if(value>maxValue) maxValue = value;
        }
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }
        for(int value : arr){
            int bucketNumber = (int) Math.ceil(((float)value*numberOfBuckets)/(float) maxValue);
            buckets[bucketNumber-1].add(value);
        }
        for(ArrayList<Integer> bucket:buckets){
            Collections.sort(bucket);
        }
        int index=0;
        for(ArrayList<Integer> bucket:buckets){
            for(int value:bucket){
                arr[index]=value;
                index++;
            }
        }

    }
    public void display(int[] arr){
        int size=arr.length;
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        SortingAlgorithms sa = new SortingAlgorithms();
        int[] arr = new int[] {3,5,7,9,1,2,8,6};

        sa.selectionSort(arr);
        sa.display(arr);
    }


}
