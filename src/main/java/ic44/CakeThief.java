
class CakeThief {

  pulic static void main (String[] args) {
    CakeType[] cakeTypes = new CakeType[]{
      new CakeType(7, 160),
      new CakeType(3, 90),
      new CakeType(2, 15),
    };

    int capacity = 20;

    maxDuffelBagValue(cakeTypes, capacity);


  }

  public static void maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
    // find max 
  }

  class CakeType {
    int weight;
    int value;
    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }
  }

}
