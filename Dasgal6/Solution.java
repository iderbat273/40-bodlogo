import java.util.Scanner;

public class Solution {

    static int maxRegion(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, n, m);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }
    
    static int dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1; 
        int size = 1;
        
        
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                if (di == 0 && dj == 0) continue; 
                size += dfs(grid, i + di, j + dj, n, m);
            }
        }
        
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxRegion(grid));
        scanner.close();
    }
}