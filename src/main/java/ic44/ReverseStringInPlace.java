
class ReverseStringInPlace {

  public static void main(String[] args) {
      String test = "Hello Kevin";
      System.out.println(reverse(test));
  }

  public static String reverse(String str) {

    char[] strChars = str.toCharArray();

    int startIndex = 0;
    int endIndex = strChars.length - 1;

    while (startIndex < endIndex) {

      // swap characters
      char temp = strChars[startIndex];
      strChars[startIndex] = strChars[endIndex];
      strChars[endIndex] = temp;

      // move towards middle
      startIndex++;
      endIndex--;
    }

    return new String(strChars);
  }
}
