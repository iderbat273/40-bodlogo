import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[] data;
    static List<List<Integer>> tree;
    static int totalSum;
    static int minDiff;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        data = new int[n + 1];
        totalSum = 0;
        
        for (int i = 1; i <= n; i++) {
            data[i] = scanner.nextInt();
            totalSum += data[i];
        }
        
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        minDiff = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        dfs(1);
        
        System.out.println(minDiff);
    }
    
    private static int dfs(int node) {
        visited[node] = true;
        int sum = data[node];
        
        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                sum += dfs(neighbor);
            }
        }
        
        int currentDiff = Math.abs(totalSum - 2 * sum);
        if (currentDiff < minDiff) {
            minDiff = currentDiff;
        }
        
        return sum;
    }
}