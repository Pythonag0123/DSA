class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        int ans = solve(amount, coins, dp);
        return ans == (int)1e9 ? -1 : ans;
    }

    private int solve(int amount, int[] coins, Integer[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return (int)1e9;

        if (dp[amount] != null) return dp[amount];

        int minCoins = (int)1e9;

        for (int coin : coins) {
            int res = solve(amount - coin, coins, dp);
            if (res != (int)1e9) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        return dp[amount] = minCoins;
    }
}
