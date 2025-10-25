class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;  // XOR cancels out duplicates
        }
        return ans;
    }
}
