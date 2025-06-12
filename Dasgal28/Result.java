import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Result {
    public static int minimumLoss(List<Long> price) {
int n = price.size();
    long[][] priceWithIndex = new long[n][2];

    for (int i = 0; i < n; i++) {
        priceWithIndex[i][0] = price.get(i);
        priceWithIndex[i][1] = i;
    }

    Arrays.sort(priceWithIndex, new Comparator<long[]>() {
        public int compare(long[] a, long[] b) {
            return Long.compare(a[0], b[0]);
        }
    });

    int minLoss = Integer.MAX_VALUE;

    for (int i = 1; i < n; i++) {
        long priceDiff = priceWithIndex[i][0] - priceWithIndex[i-1][0];
        int indexDiff = (int)(priceWithIndex[i-1][1] - priceWithIndex[i][1]);

        if (indexDiff > 0 && priceDiff < minLoss) {
            minLoss = (int) priceDiff;
        }
    }

    return minLoss;
    }
}