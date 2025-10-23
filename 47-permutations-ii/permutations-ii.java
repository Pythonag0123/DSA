class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);  // Sort to handle duplicates
        helper(nums, ll, ans, used);
        return ans;
    }

    public void helper(int[] arr, List<Integer> ll, List<List<Integer>> ans, boolean[] used) {
        if (ll.size() == arr.length) {
            ans.add(new ArrayList<>(ll));  // Make a copy of the current permutation
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;  // Skip already used elements
            
            // Skip duplicates: If the element is the same as the previous one and hasn't been used yet, skip it
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            // Add the current element and mark it as used
            ll.add(arr[i]);
            used[i] = true;
            
            // Recur with the current element added
            helper(arr, ll, ans, used);

            // Backtrack: remove the last element and mark it as unused
            ll.remove(ll.size() - 1);
            used[i] = false;
        }
    }
}
