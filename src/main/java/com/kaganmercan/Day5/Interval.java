package com.kaganmercan.Day5;

/**
 * @author kaganmercan
 */

public class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval interval) {
        if (start < interval.start) {
            return -1;
        } else if (start == end) {
            return 0;
        } else {
            return 1;
        }
    }
}
