class FindInOrderedSet {
    public static void main(String[] args) {

            int[] array = {1,3,5,7,9,11,14,15,17};
            int target = 11;
            System.out.println((findTarget(array, target)) ? "YES" : "NO");

    }

    private static Boolean findTarget(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return true;
            } else if (array[i] > target) {
                return false;
            }
        }
        return false;
    }


}
