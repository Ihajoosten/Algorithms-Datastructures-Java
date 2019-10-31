import java.util.Arrays;

public class BucketSort {

    public static void bucketSort(int[] array, int maxValue) {
        int[] bucket = new int[maxValue + 1];

        // A foreach-loop to put a value inside the bucket[] form the int[]
        for (int value : array) {
            bucket[value]++;
        }

        int position = 0;

        // Nested for-loop
        // Outer-loop will continue to iterate when in 'i' is lesser than length of int[] array
        for (int i = 0; i < bucket.length; i++) {
            // Inner-loop will continue to iterate when int 'j' is lesser than the value of position 'i' in bucket[]
            for (int j = 0; j < bucket[i]; j++) {
                array[position++] = i;
            }
        }
    }
}
