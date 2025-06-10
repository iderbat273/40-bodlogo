import java.util.Scanner;

public class Solution {

    static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int n = chars.length;
        
        int pivot = n - 2;
        while (pivot >= 0 && chars[pivot] >= chars[pivot + 1]) {
            pivot--;
        }
        
        if (pivot == -1) {
            return "no answer";
        }
        
        int swapIndex = n - 1;
        while (chars[swapIndex] <= chars[pivot]) {
            swapIndex--;
        }
        
        swap(chars, pivot, swapIndex);
        
        reverse(chars, pivot + 1, n - 1);
        
        return new String(chars);
    }
    
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < T; i++) {
            String w = scanner.nextLine();
            System.out.println(biggerIsGreater(w));
        }
        
        scanner.close();
    }
}