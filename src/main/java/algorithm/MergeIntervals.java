// package algorithm;

import java.util.*;

/**
 * Given a list of sorted and disjoint closed interval, write a method to insert a new  interval into that list such that the list remains sorted and disjoined after the insertions.
 * e.g. [10, 15] [18, 21] [25,29]   after inserting [14,19] it becomes [10, 21] [25, 29] .
 * closed interval
 * the property of the list is disjoint and sorted, you have to maintain that after insertions. you are free to merge or split the intervals....
 *
 * cases:
 * 1. [1, 1000]
 * 2. [13, 14]
 * 3. [14, 19]
 * 4. [14, 26]
 * 5. [30, 32]
 */
public class MergeIntervals {

  public static void main (String[] args) {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(10,15));
    intervals.add(new Interval(18,21));
    intervals.add(new Interval(25,29));

    for (Interval i : intervals) {
      System.out.print(i);
    }
  }

  private static class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public String toString() {
      return "[" + this.start + "," + this.end + "] ";
    }
  }
}
