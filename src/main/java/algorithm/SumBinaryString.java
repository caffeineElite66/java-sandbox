package algorithm;

import java.util.*;

class sumBinaryStrings {

  public static void main (String[] args) {
    String s1 = "101101";
    String s2 = "10001";
    System.out.println(sumBinaryStrings(s1, s2));
  }

  private static String sumBinaryStrings(String s1, String s2) {

      ArrayList<Character> list1 = new ArrayList<>();
      ArrayList<Character> list2 = new ArrayList<>();

      for (Character c : s1.toCharArray()) list1.add(c);
      for (Character c : s2.toCharArray()) list2.add(c);

      ArrayList<Integer> result = new ArrayList<Integer>();
      int carry = 0;

      while (!list1.isEmpty() || !list2.isEmpty()) {
        // remove last index
        int a = (list1.isEmpty()) ? 0 : Character.getNumericValue(list1.remove(list1.size() - 1));
        int b = (list2.isEmpty()) ? 0 : Character.getNumericValue(list2.remove(list2.size() - 1));

        int answer = (a + b + carry);

        if (answer == 3) {
          answer = 1;
          carry = 1;
        } else if (answer == 2){
          answer = 0;
          carry = 1;
        } else {
          carry = 0;
        }

        result.add(0, answer);
      }

      if (carry == 1) result.add(0, 1);

      String stringAnswer = "";
      for (int digit : result) {
        stringAnswer += String.valueOf(digit);
      }
      return stringAnswer;
  }

}
