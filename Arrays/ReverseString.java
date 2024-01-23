package Arrays;

//import java.util.*;

import java.util.Scanner;

public class ReverseString {


    public static String reverse(String s){
        String r="";
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        return r;
    }

    public static String reverseStringBuilder(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static String recursiveReverse(String s){
        if(s.length()==0) return "";

        return recursiveReverse(s.substring(1))+s.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String s = scn.nextLine();

        String r = recursiveReverse(s);
        System.out.println(r);
    }
}
