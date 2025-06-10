import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        
        int start = scanner.nextInt();
        
        
        int totalWeight = primMST(graph, n, start);
        
        System.out.println(totalWeight);
    }
    
    static class Edge {
        int vertex;
        int weight;
        
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    static int primMST(List<List<Edge>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int[] minWeight = new int[n + 1];
        Arrays.fill(minWeight, Integer.MAX_VALUE);
        minWeight[start] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));
        
        int total = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.vertex;
            
            if (visited[u]) continue;
            visited[u] = true;
            total += current.weight;
            
            for (Edge edge : graph.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;
                if (!visited[v] && weight < minWeight[v]) {
                    minWeight[v] = weight;
                    pq.add(new Edge(v, minWeight[v]));
                }
            }
        }
        
        return total;
    }
}