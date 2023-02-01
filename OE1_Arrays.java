import java.util.Scanner;

public class OE1_Arrays {
    
    private static final int MAX = 100;
    
    public static void main(String[] args) {
        int[] input = new int[MAX];
        int inp, sw;
        Scanner IN = new Scanner(System.in);

        System.out.print("Please input any number for the index/indices of the array: ");
        inp = IN.nextInt();

        //This code block is for initializing the array elements
        for (int i = 0; i < inp; i++) {
            System.out.print("Register an index [" + i + "] number:");
            input[i] = IN.nextInt();
        }

        do {
            //This code block is for displaying and runnng separately of all the array operations
            System.out.print("\nArray list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.print(" }\n");

            // Display the menu
            System.out.println("[1] Search for an Array");
            System.out.println("[2] Delete an element within the Array");
            System.out.println("[3] Update an element within the Array");
            System.out.println("[4] Traverse/Traversing Arrays");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");
            sw = IN.nextInt();

            switch (sw) {
                case 1 -> {
                    search(input, inp);
                    promptAndWait();
                }
                
                case 2 -> {
                    delete(input, inp);
                    promptAndWait();
                }
                
                case 3 -> {
                    update(input, inp);
                    promptAndWait();
                }
                    
                case 4 -> {
                    traverse(input, inp);
                    promptAndWait();
                }
    
                case 0 -> {
                    System.out.println("The program will now be closed.");
                    return;
                }
                
                default -> {
                    System.out.println("Wrong Input, please input a right number again.");
                    promptAndWait();
                }
            }
            
        } while (true);
    }
    
    //This code block is for running the Search Array operation program
    public static void search(int[] input, int inp) {
        int searchIndex;
        boolean found = false;
        do {
            System.out.print("Enter an index to find the Element: ");
            Scanner sc = new Scanner(System.in);
            searchIndex = sc.nextInt();
            if (searchIndex >= 0 && searchIndex < inp) {
                System.out.println("Element at index " + searchIndex + " is " + input[searchIndex]);
                found = true;
            } else {
                System.out.println("Invalid index to search, please try again.");
            }
        } while (!found);
    }


    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    
    //This void code block is for deleting a number within the array list set
    public static void delete(int[] input, int inp) {
        Scanner sc = new Scanner(System.in);
        int deleteIndex;
        boolean isDeleted = false;
        do {
            System.out.print("Array list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.println(" }");

            System.out.print("Enter the index to delete: ");
            deleteIndex = sc.nextInt();

            if (deleteIndex >= 0 && deleteIndex < inp) {
                input[deleteIndex] = 0;
                System.out.println("Element at index " + deleteIndex + " is deleted");
                isDeleted = true;
            } else {
                System.out.println("Invalid index to delete, please try again.");
            }
        } while (!isDeleted);
    }


    //This void code block is for updating or adding a number within the array list set
    public static void update(int[] input, int inp) {
            
            Scanner sc = new Scanner(System.in);
            while (true) {
                
                System.out.print("Array list {");
                for (int x = 0; x < inp; x++) {
                    System.out.print(" " + input[x]);
                }
                System.out.println(" }");
        
                
                System.out.print("Enter the index to update: ");
                int updateIndex = sc.nextInt();
                
                if (updateIndex >= 0 && updateIndex < inp) {
                   
                    System.out.print("Enter the number to update: ");
                    input[updateIndex] = sc.nextInt();
                    System.out.println("Element at index " + updateIndex + " is updated.");
                    break;
                } else {
                    
                    System.out.println("Invalid index to update, please try again");
                }
            }
        }
    
    

    //This void code block is for traversing the numbers within the array
     public static void traverse(int[] input, int inp) {
            System.out.println("Array list:");
            for(int x = 0; x < inp; x++) {
            
            System.out.printf("Number on index contains value of %d  \n", x, input[x]);
        }
    }
}