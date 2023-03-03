import java.util.Scanner;

public class OE3_Linklist {
    private static final Scanner scr = new Scanner(System.in);
    private Node head;

    /*Main code block for the Link List program, with the following usage of node. Also the use of Switch Statement for easier use of the following programs*/

    public static void main(String[] args) {
        OE3_Linklist list = new OE3_Linklist();

        while (true) {
            System.out.println("Please choose a following Node operation:");
            System.out.println("[1] LINKED LIST | Insert at Beginning");
            System.out.println("[2] LINKED LIST | Insert at the End");
            System.out.println("[3] LINKED LIST | Insert a Node, after a specific Node");
            System.out.println("[4] Print your LINKED LIST of Nodes");
            System.out.println("[0] Exit");
            System.out.print("Please enter your input: ");
            int sw = scr.nextInt();
        
            switch (sw) {

                case 1:
                    System.out.print("Enter the following numbers to insert (should be separated by space): ");
                    scr.nextLine();
                    String insBeg = scr.nextLine();
                    
                    if (insBeg.isEmpty()) {
                        System.out.println("No input has been provided.");
                        return;
                    }
                    
                    String[] insertBegNum = insBeg.split(" ");
                    for (int i = 0; i < insertBegNum.length; i++) {
                        try {
                            int data = Integer.parseInt(insertBegNum[i]);
                            list.insertAtEnd(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input: " + insertBegNum[i] + " is not an integer.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter the following numbers to insert (should be separated by space): ");
                    scr.nextLine();
                    String insEnd = scr.nextLine();
                    
                    if (insEnd.isEmpty()) {
                        System.out.println("No input has been provided.");
                        return;
                    }
                    
                    String[] insertEndNum = insEnd.split(" ");
                    for (int i = 0; i < insertEndNum.length; i++) {
                        try {
                            int data = Integer.parseInt(insertEndNum[i]);
                            list.insertAtEnd(data);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input: " + insertEndNum[i] + " is not an integer.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter a following number to insert ");
                    int data3 = scr.nextInt();
                    System.out.print("Enter a node after which to insert: ");
                    int nodeData = scr.nextInt();
                    Node prevNode = list.searchNode(nodeData);
                    list.insertAfterNode(prevNode, data3);
                    break;
                case 4:
                    list.printList();
                    promptAndWait();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

     //Declaration of the Node class variable, to be used for the program
     private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    //This void block is for the "Insertion at the Beginning" Node
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //This void block is for the "Insertion at the End" Node
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    //This void block is for the "Insert a Node, after a specific Node"
    public void insertAfterNode(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    //This void block is for printing the LINKED LIST of Nodes, that the following user has inputted
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node searchNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current;
    }

    //This void code block, server as a transmission to another code block
    public static void promptAndWait() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Press any key to continue...");
        scn.nextLine();
    }

}