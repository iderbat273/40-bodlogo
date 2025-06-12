import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    public static List<String> bomberMan(int n, List<String> grid) {
 int rows = grid.size();
        int cols = grid.get(0).length();

        char[][] initial = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            initial[i] = grid.get(i).toCharArray();
        }

        char[][] fullBombs = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(fullBombs[i], 'O');
        }

        if (n == 1) {
            return toList(initial);
        } else if (n % 2 == 0) {
            return toList(fullBombs);
        } else {
            char[][] first = detonate(initial);
            char[][] second = detonate(first);
            if ((n - 3) % 4 == 0) {
                return toList(first);
            } else {
                return toList(second);
            }
        }
    }

    private static char[][] detonate(char[][] source) {
        int rows = source.length;
        int cols = source[0].length;
        char[][] result = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(result[i], 'O');
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (source[i][j] == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i - 1][j] = '.';
                    if (i < rows - 1) result[i + 1][j] = '.';
                    if (j > 0) result[i][j - 1] = '.';
                    if (j < cols - 1) result[i][j + 1] = '.';
                }
            }
        }
        return result;
    }

    private static List<String> toList(char[][] grid) {
        List<String> result = new ArrayList<>();
        for (char[] row : grid) {
            result.add(new String(row));
        }
        return result;

    }

}