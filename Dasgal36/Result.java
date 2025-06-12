package ComponentsInAGraph;

import java.io.*;
import java.util.*;

class Result {

    static int[] parent;
    static int[] size;

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        int n = 2 * 100000 + 1;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (List<Integer> edge : gb) {
            int u = edge.get(0);
            int v = edge.get(1);
            union(u, v);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            if (parent[i] == i && size[i] > 1) {
                min = Math.min(min, size[i]);
                max = Math.max(max, size[i]);
            }
        }

        return Arrays.asList(min, max);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    private static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
            size[rootV] = 0;
        }
    }
}