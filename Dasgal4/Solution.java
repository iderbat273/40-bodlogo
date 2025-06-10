import java.util.*;

public class Solution {

    static String organizingContainers(int[][] container) {
        int n = container.length;
        int[] containerSums = new int[n];
        int[] ballSums = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                containerSums[i] += container[i][j];
                ballSums[j] += container[i][j];
            }
        }
        
        Arrays.sort(containerSums);
        Arrays.sort(ballSums);
        
        for (int i = 0; i < n; i++) {
            if (containerSums[i] != ballSums[i]) {
                return "Impossible";
            }
        }
        
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            int[][] container = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    container[j][k] = scanner.nextInt();
                }
            }
            System.out.println(organizingContainers(container));
        }
        scanner.close();
    }
}