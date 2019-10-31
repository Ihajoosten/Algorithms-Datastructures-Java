public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 10;
        System.out.println(binarySearch(array, key));
    }

    public static int binarySearch(int[] array, int key) {

        // local low variable set to 0
        int low = 0;
        // local variable high set to the length of the array - 1
        // lenght - 1 contains highest index due that is starts with 0
        int high = array.length - 1;

        // while low is lesser or equal to high, run the code inside the body
        while (low <= high) {
            // local variable middle set to the index that is in the middle of the array
            int middle = low + (high - low) / 2;

            // if key is lower than value on position middle of array, int high becomes middle - 1
            if (key < array[middle]) high = middle - 1;
            // if key is higher than value on position middle of array, int low becomes middle + 1
            else if (key > array[middle]) low = middle + 1;
            // else return value of middle
            else return middle;
        }
        return -1;
    }
}
