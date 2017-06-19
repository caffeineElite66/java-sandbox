package ic44;

public class SingleRifleCheck {


    public static void main(String[] args) {

        int[] half1 = {1,2,3,4,5};
        int[] half2 = {6,7,8,9,10,11};
        int[] shuffled = {1,2,6,3,7,4,8,9,10,5};

        System.out.println((isRifleOnce(half1, half2, shuffled)) ? "YES" : "NO");
    }

    static boolean isRifleOnce(int[] half1, int[] half2, int[] shuffledCards) {
        int half1Index = 0;
        int half2Index = 0;
        for (int current : shuffledCards) {
            if (half1.length - 1 >= half1Index && current == half1[half1Index]) {
                half1Index++;
            } else if (half2.length - 1 >= half2Index && current == half2[half2Index]) {
                half2Index++;
            } else {
                return false;
            }
        }
        if (half1Index != half1.length || half2Index != half2.length) return false;
        return true;
    }


}
