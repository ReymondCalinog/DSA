import java.io.*;

public class PT1_DSAL {

    public static void main (String[] args) throws Exception {

        InputStreamReader inp1 = new InputStreamReader(System.in);
        BufferedReader inp2 = new BufferedReader(inp1);

        //This code block serves as the frontend of the program, with the following use of switch statement
        do{
            int sw;

            System.out.println("Choose [1] for Stack");
            System.out.println("Choose [2] for Queue");
            System.out.println("Choose [0] if you want to Exit the Program");

            System.out.print("\n[Please Select a Following Option]: ");
            sw = Integer.parseInt(inp2.readLine());

            switch(sw){

                case 1:
                {
                    //This code block is for when the users are inputting the following elements of the index
                    int arr [] = new int [5];

                    System.out.println("Enter 5 elements: ");
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = Integer.parseInt(inp2.readLine());
                    }

                    Stack Stack = new Stack();
                    System.out.println("Initial Stack is Empty : " + Stack.isEmpty());

                    Stack.push(arr[0]);
                    Stack.push(arr[1]);
                    Stack.push(arr[2]);
                    Stack.push(arr[3]);
                    Stack.push(arr[4]);
                    System.out.println("After Pushing...");

                    System.out.println("Element at the top of the stack " + "[" + Stack.peek() + "]");
                    Stack.display();
                    promptAndWait();

                    Stack.pop();
                    Stack.pop();
                    System.out.println("\nAfter Popping...");
                    
                    Stack.display();
                    promptAndWait();
                    break;
                }

                case 2:
                {
                    //This code block is for when the users are inputting the following elements of the index

                    int nums [] = new int [4];

                    System.out.println("Enter 4 elements: ");
                    for (int i = 0; i < nums.length; i++) {
                        //Reading the following array elements of an index from the user
                        nums[i] = Integer.parseInt(inp2.readLine());
                    }

                    Queue line = new Queue(4); 
            
                    System.out.println("Initial Queue:");
                    line.QueueDisplay(); 
                    line.Queue_Enqueue(nums[0]); 
                    line.Queue_Enqueue(nums[1]); 
                    line.Queue_Enqueue(nums[2]); 
                    line.Queue_Enqueue(nums[3]); 
            
                    System.out.println("After Enqueue:");
                    line.QueueDisplay(); 
                    line.QueueFront(); 
                    
                    line.Queue_Enqueue(90); 
                    line.QueueDisplay(); 
                    line.Queue_Dequeue(); 
                    line.Queue_Dequeue(); 
                    System.out.printf("\nQueue after two dequeue operations:"); 
                    line.QueueDisplay(); 
                    line.QueueFront(); 
                    promptAndWait();
                    break;
                }

                case 0:
                {
                    System.exit(0);
                    break;
                }
            }
        }while(true);
    }

   
    //This void function call is for the Stacking program, where it push first and pops the last one in
    public static class Stack{  
    int Top;            
    int MAX = 5;      
    int[] stack_array = new int[MAX]; 
    
        Stack()
        {            
            Top = -1;  
        }    

        boolean isEmpty()
        {          
            return (Top < 0);  
        }  

        boolean push (int val)
        {      
                if(Top == MAX-1) 
                {  
                    System.out.println("Stack Overflow");  
                    return false;  
                }  
                else 
                 {  
                    Top++;  
                    stack_array[Top]=val;  
                    return true;  
                }  
            }  

        boolean pop () 
        {            
            if (Top == -1) 
            {  
                System.out.println("Stack Underflow");  
                return false;  
            }  
            else   
            {  
                
                System.out.println("\nItem/s popped: " + stack_array[Top--]);  
                return true;  
            }  
        }  

        int peek()
        {
            return stack_array[Top];
        }

        void display () 
        {           
            System.out.println("Printing stacked elements...");  
            for(int i = Top; i>=0;i--) 
            {  
                System.out.print(stack_array[i] + " ");  
            }  
         }  

    } 

    //This void function call, is for transmission to another part of any code block
    public static void promptAndWait() throws Exception {
        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader z = new BufferedReader(x);
        String C;

        System.out.print("\nPress any Key to proceed");
        C = z.readLine();
    }

    //This void function call is for the Queue program, where it comes in first and comes out like a line
    public static class Queue { 
        private static int first, last, amt; 
        private static int queue[]; 
       
        Queue(int size) { 
            first = last = 0; 
            amt = size; 
            queue = new int[amt]; 
        } 
       
        static void Queue_Enqueue(int item)  { 
            if (amt == last) { 
                System.out.printf("\nQueue is full\n"); 
                return; 
            } 
       
            
            else { 
                queue[last] = item; 
                last++; 
            } 
            return; 
        } 
       
        
        static void Queue_Dequeue()  { 
            
            if (first == last) { 
                System.out.printf("\nQueue is empty\n"); 
                return; 
            } 
       
            
            else { 
                for (int i = 0; i < last - 1; i++) { 
                    queue[i] = queue[i + 1]; 
                } 
       
           
          
                if (last < amt) 
                    queue[last] = 0; 
       
                
                last--; 
            } 
            return; 
        } 
       
        
        static void QueueDisplay() 
        { 
            int i; 
            if (first == last) { 
                System.out.printf("Queue is Empty\n"); 
                return; 
            } 
       
            
            for (i = first; i < last; i++) { 
                System.out.printf(" %d = ", queue[i]); 
            } 
            return; 
        } 
       
        static void QueueFront() 
        { 
            if (first == last) { 
                System.out.printf("Queue is Empty\n"); 
                return; 
            } 
            System.out.printf("\nFront Element of the queue: %d", queue[first]); 
            return; 
        } 
    } 
}