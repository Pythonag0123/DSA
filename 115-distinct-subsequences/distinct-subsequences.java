class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return ways(s, t, 0, 0, dp);
    }

    public static int ways(String s, String t, int i, int j, int[][] dp) {
        // If we matched all characters of t
        if (j == t.length()) return 1;

        // If we ran out of characters in s but not in t
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;

        // Option 1: match characters
        if (s.charAt(i) == t.charAt(j)) {
            count += ways(s, t, i + 1, j + 1, dp);
        }

        // Option 2: skip current character of s
        count += ways(s, t, i + 1, j, dp);

        return dp[i][j] = count;
    }
}
