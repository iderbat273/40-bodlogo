import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            Map<Integer, Integer> ladders = new HashMap<>();
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                ladders.put(start, end);
            }
            
            
            Map<Integer, Integer> snakes = new HashMap<>();
            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                snakes.put(start, end);
            }
            
            
            int[] moves = new int[101];
            Arrays.fill(moves, -1);
            moves[1] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            
            boolean found = false;
            
            while (!queue.isEmpty() && !found) {
                int current = queue.poll();
                
                
                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;
                    
                    if (next > 100) continue;
                    
                    
                    if (ladders.containsKey(next)) {
                        next = ladders.get(next);
                    } else if (snakes.containsKey(next)) {
                        next = snakes.get(next);
                    }
                    
                    
                    if (moves[next] == -1) {
                        moves[next] = moves[current] + 1;
                        queue.add(next);
                    }
                    
                    
                    if (next == 100) {
                        found = true;
                        break;
                    }
                }
            }
            
            System.out.println(moves[100]);
        }
    }
}