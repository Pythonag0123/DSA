class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        } else if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int y = findPeak(nums);
        int c = se(nums, target, 0, y - 1);     
        int d = se(nums, target, y, nums.length - 1);

        if (c != -1) return c;
        else return d;
    }

    public int se(int[] nums, int target, int s, int e) {
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                ans = mid;
                return ans;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    
    public int findPeak(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
