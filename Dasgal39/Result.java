package FraudulentActivity;

import java.util.List;

public class Result {
     public static int activityNotifications(List<Integer> expenditure, int d) {
     int[] count = new int[201];
    int notifications = 0;

    for (int i = 0; i < d; i++) {
        count[expenditure.get(i)]++;
    }

    for (int i = d; i < expenditure.size(); i++) {
        double median = getMedian(count, d);
        if (expenditure.get(i) >= 2 * median) {
            notifications++;
        }
        count[expenditure.get(i)]++;
        count[expenditure.get(i - d)]--;
    }

    return notifications;
}

private static double getMedian(int[] count, int d) {
    int sum = 0;
    int median1 = 0;
    int median2 = 0;

    if (d % 2 == 1) {
        int mid = d / 2 + 1;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum >= mid) {
                return i;
            }
        }
    } else {
        int mid1 = d / 2;
        int mid2 = mid1 + 1;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum >= mid1 && median1 == 0) median1 = i;
            if (sum >= mid2) {
                median2 = i;
                break;
            }
        }
        return (median1 + median2) / 2.0;
    }
    return 0.0;
}
}