import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        Stack<Integer> stack1 = new Stack<>();  
        Stack<Integer> stack2 = new Stack<>();  
        
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            
            switch (type) {
                case 1:  
                    int x = scanner.nextInt();
                    stack1.push(x);
                    break;
                    
                case 2:  
                    if (stack2.isEmpty()) {
                       
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    stack2.pop();
                    break;
                    
                case 3:  
                    if (stack2.isEmpty()) {
                        
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    System.out.println(stack2.peek());
                    break;
            }
        }
        
        scanner.close();
    }
}