import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] result = absolutePermutation(n, k);
            
            if (result == null) {
                System.out.println(-1);
            } else {
                for (int num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static int[] absolutePermutation(int n, int k) {
        int[] arr = new int[n];
        boolean[] used = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int pos1 = i - k;
            int pos2 = i + k;
            
            if (pos1 > 0 && pos1 <= n && !used[pos1]) {
                arr[i - 1] = pos1;
                used[pos1] = true;
            } else if (pos2 > 0 && pos2 <= n && !used[pos2]) {
                arr[i - 1] = pos2;
                used[pos2] = true;
            } else {
                return null;
            }
        }
        
        return arr;
    }
}