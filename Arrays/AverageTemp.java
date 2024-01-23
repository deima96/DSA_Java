package Arrays;

import java.util.Scanner;

public class AverageTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many day's temperature? ");
        int no_days = scan.nextInt();

        int[] temps = new int[no_days];

        for (int i = 1; i <= temps.length; i++) {
            System.out.print("Day " + i + "'s High temp: ");
            temps[i] = scan.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < temps.length; i++) {
            sum += temps[i];
        }
        float average = sum / temps.length;

        System.out.println("Average - " + average);

        int count = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > average) {
                count++;
            }
        }

        System.out.println(count + " days above average");

        scan.close();

    }
}
