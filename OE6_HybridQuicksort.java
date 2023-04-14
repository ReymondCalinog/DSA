import java.util.Scanner;

public class OE6_HybridQuicksort {

    //This is the main function, that will be used for the user's input for an array using scanner for the Hybrid Quicksort program
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Input the follow size of the elements of an array: ");
        int n = inp.nextInt();
        int[] arr = new int[n];
        System.out.print("\nInput the following elements/indices of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = inp.nextInt();
        }

        hybridQuicksort(arr, 0, n-1);

        System.out.print("\nHere is the output of the sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //This void function is for the hybrid quicksort algorithm that switches to insertion sort for small subarrays
    public static void hybridQuicksort(int[] arr, int left, int right) {
        if (left < right) {
            if (right - left < 10) {
                insertionSort(arr, left, right);
            } else {
                int pivotIndex = partition(arr, left, right);
                hybridQuicksort(arr, left, pivotIndex-1);
                hybridQuicksort(arr, pivotIndex+1, right);
            }
        }
    }

    //This void function is for the partition of an array around a pivot element
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int n = left;
        for (int j = left+1; j <= right; j++) {
            if (arr[j] < pivot) {
                n++;
                swap(arr, n, j);
            }
        }
        swap(arr, left, n);
        return n;
    }

   //This void function is for the insertion sort algorithm for small subarrays
    public static void insertionSort(int[] arr, int left, int right) {
        for (int n = left+1; n <= right; n++) {
            int key = arr[n];
            int j = n-1;
            while (j >= left && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    //This void function is for the utility function to swap two elements in an array
    public static void swap(int[] arr, int n, int j) {
        int temp = arr[n];
        arr[n] = arr[j];
        arr[j] = temp;
    }
}
