class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int s = 0; 

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[s]) {
                s++;
                nums[s] = nums[i];
            }
        }

        return s + 1; 
    }
}