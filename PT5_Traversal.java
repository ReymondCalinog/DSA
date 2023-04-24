import java.util.Scanner;

public class PT5_Traversal {

//This class is for the declaration of the Node function
    public static class Node{
        int data;
        Node left, right;

        public Node(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

//This is the main function of the program, here it will ask the user for input and run the program that is being asked
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("\nPlease input the following size of Node: ");
        int j = inp.nextInt();

        Node root = null;
        for (int i = 0; i < j; i++) {
            System.out.print("Please input the following elements of the Node " + (i + 1) + ": ");
            int val = inp.nextInt();
            root = insert(root, val);
        }

        System.out.println("\n[1] In-order Traversal");
        System.out.println("[2] Pre-order Traversal");
        System.out.println("[3] Post-order Traversal");
        System.out.print("\nSelect an Option: ");
        int option = inp.nextInt();
        switch (option) {
            case 1:
                System.out.println("\nThe result for the In-order Traversal Order:");
                inOrder(root);
                break;
            case 2:
                System.out.println("\nThe result for the Pre-order Traversal Order:");
                preOrder(root);
                break;
            case 3:
                System.out.println("\nThe result for the Post-order Traversal Order:");
                postOrder(root);
                break;
            default:
                System.out.println("\nInput is Invalid, please try again according to the choices");
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    //This void function is for the inOrder process of traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //This void function is for the preOrder process of traversal
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //This void function is for the postOrder process of traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}