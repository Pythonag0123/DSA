class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        int n=amount+1;
        int m=coins.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return ways(amount,0,coins,dp);
        
    }
    public static int ways(int amount,int idx,int[] coins,int[][] dp){
        if(amount==0) return 1;
        if(idx==coins.length) return 0;
        if(amount<0) return 0;
        if(dp[amount][idx]!=-1) return dp[amount][idx];
        int pick=ways(amount-coins[idx],idx,coins,dp);

        int notpick=ways(amount,idx+1,coins,dp);
        return dp[amount][idx]=pick+notpick;
    }

}