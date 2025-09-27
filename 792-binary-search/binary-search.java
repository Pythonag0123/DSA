class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int hi=n-1;
        int lo=0;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(target==nums[mid]){
                ans=mid;
                return ans;
            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else{
                hi=mid-1;;
            }
        }
        return ans;
        
        
    }
}