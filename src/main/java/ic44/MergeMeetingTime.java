import java.util.*;
import java.util.stream.*;

class MergeMeetingTime {

  public static void main (String[] args) {
    List<Meeting> list = new ArrayList<>();
    MergeMeetingTime m = new MergeMeetingTime();
    list.add(m.new Meeting(0,1));
    list.add(m.new Meeting(3,5));
    list.add(m.new Meeting(4,8));
    list.add(m.new Meeting(10,12));
    list.add(m.new Meeting(9,10));
    List<Meeting> result = mergeRange2(list);
    for (Meeting meeting : result) {
      System.out.println(meeting);
    }
  }

  private static List<Meeting> mergeRange(List<Meeting> meetings) {
    ArrayList<Meeting> newList = new ArrayList<Meeting>();
    for (Meeting m : meetings) {
      boolean isNew = true;
      for (int i = 0; i < newList.size(); i++) {
        Meeting existingMeeting = newList.get(i);
        // if startTime fall between existing start-end
        if (existingMeeting.startTime <= m.startTime && existingMeeting.endTime >= m.startTime) {
          existingMeeting.endTime = Math.max(m.endTime, existingMeeting.endTime);
          isNew = false;
        } else if (existingMeeting.startTime <= m.endTime && existingMeeting.endTime >= m.endTime) {
          existingMeeting.startTime = Math.min(m.startTime, existingMeeting.startTime);
          isNew = false;
        } else if (existingMeeting.startTime <= m.startTime && existingMeeting.endTime >= m.endTime) {
          isNew = false;
        }
      }
      if (isNew) newList.add(m);
    }
    return newList;
  }

  /**
   * Sort first
   * then merge
   */
  private static List<Meeting> mergeRange2(List<Meeting> meetings) {
    Comparator<Meeting> compByStart = (p1, p2) -> p1.startTime - p2.startTime;
    Comparator<Meeting> compByEnd = (p1, p2) -> p1.endTime - p2.endTime;
    List<Meeting> newMeeting = meetings.stream().sorted(compByStart.thenComparing(compByEnd)).collect(Collectors.toList());

    List<Meeting> merge = new ArrayList<Meeting>();
    merge.add(newMeeting.get(0));
    for (Meeting m : newMeeting) {
      Meeting existing = merge.get(merge.size() - 1);
      if (existing.startTime <= m.startTime && existing.endTime >= m.startTime) {
        existing.endTime = Math.max(m.endTime, existing.endTime);
      } else {
        merge.add(m);
      }
    }
    return merge;
  }

  /**
   * support class
   */
  public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
  }
}

/*


*/
