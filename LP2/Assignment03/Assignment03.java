import java.util.*;

class Graph {
    private int nv;
    private List<List<Pair>> adjList;

    static class Pair {
        int vertex, weight;
        Pair(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    public Graph(int nv) {
        this.nv = nv;
        adjList = new ArrayList<>();
        for (int i = 0; i < nv; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int des, int weight) {
        adjList.get(src).add(new Pair(des, weight));
        adjList.get(des).add(new Pair(src, weight)); // For undirected graph
    }

    public void primsMST(int start) {
        int[] parent = new int[nv];
        int[] key = new int[nv];
        boolean[] mstSet = new boolean[nv];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        Arrays.fill(key, Integer.MAX_VALUE);
        key[start] = 0;
        parent[start] = -1;
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            mstSet[u] = true;

            for (Pair neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!mstSet[v] && weight < key[v]) {
                    parent[v] = u;
                    key[v] = weight;
                    pq.add(new Pair(v, key[v]));
                }
            }
        }

        int totalWeight = 0;
        System.out.println("\nMinimum Spanning Tree (Prim's Algorithm):");
        for (int i = 1; i < nv; i++) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}

class Sorting {
    public void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println("\nSorted Array (Selection Sort): " + Arrays.toString(arr));
    }
}

public class GreedyAlgorithms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("\nChoose an algorithm to execute:");
            System.out.println("1. Prim's Algorithm (MST)");
            System.out.println("2. Selection Sort");
            System.out.println("Type 'end' to exit.");
            System.out.print("Enter your choice: ");
            userInput = sc.next().toLowerCase(); // Convert to lowercase for case insensitivity

            if (userInput.equals("1")) {
                Graph g = new Graph(5);
                g.addEdge(0, 1, 2);
                g.addEdge(0, 3, 6);
                g.addEdge(1, 2, 3);
                g.addEdge(1, 3, 8);
                g.addEdge(1, 4, 5);
                g.addEdge(2, 4, 7);
                g.addEdge(3, 4, 9);
                g.primsMST(0);
            } else if (userInput.equals("2")) {
                System.out.print("Enter the number of elements in the array: ");
                int n = sc.nextInt();
                int[] arr = new int[n];

                System.out.println("Enter the elements:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }

                Sorting sorting = new Sorting();
                sorting.selectionSort(arr);
            } else if (!userInput.equals("end")) {
                System.out.println("Invalid choice! Please enter 1, 2, or 'end'.");
            }
        } while (!userInput.equals("end"));

        System.out.println("Program terminated.");
        sc.close();
    }
}
