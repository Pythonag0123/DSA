

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, int idx, List<Integer> current, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        
        current.add(nums[idx]);
        helper(nums, idx + 1, current, ans);
        current.remove(current.size() - 1);

        
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }

        
        helper(nums, nextIdx, current, ans);
    }
}
