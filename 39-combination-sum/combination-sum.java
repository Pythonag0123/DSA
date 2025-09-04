class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combination(candidates, target, ll, 0, ans);
        return ans;
    }

    public static void combination(int[] candidates, int amount, List<Integer> ll, int idx, List<List<Integer>> ans) {
        if (amount == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i < candidates.length; i++) { 
            if (amount >= candidates[i]) {
                ll.add(candidates[i]); 
                combination(candidates, amount - candidates[i], ll, i, ans);
                ll.remove(ll.size() - 1); 
            }
        }
    }
}
