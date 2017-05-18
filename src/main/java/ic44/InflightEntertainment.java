
import java.util.Arrays;

class InflightEntertainment {

  public static void main (String[] args) {
    int[] numbers = {1, 3, 4, 2, 3,1 ,6, 7,8,6};
    System.out.println((findTwo(100, numbers) ? "YES" : "NO"));
  }

  private static boolean findTwo(int target, int[] numbers) {
    Arrays.sort(numbers);
    for (int n : numbers) System.out.print(n + ",");
    int start = 0;
    int end = numbers.length - 1;
    while (start < end) {
      int sum = numbers[start] + numbers[end];
      if (sum == target) return true;
      else if (sum < target) start++;
      else if (sum > target) end--;
    }
    return false;
  }
}
