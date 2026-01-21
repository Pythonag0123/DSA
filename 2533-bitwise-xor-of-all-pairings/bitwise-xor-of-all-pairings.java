class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;

        int ans = 0;

        // if nums2 length is odd → xor nums1 contributes
        if ((n & 1) == 1) {
            for (int a : nums1) {
                ans ^= a;
            }
        }

        // if nums1 length is odd → xor nums2 contributes
        if ((m & 1) == 1) {
            for (int b : nums2) {
                ans ^= b;
            }
        }

        return ans;
    }
}
