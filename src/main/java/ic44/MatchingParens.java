import java.util.*;

class MatchingParens {

  public static void main(String[] args) {
    String test = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
    System.out.println(findMatching(test, 10));
    System.out.println(findMatching2(test, 10));
  }

  public static int findMatching(String strings, int openIndex) {
    Stack<Integer> stack = new Stack<>();
    for (int i = openIndex+1; i < strings.length(); i++) {
      char currentChar = strings.charAt(i);
      if (currentChar == '(') {
        System.out.println("pushing " + currentChar + " at " + i);
        stack.push(1);
      }

      if (currentChar == ')') {
        if (stack.isEmpty()) {
          return i;
        }
        System.out.println("popping " + currentChar + " at " + i);
        stack.pop();
      }
    }
    return -1;
  }

  public static int findMatching2(String strings, int openIndex) {
    int counts = 0;
    for (int i = openIndex+1; i < strings.length(); i++) {
      char currentChar = strings.charAt(i);
      if (currentChar == '(') {
        counts += 1;
      } else if (currentChar == ')') {
        if (counts == 0) return i;
        counts -= 1;
      }
    }
    return -1;
  }
}
