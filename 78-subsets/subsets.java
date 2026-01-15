class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        int totalMasks = 1 << n;   // 2^n subsets

        for (int mask = 0; mask < totalMasks; mask++) {
            List<Integer> ll = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    ll.add(nums[j]);
                }
            }

            ans.add(ll);
        }

        return ans;
    }
}
