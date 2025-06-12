import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    public static int lilysHomework(List<Integer> arr) {
    int n = arr.size();

    List<Integer> sortedAsc = new ArrayList<>(arr);
    Collections.sort(sortedAsc);

    List<Integer> sortedDesc = new ArrayList<>(arr);
    Collections.sort(sortedDesc, Collections.reverseOrder());

    int swapsAsc = countSwaps(arr, sortedAsc);
    int swapsDesc = countSwaps(arr, sortedDesc);

    return Math.min(swapsAsc, swapsDesc);
}

private static int countSwaps(List<Integer> original, List<Integer> target) {
    int n = original.size();
    int swaps = 0;

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
        indexMap.put(target.get(i), i);
    }

    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;

        int cycleSize = 0;
        int j = i;

        while (!visited[j]) {
            visited[j] = true;
            j = indexMap.get(original.get(j));
            cycleSize++;
        }

        if (cycleSize > 1) {
            swaps += cycleSize - 1;
        }
    }

    return swaps;

    }

}