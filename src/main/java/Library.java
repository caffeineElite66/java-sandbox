/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import java.util.HashSet;
import java.util.Set;

public class Library {

    static Set<String> permutationSet = new HashSet<>();

    public static void main(String[] args) {
        String s = "ABCD";
        perm("", s);
        System.out.println(permutationSet);

    }

    public static void perm(String head, String body) {

        if (body.length() == 2) {
            permutationSet.add(head + body);
            permutationSet.add(head + body.charAt(1) + body.charAt(0));
        }

        for (int i = 0; i < body.length(); i++) {
            char newHead = body.charAt(i);
            String newBody = body.substring(0, i) + body.substring(i + 1, body.length());
            perm(head + newHead, newBody);
        }
    }
}
