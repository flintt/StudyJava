package study.studyjava;
// 说明inner class的使用

public class DataStructure {

    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {

        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator(); // this指的是DataStructure？
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface


    private class EvenIterator implements DataStructureIterator {
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        public boolean hasNext() {
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]); // 这里手动boxing了，必要
//            Integer retValue = arrayOfInts[nextIndex]; // 直接访问arrayOfInts
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    } // 这个iterator是inner class。实现一个iterator要有hasNext，next两个method。hasNext来判断还有没有符合的元素，next来实现返回下一个值。

    public static void main(String s[]) {
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}