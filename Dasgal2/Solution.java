import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            // Top
            for (int i = layer; i < n - layer; i++)
                elements.add(matrix.get(layer).get(i));
            // Right
            for (int i = layer + 1; i < m - layer - 1; i++)
                elements.add(matrix.get(i).get(n - layer - 1));
            // Bottom
            for (int i = n - layer - 1; i >= layer; i--)
                elements.add(matrix.get(m - layer - 1).get(i));
            // Left
            for (int i = m - layer - 2; i > layer; i--)
                elements.add(matrix.get(i).get(layer));

            int len = elements.size();
            int rot = r % len;

            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rot, len));
            rotated.addAll(elements.subList(0, rot));

            int index = 0;
            // Top
            for (int i = layer; i < n - layer; i++)
                matrix.get(layer).set(i, rotated.get(index++));
            // Right
            for (int i = layer + 1; i < m - layer - 1; i++)
                matrix.get(i).set(n - layer - 1, rotated.get(index++));
            // Bottom
            for (int i = n - layer - 1; i >= layer; i--)
                matrix.get(m - layer - 1).set(i, rotated.get(index++));
            // Left
            for (int i = m - layer - 2; i > layer; i--)
                matrix.get(i).set(layer, rotated.get(index++));
        }

        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
        scanner.close();
    }
}
