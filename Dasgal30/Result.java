import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result {
    public static int pairs(int k, List<Integer> arr) {

 Set<Integer> elements = new HashSet<>(arr);
    int count = 0;

    for (int x : arr) {
        if (elements.contains(x + k)) {
            count++;
        }
    }

    return count;
    }
}