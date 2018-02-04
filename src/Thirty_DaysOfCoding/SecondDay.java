package Thirty_DaysOfCoding;

import java.util.Scanner;

public class SecondDay {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int j_i=0; double j_d = 0.0; String j_s = null;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        j_i = Integer.parseInt(scan.nextLine());
        j_d = Double.parseDouble(scan.nextLine());
        j_s = scan.nextLine();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+j_i);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+j_d);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s.concat(j_s));
        scan.close();
    }
}
