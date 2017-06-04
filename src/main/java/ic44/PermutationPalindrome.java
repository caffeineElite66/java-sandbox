import java.util.*;

class PermutationPalindrome {
  public static void main(String[] args) {
    String test = "abcbaa";
    System.out.println(canBePalindrome(test) ? "YES" : "NO");
  }

  static boolean canBePalindrome(String words) {
    Set<Character> listOfChars = new HashSet<>();
    for (int i = 0; i < words.length(); i++) {
      char current = words.charAt(i);
      if (listOfChars.contains(current)) {
        listOfChars.remove(current);
      } else {
        listOfChars.add(current);
      }
    }
    return (listOfChars.size() > 1) ? false : true;
  }
}
