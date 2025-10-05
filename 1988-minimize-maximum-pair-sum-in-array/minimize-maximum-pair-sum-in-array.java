class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int s=0;
        int e=nums.length-1;
        int max=0;
        while(s<e){
            int sum=nums[s]+nums[e];
            max=Math.max(max,sum);
            s++;
            e--;
        }
        return max;
        
    }
}