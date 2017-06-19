
package ic44;

import java.util.HashSet;
import java.util.Set;

class WhichAppearsTwice {

    public static void main(String[] args) {
        int[] listOfInt = {1,2,3,4,5,6,7,8,9,1};
        System.out.println(findDuplicate(listOfInt));
        System.out.println(findDuplicateWithSum(listOfInt));
    }

    static int findDuplicate(int[] listOfInt) {
        Set<Integer> set = new HashSet<>();
        for (int v : listOfInt) {
            if (set.contains(v)) {
                return v;
            } else {
                set.add(v);
            }
        }
        return -1;
    }

    static int findDuplicateWithSum(int[] listOfInt) {
        int n = listOfInt.length;
        int sum = ((n*n) + n) / 2;
        int sum2 = 0;
        for (int v : listOfInt) {
            sum2 += v;
        }

        return Math.abs(sum2 - sum);
    }
}
