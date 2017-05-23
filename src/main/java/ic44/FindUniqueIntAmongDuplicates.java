
class FindUniqueIntAmongDuplicates {

  public static void main(String[] args) {
    int[] list = {1,2,1,2,3,4,5,4,3,5,6,7,6,8,7};
    int odd = 0;
    for (int number : list) {
      odd ^= number;
    }
    System.out.println(odd);
  }
}
