package algorithm;

public class FindPrime {

    public static void main (String[] args) {
        int number = 458339482;
        System.out.println((isPrime(number)) ? "YES" : "NO");
    }

    private static boolean isPrime(int number) {
        if (number == 1) return true;
        double upperBound = Math.sqrt(number);
        for (int i = 2; i <= upperBound; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
