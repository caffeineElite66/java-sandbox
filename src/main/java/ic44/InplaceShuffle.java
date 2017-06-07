package ic44;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InplaceShuffle {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(array).forEach(System.out::print);
        IntStream.range(0, 10).forEach(i -> {
            inplaceShuffle(array);
            System.out.println("");
            Arrays.stream(array).forEach(System.out::print);
        });

    }

    private static void inplaceShuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i >= 1; i--) {
            int swapIndex = random.nextInt(i);
            int temp = array[i];
            array[i] = array[swapIndex];
            array[swapIndex] = temp;
        }
    }
}
