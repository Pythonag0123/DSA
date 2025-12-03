class Solution {
    public int climbStairs(int n) {

        // dp[i] = number of ways to reach step i

        if(n == 0) return 1;     // 1 way (stay at ground)
        if(n == 1) return 1;     // 1 way (1 step)

        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;   // ground
        dp[1] = 1;   // first step

        // Fill dp array from 2 to n
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];  
            // You can reach i either from:
            // - i-1 step (take 1 step)
            // - i-2 step (take 2 steps)
        }

        return dp[n];   // ways to reach nth step
    }
}
