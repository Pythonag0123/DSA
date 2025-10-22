class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(n, k, 1, ll, ans); 
        return ans;
    }

    public void helper(int n, int k, int start, List<Integer> ll, List<List<Integer>> ans) {
        
        if (ll.size() == k) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        
        for (int i = start; i <= n; i++) {
  
            ll.add(i);
            helper(n, k, i + 1, ll, ans);
            ll.remove(ll.size() - 1);
        }
    }
}