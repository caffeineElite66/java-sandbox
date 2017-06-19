package ic44;

import java.util.*;

class TopScores {

    public static void main(String[] args) {

        int[] unsortedScores = {37, 89, 41, 65, 91, 53};
        final int HIGHEST_POSSIBLE_SCORE = 100;

        int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
        for (int v : sortedScores) {
            System.out.print(v + " ");
        }
        // sortedScores: [91, 89, 65, 53, 41, 37]
    }

    public static int[] sortScores(int[] scores, int max) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int current : scores) {
            map.put(current, (map.containsKey(current)) ? (map.get(current)) + 1 : 1);
        }
        ArrayList<Integer> sortedScores = new ArrayList<>();

        map.forEach( (key, value) -> {
            for (int i = 0; i < value; i++) {
                sortedScores.add(key);
            }
        });

        for (int i = 0; i < sortedScores.size(); i++) {
            scores[i] = sortedScores.get(i);
        }

        return scores;

    }
}
