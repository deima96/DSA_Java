package Recursion;

public class Recursion {
    //Find GCD using Euclidean algorithm.
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static int decitobi(int decimal){
//        if(decimal/2==0){
//            return String.valueOf(decimal%2);
//        }
        if(decimal==0) return 0;

        return decimal%2 + 10*decitobi(decimal/2);

//        return decitobi(decimal/2) + String.valueOf(decimal%2);
    }
    public static void main(String[] args){
        System.out.println(gcd(48,18));
        System.out.println(decitobi(11));

    }
}
