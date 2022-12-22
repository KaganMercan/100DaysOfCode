package com.kaganmercan;

import java.util.Scanner;

/**
 * @author kaganmercan
 */
public class Day1Calculator {
    static Scanner sc = new Scanner(System.in);
    // Calculator with 4 arithmetic operation.
    public static void calculator() {
        // Variable initialization.
        char operator;
        double num1, num2, result = 0.0;
        try {
            System.out.print("Enter a first number: ");
            num1 = sc.nextInt();
            System.out.println();

            System.out.print("Enter a operator: ");
            operator = sc.next().charAt(0);
            System.out.println();

            System.out.print("Enter a second number: ");
            num2 = sc.nextInt();
            System.out.println();
            switch (operator) {
                case '+' -> {
                    result = num1 + num2;
                    System.out.println("Result = " + result);
                }
                case '-' -> {
                    result = num1 - num2;
                    System.out.println("Result = " + result);
                }
                case '*' -> {
                    result = num1 * num2;
                    System.out.println("Result = " + result);
                }
                case '/' -> {
                    result = num1 / num2;
                    System.out.println("Result = " + result);
                }
                default -> System.out.println("Given operator was not suitable.");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
