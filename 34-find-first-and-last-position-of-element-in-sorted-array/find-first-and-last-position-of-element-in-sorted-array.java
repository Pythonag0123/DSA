class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] pos=new int[2];
        pos[0]=firstPos(nums,target);
        pos[1]=lastPos(nums,target);
        return pos;
    }
    public int firstPos(int[] nums,int target){
        int hi=nums.length-1;
        int lo=0;
        int f=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(target==nums[mid]){
                f=mid;
                hi=mid-1;
            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }

        }
        return f;


    }
    public int lastPos(int[] nums,int target){
        int hi=nums.length-1;
        int lo=0;
        int l=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(target==nums[mid]){
                l=mid;
                lo=mid+1;
            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }

        }
        return l;

    }
}