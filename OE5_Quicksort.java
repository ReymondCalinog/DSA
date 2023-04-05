import java.util.Scanner;

public class OE5_Quicksort{

    //This is the main function, that will be used for the user's input for an array using scanner for the Quicksort program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
            System.out.print("Input the follow size of the elements of an array: ");
            int inp = sc.nextInt();
            
            int[] arr = new int[inp];
            System.out.print("\nInput the following elements/indices of the array: ");
            for (int i = 0; i < inp; i++) {
                arr[i] = sc.nextInt();
            }
            
            quickSort(arr, 0, inp-1);
            
            System.out.print("\nHere is the output of the sorted array: ");
            for (int i = 0; i < inp; i++) {
                System.out.print(arr[i] + " ");
            }
        }
       
        
    //This void function is for the Quicksort function with the use of partition
    public static void quickSort(int[] arr, int min, int max) {
            if (min < max) {
                int pivotIndex = partition(arr, min, max);
                quickSort(arr, min, pivotIndex-1);
                quickSort(arr, pivotIndex+1, max);
            }
        }
    
    //This void function is for the switching places of an index within the array that will be used for Quicksort
    public static int partition(int[] arr, int min, int max) {
            int pivot = arr[max];
            int i = min - 1;
            
            for (int j = min; j <= max-1; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            
            int temp = arr[i+1];
            arr[i+1] = arr[max];
            arr[max] = temp;
            
            return i+1;
        }
}