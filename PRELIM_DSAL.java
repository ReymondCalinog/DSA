//Reymond Y. Calinog
//BSCS 2-1
//PRELIM (DSAL)

import java.util.Arrays;
import java.util.Scanner;

public class PRELIM_DSAL{

    /*Main code block for the Bubble and Insertion Sort Array programs with the use of String as Indices, 
    with the use of Switch Statement for easier use of the following programs*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MAX = 4;
        String[] stringArray = new String[MAX];

        System.out.println("Enter the string elements of the array");
        for (int i = 0; i < MAX; i++) {
            System.out.print("Enter the string [" + i + "] index: ");
            stringArray[i] = sc.nextLine();
        }

        do {
            System.out.println("");
            System.out.println("Choice [1] for Bubble Sort");
            System.out.println("Choice [2] for Insertion Sort");
            System.out.println("Choice [0] to Exit the Program");
            System.out.print("Enter your choice: ");
            int sw = sc.nextInt();

            switch (sw) {
                case 1:
                    bubbleSort(stringArray);
                    promptAndWait();
                    break;
                case 2:
                    insertionSort(stringArray);
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
    public static void bubbleSort(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Sorted List: " + Arrays.toString(array));
    }

    //This void code block is for the Insertion Sort Array program
    public static void insertionSort(String[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        System.out.println("");
        System.out.println("Sorted List: " + Arrays.toString(array));
    }

    //This void code block, server as a transmission to another code block
    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}