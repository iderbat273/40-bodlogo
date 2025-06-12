package DownToZero;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Result {

    public static int downToZero(int n) {
 
Queue<Integer> queue = new LinkedList<>();
        int[] steps = new int[n + 1];
        Arrays.fill(steps, -1); 

        queue.add(n);
        steps[n] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

    
            if (current == 0) {
                return steps[0];
            }

            if (steps[current - 1] == -1) {
                steps[current - 1] = steps[current] + 1;
                queue.add(current - 1);
            }

            for (int i = 2; i <= Math.sqrt(current); i++) {
                if (current % i == 0) {
                    int next = Math.max(i, current / i);
                    if (steps[next] == -1) {
                        steps[next] = steps[current] + 1;
                        queue.add(next);
                    }
                }
            }
        }

        return -1;
    }

}