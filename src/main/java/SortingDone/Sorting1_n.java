package SortingDone;

public class Sorting1_n{

    public static void main(String[] args) {

        int[] arr = {6, 3, 9, 8, 2, 5};

        quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    /// Quick Sort:-
    //     Choose pivot
    //          ↓
    //      Put smaller elements left
    //     Put larger elements right
    //          ↓
    //     Pivot reaches correct position
    //          ↓
    //     Repeat for left + right
    // Recursively sort left and right parts
    public static void quickSort(int[] arr, int s, int e) {

        // Stop when 0 or 1 element
        if (s >= e) {
            return;
        }

        // Put pivot at correct position
        int pidx = partition(arr, s, e);

        // Sort left part
        quickSort(arr, s, pidx - 1);

        // Sort right part
        quickSort(arr, pidx + 1, e);
    }

    // Partition using last element as pivot
    public static int partition(int[] arr, int s, int e) {

        int pivot = arr[e];

        // End of smaller-elements region
        int i = s - 1;

        // Scan elements before pivot
        for (int j = s; j < e; j++) {

            if (arr[j] <= pivot) {

                i++;

                // Move smaller element to left
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Put pivot in correct position
        i++;

        int temp = arr[i];
        arr[i] = arr[e];
        arr[e] = temp;

        return i;
    }
}