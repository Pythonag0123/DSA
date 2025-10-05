class Solution {
    public void subseq(int idx, List<List<Integer>> ans, List<Integer> ds, int[] nums, int n) {
        if (idx == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // Include
        ds.add(nums[idx]);
        subseq(idx + 1, ans, ds, nums, n);
        
        // Exclude
        ds.remove(ds.size() - 1);
        subseq(idx + 1, ans, ds, nums, n);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subseq(0, ans, new ArrayList<>(), nums, nums.length);
        return ans;
    }
}