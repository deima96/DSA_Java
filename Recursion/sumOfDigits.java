package Recursion;

public class sumOfDigits {

    public static  int sumofDigits(int n){
        if(n<0) return 0;
        if(n/10==0){
            return n;
        }
        return (n%10+sumofDigits(n/10));
    }
    public static void main(String[] args){

        System.out.println("Sum of " + 119 + "=" + sumofDigits(119));

    }
}
