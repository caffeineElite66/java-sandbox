// package ic44;

class FindRotationPoint {

  public static void main (String[] args) {
    char[] array = {'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e'};
    int index = findRotationPoint(array);
    System.out.println("index: " + index + " : " + array[index]);
  }

  private static int findRotationPoint(char[] array) {
    int start = 0;
    int end = array.length - 1;
    int middleIndex = -1;
    System.out.println(start + " : " + middleIndex + " : " + end);
    while (start < end) {
      middleIndex = (end - start) / 2;
      System.out.println(start + " : " + middleIndex + " : " + end);
      if (array[middleIndex] < 'a') {
        start = middleIndex;
      } else if (array[middleIndex] > 'a') {
        end = middleIndex;
      } else {
        return middleIndex;
      }
    }
    return middleIndex;
  }
}
