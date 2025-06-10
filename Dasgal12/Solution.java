import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<String>[] arr = new List[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new ArrayList<>();
        }

    
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            String s = (i < n/2) ? "-" : parts[1];
            arr[x].add(s);
        }

    
        for (int i = 0; i < 100; i++) {
            for (String s : arr[i]) {
                bw.write(s + " ");
            }
        }

        br.close();
        bw.close();
    }
}