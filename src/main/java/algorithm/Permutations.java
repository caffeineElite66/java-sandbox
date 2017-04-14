package algorithm;
import java.util.*;

public class Permutations {

  public static void main(String[] args) {
    perm("ABC");
  }

  private static void perm(String a) {
    perm("", a.toCharArray());
  }

  private static void perm(String prefix, char[] body) {

    if (body.length == 2) {
      System.out.println(prefix + body[0] + body[1]);
      System.out.println(prefix + body[1] + body[0]);
    }

    for (int i = 0; i < body.length; i++) {
      char tempHead = body[0];
      body[0] = body[i];
      body[i] = tempHead;
      perm(String.valueOf(prefix+body[0]), removeHead(body));
    }
  }

  private static char[] removeHead(char[] a) {
    return Arrays.copyOfRange(a, 1, a.length);
  }
}
