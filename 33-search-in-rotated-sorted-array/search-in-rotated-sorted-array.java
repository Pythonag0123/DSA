class Solution {
    public int search(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;

        while (low <= hi) {
            int mid = low + (hi - low) / 2;

            if (nums[mid] == target) return mid;

            // left half sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right half sorted
            else {
                if (target > nums[mid] && target <= nums[hi]) {
                    low = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
