package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleSets {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>(Arrays.asList(1,2,2,3));
        List<List<Integer>> result = getPossibleSet(list);
        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.println(num + " ");
            }
            System.out.println(" ");
        }

    }

    private static List<List<Integer>> getPossibleSet(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            findSet(list.subList(i, list.size()), new ArrayList<Integer>(), result);
        }
        return result;
    }

    private static void findSet(List<Integer> list, List<Integer> options, List<List<Integer>> result) {

        if (list.size() < 2) {
            result.add(list);
            return;
        } else {
            result.add(list);
            // take the last item to options
            options.add(0, list.get(list.size() - 1));

            // call itself with last item gone,
            findSet(list.subList(0, list.size() - 1), options, result);

            // call itself with all options combo.
            for (int option : options) {
                // get the new option
                int newOption = list.get(list.size() - 1);

                // create new list with new option
                List newList = list.subList(0, list.size() - 2);
                newList.add(option);
                List<Integer> newOptions = new ArrayList<>();
                newOptions.addAll(options);
                newOptions.add(newOption);


                findSet(newList, newOptions, result);
            }
        }

    }
}
