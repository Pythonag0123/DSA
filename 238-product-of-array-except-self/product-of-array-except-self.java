class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n+1];
        int[] right=new int[n+1];
        int[] ans=new int[n];
        left[0]=1;
        for(int i=1;i<n+1;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        right[n]=1;

        for(int i=n-1;i>=0;i--){
            right[i]=right[i+1]*nums[i];
        }
        for(int i=0;i<n;i++){
            ans[i]=left[i]*right[i+1];
        }
        return ans;

        
    }
}