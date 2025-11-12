class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return ways(amount,coins,0,dp);
        
    }
    public int ways(int amount,int[]coins,int idx,int[][] dp){
        int pick=0;
        int notpick=0;
        if(amount==0) return 1;
        if(idx==coins.length) return 0;
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }


        if(amount>=coins[idx]){
            pick+=ways(amount-coins[idx],coins,idx,dp);
        }
        notpick+=ways(amount,coins,idx+1,dp);
        return dp[amount][idx]=pick+notpick;
        
    }
}