import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class RecursiveStringPermutations {
    public static void main(String[] args) {
        String test = "ABC";
        perm("", test);
    }

    static void perm(String prefix, String s) {
        if (s.length() == 2) {
            System.out.println(prefix + s.charAt(0) + s.charAt(1));
            System.out.println(prefix + s.charAt(1) + s.charAt(0));
        }
        for (int i = 0; i < s.length(); i++) {
            char head = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1, s.length());
            perm(prefix + head, rest);
        }
    }

    public Set<String> getPermutations(String inputString) {

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
