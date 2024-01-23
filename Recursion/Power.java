package Recursion;

public class Power {

    public static int pow(int base, int pow){
        if(pow<0) return 0;
        if(pow==0){
            return 1;
        }
        return (base * pow(base,pow-1));
    }

    public static void main(String args[]){
        System.out.println(pow(4,3));
    }
}
