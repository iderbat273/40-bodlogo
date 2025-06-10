import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static Map<Integer, List<Integer>> tree;
    static int[] count;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        tree = new HashMap<>();
        count = new int[N+1];
        result = 0;
        
        
        for (int i = 1; i <= N; i++) {
            tree.put(i, new ArrayList<>());
        }
        
        
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        
        
        dfs(1, -1);
        
        System.out.println(result);
    }
    
    static void dfs(int node, int parent) {
        count[node] = 1; 
        
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
            }
        }
        
        
        if (node != 1 && count[node] % 2 == 0) {
            result++;
        }
    }
}