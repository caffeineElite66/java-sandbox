class ProductOfAll {
  public static void main (String[] args) {
          int[] array = {1, 7, 3, 4};
          ProductOfAll p = new ProductOfAll();
          System.out.println(84 + "," + 12 + "," + 28 + "," + 21);
          for (int a : p.productOfAll(array)) {
            System.out.print(a + ",");
          }
  }

  int[] productOfAll(int[] array) {
    int[] result = new int[array.length];
    // Calculate the numbers before index i
    int product = 1;
    for (int i = 0; i < array.length; i++) {
        result[i] = product;
        product = product * array[i];
    }
    // Calculate numbers after index i
    product = 1;
    for (int i = array.length-1; i >= 0; i--) {
      result[i] = result[i] * product;
      product = product * array[i];
    }
    return result;
  }

}
