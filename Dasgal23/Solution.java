import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        
        int q = Integer.parseInt(br.readLine());
        int[] results = new int[q];
        
        for (int i = 0; i < q; i++) {
            String query = br.readLine();
            results[i] = frequencyMap.getOrDefault(query, 0);
        }
        
        for (int result : results) {
            System.out.println(result);
        }
    }
}