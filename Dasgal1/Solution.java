import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();  
        scanner.nextLine(); 
        StringBuilder S = new StringBuilder(); 
        Stack<String> history = new Stack<>(); 
        for (int i = 0; i < Q; i++) {
            String[] operation = scanner.nextLine().split(" ");

            switch (operation[0]) {
                case "1":  // append
                    history.push(S.toString());  
                    S.append(operation[1]);      
                    break;

                case "2":  // delete
                    int k = Integer.parseInt(operation[1]);
                    history.push(S.toString());  
                    S.delete(S.length() - k, S.length()); 
                    break;

                case "3":  // print
                    int pos = Integer.parseInt(operation[1]);
                    if (pos > 0 && pos <= S.length()) {
                        System.out.println(S.charAt(pos - 1));
                    }
                    break;

                case "4":  // undo
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop()); 
                    }
                    break;
            }
        }

        scanner.close();
    }
}