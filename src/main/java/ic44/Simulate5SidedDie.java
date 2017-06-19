package ic44;

import java.util.Random;

/**
 * Created by kevinliu on 6/12/17.
 */
public class Simulate5SidedDie {
    static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(random5() + ", ");
        }
    }

    static int random7() {
       return random.nextInt(7) + 1;
    }

    static int random5() {
        return random7() % 5 + 1;
    }
}
