class Solution {
    public int fib(int n) {
        int[] dp=new int[n+1];
        return fibotopDown(n,dp);
        
    }
    public static int fibotopDown(int n,int[] dp){
        if(n==0||n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ans=fibotopDown(n-1,dp)+fibotopDown(n-2,dp);
        return dp[n]=ans;
        

    }
}