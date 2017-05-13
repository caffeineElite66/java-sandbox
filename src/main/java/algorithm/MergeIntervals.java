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

    List<Interval> results = insert(new Interval(16, 17), intervals);

    System.out.println("");
    for (Interval i : results) {
      System.out.print(i);
    }
  }

  private static List<Interval> insert(Interval newInterval, List<Interval> intervals) {
    List<Interval> results = new ArrayList<>();
    results.add(newInterval);

    for (Interval interval : intervals) {
      // compare last interval in result vs current interval
      Interval lastInterval = results.get(results.size() - 1);

      if (isIntersect(lastInterval, interval)) {
        lastInterval.start = Math.min(lastInterval.start, interval.start);
        lastInterval.end = Math.max(lastInterval.end, interval.end);
      } else {
        if (lastInterval.start < interval.start) {
          results.add(results.size(), interval);
        } else {
          results.add(results.size() - 1, interval);
        }
      }
    }
    return results;
  }

  private static Boolean isIntersect(Interval int1, Interval int2) {
    if (
      (int1.start >= int2.start && int1.start <= int2.end) ||
      (int1.end >= int2.start && int1.end <= int2.end) ||
      (int2.start >= int1.start && int2.start <= int1.end) ||
      (int2.end >= int1.start && int2.end <= int1.end)
      ) {
      return true;
    }
    return false;
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
