class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n][m];

        // Fill dp with -1 for memoization
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return ans(nums1, nums2, 0, 0, dp);
    }

    public static int ans(int[] nums1, int[] nums2, int i, int j, int[][] dp){

        // Base case
        if(i == nums1.length || j == nums2.length){
            return 0;
        }

        // Memoized answer
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // Matching numbers → we can draw a line → count 1
        if(nums1[i] == nums2[j]){
            dp[i][j] = 1 + ans(nums1, nums2, i + 1, j + 1, dp);
        }
        else{
            // No match → choose best of skipping from either sequence
            int skip1 = ans(nums1, nums2, i + 1, j, dp);
            int skip2 = ans(nums1, nums2, i, j + 1, dp);
            dp[i][j] = Math.max(skip1, skip2);
        }

        return dp[i][j];
    }
}
