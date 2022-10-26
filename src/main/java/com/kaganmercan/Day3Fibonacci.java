package com.kaganmercan;

import java.util.Scanner;

/**
 * @author kaganmercan
 */
public class Day3Fibonacci {
    static Scanner sc = new Scanner(System.in);
    public static void fibonacci() {
        System.out.print("Enter length of fibonacci: ");
        int numberOfFibonacci = sc.nextInt();
        System.out.println();
        int n1 = 0, n2 = 1, n3 = 0;
        System.out.print("" + n1 + " " + n2);

        try {
            for (int i = 2; i < numberOfFibonacci; ++i) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;
                System.out.print(" " + n3);
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}
