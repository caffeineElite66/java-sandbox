import java.util.*;

class Fibonacci {

  private static HashMap<Integer, Integer> map = new HashMap<>();
  // fibo(2000) -- > 1392522469
  public static void main (String[] args) {
    System.out.println(fibonacci(2000));
    System.out.println(fibonacciFast(2000));
  }

  private static int fibonacci(int number) {
    if (number == 0) return 0;
    if (number == 1) return 1;
    if (number == 2) return 1;
    if (map.containsKey(number)) return map.get(number);
    int result = fibonacci(number - 1) + fibonacci(number - 2);
    map.put(number, result);
    return result;
  }

  private static int fibonacciFast(int number) {
    if (number == 0 || number == 1) return number;
    int prev = 1;
    int prevPrev = 0;
    int current = 0;
    for (int i = 1; i < number; i++) {
      current = prevPrev + prev;
      prevPrev = prev;
      prev = current;
    }
    return current;
  }
}
