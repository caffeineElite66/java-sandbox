package ic44;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String s = "Hello Kevin. How are you doing today? You don't look so good kevin. Why is that?";
        System.out.println(getCount(s));
    }

    private static Map<String, Integer> getCount(String words) {
        Map<String, Integer> map = new HashMap<>();
        String[] wordList = words.split(" ");
        for (String word : wordList) {
            word = word.toLowerCase();
            StringBuilder s = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isAlphabetic(word.charAt(i))) {
                    s.deleteCharAt(i);
                }
            }
            word = s.toString();
            map.put(word, (map.containsKey(word)) ? map.get(word) + 1 : 1);
        }
        return map;
    }
}
