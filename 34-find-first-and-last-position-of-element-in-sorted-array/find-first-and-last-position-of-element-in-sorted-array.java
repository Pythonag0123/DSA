class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] firstLast = new int[2];
        firstLast[0] = SearchFirst(nums, target);
        firstLast[1] = SearchLast(nums, target);
        return firstLast;
    }

    public int SearchFirst(int[] arr, int target) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            if (arr[mid] == target) {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }

    public int SearchLast(int[] arr, int target) {
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            if (arr[mid] == target) {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }
}
