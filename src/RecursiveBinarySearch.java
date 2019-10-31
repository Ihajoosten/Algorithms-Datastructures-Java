public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 7;
        System.out.println(recursiveBinarySearch(arr, key, arr[0], arr[9]));
    }

    private static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high)
            return - 1;
        // setting a value of the middle of the low + high to int mid
        int mid = (low + high) / 2;

        // if the key is lesser than the value on position mid inside the list[], use recursion with mid - 1 as a new high value
        if (key < list[mid]) return recursiveBinarySearch(list, key, low, mid - 1);
        // if key equals the value on position mid inside the list[], return mid
        else if (key == list[mid]) return mid;
        // else use recursion with mid + 1 as a new low value
        else return recursiveBinarySearch(list, key, mid + 1, high);
    }
}
