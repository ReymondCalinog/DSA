import java.util.Scanner;

public class OE2_SortArray {

    /*Main code block for the Bubble and Insertion Sort Array programs, with the use of Switch Statement
    for easier use of the following programs*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your prefer size of the Array: ");
        int n = sc.nextInt();
        int[] ary = new int[n];

        System.out.println("Enter the elements or numbers of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the index [" + i + "] number:");
            ary[i] = sc.nextInt();
        }

        do {
            System.out.println("Choice [1] for Bubble Sort");
            System.out.println("Choice [2] for Insertion Sort");
            System.out.println("Choice [0] to Exit the Program");
            System.out.println("Enter your choice: ");
            int sw = sc.nextInt();

            switch (sw) {
                case 1:
                    bubbleSort(ary);
                    promptAndWait();
                    break;
                case 2:
                    insertionSort(ary);
                    promptAndWait();
                    break;
                case 0:
                    System.out.println("The program will now be closed.");
                    sc.close();
                    return;
                default:
                    System.out.println("Wrong Input, please input a right number again.");
                    promptAndWait();
            }
        } while (true);
    }


    //This void code block is for the Bubble Sort Array program
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int iteration = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                iteration++;
            }
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    //This void code block is for the Insertion Sort Array program
    static void insertionSort(int[] arr) {
        int n = arr.length;
        int iteration = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                iteration++;
            }
            arr[j + 1] = key;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner IN = new Scanner(System.in);
        IN.nextLine();
    }

    static void print(String str){
        System.out.println(str);
    }

}
