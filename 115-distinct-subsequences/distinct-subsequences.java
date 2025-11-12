

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return distinctNum(s, t, 0, 0, dp);
    }

    // Helper function to count subsequences
    public int distinctNum(String s, String t, int i, int j, int[][] dp) {
        // If we matched all characters of t → one valid subsequence found
        if (j == t.length()) return 1;

        // If s is exhausted but t isn't → no valid subsequence
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int inc = 0, exc = 0;

        // If characters match → two options:
        // 1. Take this matching character
        // 2. Skip it
        if (s.charAt(i) == t.charAt(j)) {
            inc = distinctNum(s, t, i + 1, j + 1, dp);
        }

        // Skip current character of s (regardless of match)
        exc = distinctNum(s, t, i + 1, j, dp);

        // Total ways = include + exclude
        return dp[i][j] = inc + exc;
    }
}
