import java.util.*;

public class SlidingWindowLog {

    // Naive Pattern Search
    static List<Integer> naiveSearch(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        System.out.println("\n--- Naive Search ---");
        for (int i = 0; i <= n - m; i++) {
            System.out.println("Checking window: \"" + txt.substring(i, i + m) + "\" at index " + i);
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == m) {
                System.out.println("✅ Match found at index " + i);
                result.add(i);
            } else {
                System.out.println("❌ No match");
            }
        }
        return result;
    }

    // Improved Naive Search for distinct pattern
    static List<Integer> improvedNaiveSearch(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        System.out.println("\n--- Improved Naive Search (Distinct Characters) ---");
        int i = 0;
        while (i <= n - m) {
            System.out.println("Checking window: \"" + txt.substring(i, i + m) + "\" at index " + i);
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == m) {
                System.out.println("✅ Match found at index " + i);
                result.add(i);
            } else {
                System.out.println("❌ No match, skipping " + Math.max(1, j) + " characters");
            }
            i += Math.max(1, j);
        }
        return result;
    }

    // Rabin-Karp Search
    static List<Integer> rabinKarp(String txt, String pat, int d, int q) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();
        int h = 1, p = 0, t = 0;

        System.out.println("\n--- Rabin-Karp Search ---");

        for (int i = 0; i < m - 1; i++) h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            System.out.println("Window hash: " + t + " vs Pattern hash: " + p + " at index " + i);
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("✅ Match found at index " + i);
                    result.add(i);
                } else {
                    System.out.println("⚠️ Spurious hit at index " + i);
                }
            } else {
                System.out.println("❌ No match");
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📘 Pattern Matching CLI with Sliding Window Visualization");

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = sc.nextLine();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. Naive Search");
        System.out.println("2. Improved Naive Search (distinct chars)");
        System.out.println("3. Rabin-Karp");

        int choice = sc.nextInt();

        List<Integer> positions;

        switch (choice) {
            case 1:
                positions = naiveSearch(text, pattern);
                break;
            case 2:
                positions = improvedNaiveSearch(text, pattern);
                break;
            case 3:
                positions = rabinKarp(text, pattern, 256, 101);
                break;
            default:
                System.out.println("❌ Invalid choice");
                return;
        }

        if (positions.isEmpty())
            System.out.println("\n📌 Pattern not found.");
        else
            System.out.println("\n✅ Pattern found at indices: " + positions);
    }
}
