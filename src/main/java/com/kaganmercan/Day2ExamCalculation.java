package com.kaganmercan;

import java.util.Scanner;

/**
 * @author kaganmercan
 */
public class Day2ExamCalculation {
    static Scanner sc = new Scanner(System.in);
    public static void midtermFinalExamCalculator() {
        // Variable initialization
        double midtermGrade, finalGrade, calculatedGrade;
        try {
            // Enumeration for University Exam Grade calculation.
            enum Grade {
                AA(100, "AA, RESULT = PASS"),
                BA(84, "BA, RESULT = PASS"),
                BB(69, "BB, RESULT = PASS"),
                CB(54, "CB, RESULT = PASS"),
                FF(49, "FF, RESULT = FAILED");
                private final double gradeValue;
                private final String gradeText;
                private Grade(int gradeValue, String gradeText) {
                    this.gradeValue = gradeValue;
                    this.gradeText = gradeText;
                }
                public static Grade getGrade(double value) {
                    Grade grade = null;
                    for(Grade g : values()) {
                        if(value <= g.gradeValue) {
                            grade = g;
                        }
                    }
                    return grade;
                }
                public String printGrade() {
                    return gradeText;
                }
            }
            while(true) {
                // User input operations.
                System.out.print("Enter midterm grade: ");
                midtermGrade = sc.nextInt();
                System.out.println();
                System.out.print("Enter final grade: ");
                finalGrade = sc.nextInt();
                System.out.println();
                if(midtermGrade == 0 || finalGrade == 0){
                    System.out.println("0 is a discipline error, exiting from the system.");
                    break;
                }
                // Midterm will affect %40, final will affect %60 for total grade calculation.
                calculatedGrade = (midtermGrade * 0.4) + (finalGrade * 0.6);
                System.out.println("*********************RESULT*********************");
                System.out.printf("Midterm and Final average grade: %f", calculatedGrade);
                System.out.println();
                System.out.println(Grade.getGrade(calculatedGrade).printGrade());
                System.out.println("************************************************");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.printf("Exception: %s", e);
        }
    }
}
