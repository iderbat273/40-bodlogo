import java.util.List;

public class Result {
    public static long candies(int n, List<Integer> arr) {
int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i + 1)) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        long totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(left[i], right[i]);
        }

        return totalCandies;
    }
}