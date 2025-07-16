import java.util.*;

public class Initial {

    // Naive Pattern Search
    static List<Integer> naiveSearch(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == m) result.add(i);
        }
        return result;
    }

    // Improved Naive Search (for distinct characters in pattern)
    static List<Integer> improvedNaiveSearch(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();

        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == m) result.add(i);

            if (j == 0) i++;
            else i += j; // jump by j if mismatch found at j
        }
        return result;
    }

    // Rabin-Karp Pattern Search
    static List<Integer> rabinKarp(String txt, String pat, int d, int q) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length(), m = pat.length();
        int h = 1, p = 0, t = 0;

        for (int i = 0; i < m - 1; i++) h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) result.add(i);
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

        // Test cases
        String[][] testCases = {
            {"ABABDABACDABABCABAB", "ABABCABAB"}, // match at 10
            {"AAAAA", "AAA"},                     // overlap
            {"ABCDEFGH", "Z"},                    // not present
            {"ABABABAB", "ABAB"},                 // multiple matches
            {"", ""},                             // empty strings
            {"ABC", ""},                          // empty pattern
            {"", "ABC"}                           // empty text
        };

        System.out.println("Select Algorithm:");
        System.out.println("1. Naive Search");
        System.out.println("2. Improved Naive Search (distinct chars)");
        System.out.println("3. Rabin-Karp");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int t = 0; t < testCases.length; t++) {
            String text = testCases[t][0];
            String pattern = testCases[t][1];

            System.out.println("\nTest Case " + (t + 1) + ":");
            System.out.println("Text: \"" + text + "\", Pattern: \"" + pattern + "\"");

            List<Integer> positions;
            switch (choice) {
                case 1:
                    positions = naiveSearch(text, pattern);
                    break;
                case 2:
                    positions = improvedNaiveSearch(text, pattern);
                    break;
                case 3:
                    positions = rabinKarp(text, pattern, 256, 101); // d=256, q=101 (prime)
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }

            if (positions.isEmpty())
                System.out.println("Pattern not found.");
            else
                System.out.println("Pattern found at index(es): " + positions);
        }
    }
}
