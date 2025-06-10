import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        
        for (int testCase = 0; testCase < c; testCase++) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int m = scanner.nextInt();
            
            
            boolean[][] graph = new boolean[n+1][n+1];
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u][v] = true;
                graph[v][u] = true;
            }
            
            int maxCrabs = solveCrabGraphs(graph, n, t);
            System.out.println(maxCrabs);
        }
    }
    
    static int solveCrabGraphs(boolean[][] graph, int n, int t) {
        
        int size = 2*n + 2;
        int[][] capacity = new int[size][size];
        
        
        for (int i = 1; i <= n; i++) {
            capacity[0][i] = 1;
        }
        
        
        for (int i = 1; i <= n; i++) {
            capacity[n+i][2*n+1] = t;
        }
        
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) {
                    capacity[i][n+j] = 1;
                }
            }
        }
        
        
        int maxFlow = maxFlow(capacity, 0, 2*n+1, size);
        
        return maxFlow;
    }
    
    static int maxFlow(int[][] capacity, int source, int sink, int size) {
        int[][] residual = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(capacity[i], 0, residual[i], 0, size);
        }
        
        int[] parent = new int[size];
        int maxFlow = 0;
        
        while (bfs(residual, source, sink, parent, size)) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }
            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }
    
    static boolean bfs(int[][] residual, int source, int sink, int[] parent, int size) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v = 0; v < size; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    if (v == sink) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        
        return false;
    }
}