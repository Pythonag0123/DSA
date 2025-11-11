class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return rob(nums,0,dp);
    }
    public static int rob(int[] nums,int i,int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int pick=nums[i]+rob(nums,i+2,dp);
        int notPick=rob(nums,i+1,dp);
        return dp[i]=Math.max(pick,notPick);
    }
}