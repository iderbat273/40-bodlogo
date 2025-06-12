package EmasSupercomputer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    public static int twoPluses(List<String> grid) {
int n = grid.size();
        int m = grid.get(0).length();
        List<Plus> pluses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int len = 0;
                while (isValid(grid, i, j, len)) {
                    pluses.add(new Plus(i, j, len));
                    len++;
                }
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < pluses.size(); i++) {
            Set<String> cells1 = pluses.get(i).getCells();
            for (int j = i + 1; j < pluses.size(); j++) {
                Set<String> cells2 = pluses.get(j).getCells();
                boolean overlap = false;
                for (String cell : cells2) {
                    if (cells1.contains(cell)) {
                        overlap = true;
                        break;
                    }
                }
                if (!overlap) {
                    int area = pluses.get(i).area() * pluses.get(j).area();
                    maxProduct = Math.max(maxProduct, area);
                }
            }
        }
        return maxProduct;
    }

    private static boolean isValid(List<String> grid, int x, int y, int len) {
        int n = grid.size();
        int m = grid.get(0).length();
        if (x - len < 0 || x + len >= n || y - len < 0 || y + len >= m) return false;
        for (int i = -len; i <= len; i++) {
            if (grid.get(x + i).charAt(y) != 'G') return false;
            if (grid.get(x).charAt(y + i) != 'G') return false;
        }
        return true;
    }

    static class Plus {
        int x, y, len;

        Plus(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        int area() {
            return 4 * len + 1;
        }

        Set<String> getCells() {
            Set<String> cells = new HashSet<>();
            cells.add(x + "," + y);
            for (int i = 1; i <= len; i++) {
                cells.add((x + i) + "," + y);
                cells.add((x - i) + "," + y);
                cells.add(x + "," + (y + i));
                cells.add(x + "," + (y - i));
            }
            return cells;
        }

    }
}