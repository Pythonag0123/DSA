class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        // initialize dp with -1 (meaning: not computed)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return ans(text1, text2, 0, 0, dp);
    }

    public static int ans(String text1, String text2, int i, int j, int[][] dp){

        // base case: reached end of any string
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        // already computed? return from dp
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // Option 1: characters match → take 1 + next dp
        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + ans(text1, text2, i + 1, j + 1, dp);
        }
        else{
            // Option 2: characters don't match → explore both possibilities
            int moveI = ans(text1, text2, i + 1, j, dp);
            int moveJ = ans(text1, text2, i, j + 1, dp);

            dp[i][j] = Math.max(moveI, moveJ);
        }

        return dp[i][j];
    }
}
