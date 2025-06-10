import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        if (Arrays.equals(arr, sorted)) {
            System.out.println("yes");
            return;
        }
        
        int left = 0;
        while (left < n && arr[left] == sorted[left]) {
            left++;
        }
        
        int right = n - 1;
        while (right >= 0 && arr[right] == sorted[right]) {
            right--;
        }
        
        swap(arr, left, right);
        if (Arrays.equals(arr, sorted)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1));
            return;
        }
        swap(arr, left, right); 
        
        reverse(arr, left, right);
        if (Arrays.equals(arr, sorted)) {
            System.out.println("yes");
            System.out.println("reverse " + (left + 1) + " " + (right + 1));
            return;
        }
        
        System.out.println("no");
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}