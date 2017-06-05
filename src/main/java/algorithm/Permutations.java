package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        perm("ABC");
//        System.out.println(getPermutations("ABCD"));
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
            perm(String.valueOf(prefix + body[0]), removeHead(body));
        }
    }

    private static char[] removeHead(char[] a) {
        return Arrays.copyOfRange(a, 1, a.length);
    }


    public static Set<String> getPermutations(String inputString) {

        // base case
        if (inputString.length() <= 1) {
            return new HashSet<String>(Arrays.asList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        // recursive call: get all possible permutations for all chars except last
        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);

        // put the last char in all possible positions for each of the above permutations
        Set<String> permutations = new HashSet<String>();
        for (String permutationOfAllCharsExceptLast : permutationsOfAllCharsExceptLast) {
            for (int position = 0; position <= allCharsExceptLast.length(); position++) {
                String permutation = permutationOfAllCharsExceptLast.substring(0, position) + lastChar + permutationOfAllCharsExceptLast.substring(position);
                permutations.add(permutation);
            }
        }

        return permutations;
    }
}
