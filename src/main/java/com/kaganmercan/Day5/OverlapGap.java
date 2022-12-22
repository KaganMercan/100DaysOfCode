package com.kaganmercan.Day5;

import java.util.*;

public class OverlapGap {

    public static Interval intervalInput() {
        // First take inputs from user to define
        //  start and end index of the interval list
        int start;
        int end;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start index: ");
        start = sc.nextInt();
        System.out.println();
        System.out.print("Enter end index: ");
        end = sc.nextInt();
        return new Interval(start, end);
    }

    enum IntervalMethod {
        // Enumeration for method calling
        Method1(0, 10, "Method 1 is called..."),
        Method2(13, 20, "Method 2 is called..."),
        Method3(21, 30, "Method 3 is called..."),
        Method4(31, 40, "Method 4 is called...");
        private final int startValue;
        private final int endValue;
        private final String methodText;

        // Enum constructor for
        IntervalMethod(int startValue, int endValue, String methodText) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.methodText = methodText;
        }

        // Attach methods to defined intervals.
        public static IntervalMethod getMethod(int startValue, int endValue) {
            IntervalMethod intervalMethod = null;
            for (IntervalMethod method : values()) {
                if (startValue < method.endValue && endValue > method.startValue) {
                    intervalMethod = method; // Call enumerated method according to given interval input.
                }
            }
            return intervalMethod;
        }

        public String printMethod() {
            return methodText;
        }
    }

    // End of the given interval if greater than start of the next interval that means there is an OVERLAP.
    // Example: [(1, 3) (2, 4)] -> Overlap should be occur.
    public static boolean isOverlapped(Interval intervalInput, List<Interval> intervals) {
        boolean isOverlap = false;
        Collections.sort(intervals); // If unsorted intervals added to List sort before.
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervalInput.start <= intervals.get(i).end && intervalInput.end > intervals.get(i).end) {
                isOverlap = true;
            }
        }
        return isOverlap;
    }

    public static boolean isGapped(Interval intervalInput, List<Interval> intervals) {
        boolean isGap = false;
        Collections.sort(intervals); // If unsorted intervals added to List sort before.
        for (int i = 0; i < intervals.size() - 1; i++) {
            // Check if input interval is in gap.
            // First condition for gap between intervals.
            // Second condition for gap if there is no such interval left.
            if ((intervalInput.start >= intervals.get(i).end && intervalInput.end <= intervals.get(i + 1).start) ||
                    (intervalInput.start > intervals.get(intervals.size() - 1).end && intervalInput.end > intervals.get(intervals.size() - 1).end)) {
                isGap = true;
            }
        }
        return isGap;
    }


    public static void manage() {
        List<Interval> intervals = Arrays.asList(
                new Interval(0, 10),
                new Interval(13, 20),
                new Interval(21, 30),
                new Interval(31, 40));
        Interval intervalInput = intervalInput();
        boolean isOverlapped = isOverlapped(intervalInput, intervals);
        boolean isGapped = isGapped(intervalInput, intervals);
        System.out.println("Is overlap occurred: " + isOverlapped);
        System.out.println("Is gap occurred: " + isGapped);
        if (!isOverlapped && !isGapped) {
            System.out.println(
                    IntervalMethod.getMethod(intervalInput.start, intervalInput.end).printMethod());
        }
    }
}
