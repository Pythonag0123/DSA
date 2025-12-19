class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstPos(nums, target);
        ans[1] = lastPos(nums, target);
        return ans;
    }

    public int firstPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ans = mid;        
                hi = mid - 1;     
            } 
            else if (nums[mid] < target) {
                lo = mid + 1;
            } 
            else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    public int lastPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                ans = mid;        
                lo = mid + 1;    
            } 
            else if (nums[mid] < target) {
                lo = mid + 1;
            } 
            else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
