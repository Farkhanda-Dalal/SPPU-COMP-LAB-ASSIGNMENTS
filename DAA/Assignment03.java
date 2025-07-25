public class Assignment03 {
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
    int[][] dp = new int[n + 1][capacity + 1];

    System.out.println("Building the DP table...");

    // Build the DP table in bottom-up manner
    for (int i = 1; i <= n; i++) {
        System.out.println("Considering item " + i + " (weight = " + weights[i - 1] + ", value = " + values[i - 1] + ")");
        for (int w = 1; w <= capacity; w++) {
            if (weights[i - 1] <= w) {
                int included = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                int excluded = dp[i - 1][w];
                dp[i][w] = Math.max(excluded, included);
                System.out.printf("Capacity %2d: Max(%d (exclude), %d (include)) => dp[%d][%d] = %d\n", 
                    w, excluded, included, i, w, dp[i][w]);
            } else {
                dp[i][w] = dp[i - 1][w];
                System.out.printf("Capacity %2d: Item too heavy, carry forward dp[%d][%d] = %d\n",
                    w, i, w, dp[i][w]);
            }
        }
        System.out.println();
    }

    System.out.println("Final DP Table:");
    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            System.out.printf("%3d ", dp[i][w]);
        }
        System.out.println();
    }

    return dp[n][capacity];
}

public static void main(String[] args) {
    int n = 4;
    int capacity = 9;
    int[] weights = {2, 3, 4, 5};
    int[] values = {3, 4, 5, 6};

    int maxValue = knapsack(capacity, weights, values, n);
    System.out.println("\nThe maximum value that can be obtained is: " + maxValue);
}


}
