package Containers;

import java.util.Arrays;
import java.util.List;

public class Result {
    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
int n = container.size();
    int[] containerSums = new int[n];
    int[] typeSums = new int[n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            containerSums[i] += container.get(i).get(j);
            typeSums[j] += container.get(i).get(j);
        }
    }

    Arrays.sort(containerSums);
    Arrays.sort(typeSums);

    for (int i = 0; i < n; i++) {
        if (containerSums[i] != typeSums[i]) {
            return "Impossible";
        }
    }

    return "Possible";
    
    }
}