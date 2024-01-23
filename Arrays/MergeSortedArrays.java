package Arrays;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] arr, int[] arr1){
        int[] mergeArray = new int[arr.length+arr1.length];
        int i=0;
        int j=0;
        int k=0;
        while(j<arr.length && k<arr1.length){
            if(arr[j]<arr1[k]){
                mergeArray[i]=arr[j];
                i++;
                j++;
            }else {
                mergeArray[i]=arr1[k];
                i++;
                k++;
            }
        }
        while(j<arr.length){
            mergeArray[i]=arr[j];
            i++;
            j++;
        }
        while(k<arr1.length){
            mergeArray[i]=arr1[k];
            i++;
            k++;
        }


        return mergeArray;
    }

    public static void main(String[] args){

        int[] arr = {1,3,5};
        int[] arr1 = {2,4,6};

        int[] mArray = mergeArrays(arr,arr1);

        for(int i=0;i<mArray.length;i++){
            System.out.print(mArray[i] + " ");
        }
    }
}
