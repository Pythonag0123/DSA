class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int mE = nums[0];
        int count = 1;

        for(int i = 1; i < n; i++){

            if(count == 0){
                mE = nums[i];
                count = 1;
                continue;
            }

            if(nums[i] == mE){
                count++;
            }
            else{
                count--;
            }
        }

        return mE;
    }
}