class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) {
                i++;
            }
        }

        int[] left = new int[i];
        int[] right = new int[n - i];

        int k = 0, m = 0;

        
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) {
                left[k++] = nums[j];
            } else {
                right[m++] = nums[j];
            }
        }

        
        int s = 0, e = i - 1;
        while (s <= e) {
            int temp = left[s];
            left[s] = left[e];
            left[e] = temp;
            s++;
            e--;
        }

        
        for (int j = 0; j < left.length; j++) {
            left[j] = left[j] * left[j];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = right[j] * right[j];
        }

        
        int[] ans = new int[n];
        int p1 = 0, p2 = 0, idx = 0;

        while (p1 < left.length && p2 < right.length) {
            if (left[p1] <= right[p2]) {
                ans[idx++] = left[p1++];
            } else {
                ans[idx++] = right[p2++];
            }
        }

        
        while (p1 < left.length) {
            ans[idx++] = left[p1++];
        }
        while (p2 < right.length) {
            ans[idx++] = right[p2++];
        }

        return ans;
    }
}