import java.util.Scanner;

public class OE4_Recursion {
    
    public static void main(String[] args) {
        
        /*Main code block for the Recursion program, with the following usage of node. Also the use of Switch Statement for easier use of the following programs*/
        Scanner sc = new Scanner(System.in);
        int sw;

        do {
            System.out.println("Please choose a following Recursion operation:");
            System.out.println("[1] RECURSION | Fibonacci series number");
            System.out.println("[2] RECURSION | Factorial of a number");
            System.out.println("[3] RECURSION | Reverse a number");
            System.out.println("[4] RECURSION | Reverse a word");
            System.out.println("[5] RECURSION | Tower of Hanoi");
            System.out.println("[0] Exit the program");
            System.out.print("Select your choice: ");
            sw = sc.nextInt();
            switch (sw) {

                case 1:
                    System.out.print("Enter the number of terms in the Fibonacci series: ");
                    int n = sc.nextInt();
                    System.out.print("Fibonacci series: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(fibonacci(i) + " ");
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Enter a positive integer: ");
                    int num = sc.nextInt();
                    System.out.println("Factorial of " + num + " = " + factorial(num));
                    break;

                case 3:
                    System.out.print("Enter a positive integer: ");
                    int x = sc.nextInt();
                    System.out.println("Reverse of " + x + " = " + reverseNumber(x, 0));
                    break;

                case 4:
                    System.out.print("Enter a word: ");
                    String word = sc.next();
                    System.out.println("Reverse of " + word + " = " + reverseWord(word));
                    break;

                case 5:
                    System.out.print("Enter the number of disks: ");
                    int disks = sc.nextInt();
                    System.out.println("Moves required to solve Tower of Hanoi:");
                    towerOfHanoi(disks, 'A', 'C', 'B');
                    break;

                case 0:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        } while (sw != 0);
        
        sc.close();
    }
    
    //This void block is for the recursive function to calculate Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    //This void block is for the recursive function to calculate factorial of a number
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num-1);
    }
    
    //This void block is for the recursive function to reverse a number
    public static int reverseNumber(int x, int rev) {
        if (x == 0) {
            return rev;
        }
        return reverseNumber(x / 10, rev * 10 + x % 10);
    }
    
    //This void block is for the recursive function to reverse a word
    public static String reverseWord(String word) {
        if (word.length() == 0) {
            return "";
        }
        return word.charAt(word.length()-1) + reverseWord(word.substring(0, word.length()-1));
    }
    
    //This void block is for the recursive function to solve Tower of Hanoi problem
    public static void towerOfHanoi(int disks, char source, char destination, char auxiliary) {
        if (disks == 1) {
            System.out.println(source + " -> " + destination);
            return;
        }
        towerOfHanoi(disks-1, source, auxiliary, destination);
        System.out.println(source + " -> " + destination);
        towerOfHanoi(disks-1, auxiliary, destination, source);
    }
}