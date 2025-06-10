import java.util.*;

public class Solution {

    static int surfaceArea(int[][] A) {
        int H = A.length;
        int W = A[0].length;
        int total = 0;
        
        
        total += 2 * H * W;
        
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                
                if (j == 0) total += A[i][j];        
                else total += Math.abs(A[i][j] - A[i][j-1]);
                
                
                if (j == W-1) total += A[i][j];      
            }
        }
        
        
        for (int j = 0; j < W; j++) {
            for (int i = 0; i < H; i++) {
                
                if (i == 0) total += A[i][j];        
                else total += Math.abs(A[i][j] - A[i-1][j]);
                
                
                if (i == H-1) total += A[i][j];      
            }
        }
        
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        System.out.println(surfaceArea(A));
        scanner.close();
    }
}