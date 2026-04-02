class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] dp=new Boolean[nums.length+1][target+1];
        return solve(nums, target, nums.length,dp);
    }

    public boolean solve(int[] nums, int target, int n,Boolean[][] dp){
        if(target == 0) return true;
        if(n == 0) return false;

        if(dp[n][target]!=null){
            return dp[n][target];
        }
        boolean notPick=solve(nums,target,n-1,dp);
        boolean pick = false;
        if(nums[n-1] <= target){
            pick = solve(nums, target - nums[n-1], n-1,dp);
        }

        return dp[n][target]=pick || notPick;
    }
}