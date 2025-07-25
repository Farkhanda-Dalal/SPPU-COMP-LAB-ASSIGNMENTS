import java.util.Arrays;
import java.util.Random;

public class Assignment05 {
static int deterministicPass = 0;
static int randomizedPass = 0;

// Deterministic partition: pivot is the last element
public static int partitionDeterministic(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }

    swap(arr, i + 1, high);
    return i + 1;
}

// Randomized partition: select a random pivot
public static int partitionRandomized(int[] arr, int low, int high) {
    Random rand = new Random();
    int randomPivotIndex = low + rand.nextInt(high - low + 1);
    swap(arr, randomPivotIndex, high); // Move pivot to end
    return partitionDeterministic(arr, low, high);
}

// Deterministic Quick Sort with passes
public static void quickSortDeterministic(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partitionDeterministic(arr, low, high);
        deterministicPass++;
        System.out.print("Deterministic Pass " + deterministicPass + ": ");
        printArray(arr);
        quickSortDeterministic(arr, low, pi - 1);
        quickSortDeterministic(arr, pi + 1, high);
    }
}

// Randomized Quick Sort with passes
public static void quickSortRandomized(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partitionRandomized(arr, low, high);
        randomizedPass++;
        System.out.print("Randomized Pass " + randomizedPass + ": ");
        printArray(arr);
        quickSortRandomized(arr, low, pi - 1);
        quickSortRandomized(arr, pi + 1, high);
    }
}

// Swap utility
public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// Print array
public static void printArray(int[] arr) {
    for (int x : arr) {
        System.out.print(x + " ");
    }
    System.out.println();
}

// Main
public static void main(String[] args) {
    int[] arr = {10, 7, 8, 9, 1, 5};

    System.out.println("Original Array: " + Arrays.toString(arr));

    // Deterministic Quick Sort
    int[] arrDeterministic = Arrays.copyOf(arr, arr.length);
    System.out.println("\nDeterministic Quick Sort:");
    quickSortDeterministic(arrDeterministic, 0, arrDeterministic.length - 1);
    System.out.print("Sorted: ");
    printArray(arrDeterministic);

    // Randomized Quick Sort
    int[] arrRandomized = Arrays.copyOf(arr, arr.length);
    System.out.println("\nRandomized Quick Sort:");
    quickSortRandomized(arrRandomized, 0, arrRandomized.length - 1);
    System.out.print("Sorted: ");
    printArray(arrRandomized);
}


}
