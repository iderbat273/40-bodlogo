import java.io.*;
import java.util.*;

public class Solution {

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static String countLuck(char[][] grid, int k) {
        Point start = findStart(grid);
        int decisions = dfs(grid, start.x, start.y, new boolean[grid.length][grid[0].length]);
        return (decisions == k) ? "Impressed" : "Oops!";
    }

    private static Point findStart(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'M') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private static int dfs(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || 
            grid[x][y] == 'X' || visited[x][y]) {
            return 0;
        }
        if (grid[x][y] == '*') {
            return 0;
        }
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int paths = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && 
                grid[nx][ny] != 'X' && !visited[nx][ny]) {
                paths++;
            }
        }
        
        int decisions = (paths > 1) ? 1 : 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && 
                grid[nx][ny] != 'X' && !visited[nx][ny]) {
                int result = dfs(grid, nx, ny, visited);
                if (result >= 0) {
                    return decisions + result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] nm = br.readLine().split(" ");
            int N = Integer.parseInt(nm[0]);
            int M = Integer.parseInt(nm[1]);
            char[][] grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            int K = Integer.parseInt(br.readLine());
            bw.write(countLuck(grid, K) + "\n");
        }
        br.close();
        bw.close();
    }
}