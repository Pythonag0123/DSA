class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a 2D DP array. 
        // dp[i][j] stores the min operations for word1 of length i and word2 of length j.
        // We use m+1 and n+1 to handle the case of empty strings (length 0).
        int[][] dp = new int[m + 1][n + 1];

        // Iterate through all possible lengths of word1 (i) and word2 (j)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                
                // Base Case: If word1 is empty (length 0), we must insert all characters of word2.
                // Or if word2 is empty, we must delete all characters of word1.
                // This covers the logic: if (i==0 || j==0) return i+j [11], [14].
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } 
                // If characters match (Note: strings are 0-indexed, so we check i-1 and j-1)
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation needed, carry over the value from the previous diagonal [8].
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // If characters mismatch, take the minimum of Insert, Delete, or Replace + 1 cost.
                else {
                    dp[i][j] = 1 + min(
                        dp[i][j - 1],    // Insert [8]
                        dp[i - 1][j],    // Delete [8]
                        dp[i - 1][j - 1] // Replace [8]
                    );
                }
            }
        }
        
        // The answer is stored in the cell representing the full lengths of both strings [16].
        return dp[m][n];
    }

    // Helper method to find minimum of three numbers
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}