class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // If there is only 1 house, rob it
        if(n == 1) return nums[0];

        // If there are 2 houses, rob the one with the maximum money
        if(n == 2) return Math.max(nums[0], nums[1]);

        // dp[i] = maximum money that can be robbed up to house i
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];                           // Rob the first house
        dp[1] = Math.max(nums[0], nums[1]);        // Choose max of first or second house

        // Fill dp for all remaining houses
        for(int i = 2; i < n; i++){

            // If you rob the current house → you cannot rob the previous one
            // So take nums[i] + dp[i-2]
            int rob = nums[i] + dp[i - 2];

            // If you DO NOT rob the current house → take best till i-1
            int dontRob = dp[i - 1];

            // Choose the maximum of the two choices
            dp[i] = Math.max(rob, dontRob);
        }

        // Final answer = best loot up to the last house
        return dp[n - 1];
    }
}
