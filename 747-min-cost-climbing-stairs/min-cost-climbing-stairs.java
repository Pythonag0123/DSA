class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];   // cost to reach step 0
        dp[1] = cost[1];   // cost to reach step 1

        for(int i = 2; i < n; i++){
            // to reach i: pay cost[i] AND come from either i-1 or i-2
            int oneStep = cost[i] + dp[i - 1];
            int twoStep = cost[i] + dp[i - 2];
            dp[i] = Math.min(oneStep, twoStep);
        }

        // You can reach the "top" from step n-1 OR n-2
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
