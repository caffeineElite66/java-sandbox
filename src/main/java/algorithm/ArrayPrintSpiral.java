package algorithm;

/**
 * Print out a matrix in a spiral way
 */
public class ArrayPrintSpiral {

    public static void main (String[] args) {
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        ArrayPrintSpiral s = new ArrayPrintSpiral();
        s.printSprial(array);
    }

    private void printSprial(int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int currentRowCount = 0;
        int currentColCount = 0;
        int totalPrintCount = rowCount * colCount;
        int printCount = 0;


        while (printCount < totalPrintCount-1) {

            // print right
            for (int i = 0; i < colCount; i++) {
                print(array[currentRowCount][currentColCount]);
                currentColCount++;
                printCount++;
            }
            currentColCount--;
            currentRowCount++;
            rowCount--;

            // print down
            for (int i = 0; i < rowCount; i++) {
                print(array[currentRowCount][currentColCount]);
                currentRowCount++;
                printCount++;
            }
            currentRowCount--;
            currentColCount--;
            colCount--;

            // print left
            for (int i = 0; i < colCount; i++) {
                print(array[currentRowCount][currentColCount]);
                currentColCount--;
                printCount++;
            }
            currentRowCount--;
            currentColCount++;
            rowCount--;

            // print up
            for (int i = 0; i < rowCount; i++) {
                print(array[currentRowCount][currentColCount]);
                currentRowCount--;
                printCount++;
            }
            currentRowCount++;
            currentColCount++;
            colCount--;
        }
    }

    private void print(int str) {
        System.out.print(str + ", ");
    }

}
