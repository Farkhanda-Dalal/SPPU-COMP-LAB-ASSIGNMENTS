import java.util.*;

public class App {

    // 1. Greedy Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            // Swap
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // 2. Job Scheduling Problem (Greedy by Profit)
    static class Job {
        String id;
        int deadline, profit;

        Job(String id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit); // Sort by profit descending

        int n = jobs.length;
        boolean[] slot = new boolean[n];
        String[] result = new String[n];

        for (Job job : jobs) {
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }

        System.out.println("Scheduled Jobs:");
        for (String id : result) {
            if (id != null) System.out.print(id + " ");
        }
        System.out.println();
    }

    // 3. Prim's Minimum Spanning Tree (Adjacency Matrix)
    public static void primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIdx = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIdx = v;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        // Test Selection Sort
        int[] arr = {29, 10, 14, 37, 13};
        System.out.print("Selection Sort: ");
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test Job Scheduling
        Job[] jobs = {
            new Job("J1", 2, 100),
            new Job("J2", 1, 19),
            new Job("J3", 2, 27),
            new Job("J4", 1, 25),
            new Job("J5", 3, 15)
        };
        System.out.print("Job Scheduling: ");
        scheduleJobs(jobs);

        // Test Prim's MST
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        System.out.println("Prim's MST:");
        primMST(graph);
    }
}
