import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Result {
    private static int bfs(int n, int a, int b) {
    int[][] directions = {
        {a, b}, {a, -b}, {-a, b}, {-a, -b},
        {b, a}, {b, -a}, {-b, a}, {-b, -a}
    };

    boolean[][] visited = new boolean[n][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int x = cur[0], y = cur[1], steps = cur[2];

        if (x == n - 1 && y == n - 1) {
            return steps;
        }

        for (int[] d : directions) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, steps + 1});
            }
        }
    }

    return -1;
    }

    public static List<List<Integer>> knightlOnAChessboard(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'knightlOnAChessboard'");
    }
}