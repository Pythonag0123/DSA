
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(candidates, target, 0, ll, ans);
        return ans;
    }

    public void helper(int[] arr, int target, int idx, List<Integer> ll, List<List<Integer>> ans) {
        
        
        if (target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        
        if (target < 0 || idx == arr.length) {
            return;
        }

        

        
        ll.add(arr[idx]);
        helper(arr, target - arr[idx], idx, ll, ans);
        ll.remove(ll.size() - 1);
        helper(arr, target, idx + 1, ll, ans);
    }
}