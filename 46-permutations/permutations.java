class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        backtrack(nums, ans, ll);
        return ans;
    }

    public void backtrack(int[] arr, List<List<Integer>> ans, List<Integer> ll) {
        if (ll.size() == arr.length) { 
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = 0; i < arr.length; i++) { 
            if (ll.contains(arr[i])) continue; 

            ll.add(arr[i]); 
            backtrack(arr, ans, ll); 
            ll.remove(ll.size() - 1); 
        }
    }
}
