import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        
        
        boolean[] used = new boolean[nums.length];
        
        helper(nums, ll, ans, used);
        return ans;
    }

  
    public void helper(int[] arr, List<Integer> ll, List<List<Integer>> ans, boolean[] used) {
        if (ll.size() == arr.length) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {

            if (used[i]) {
                continue;
            }
            
            used[i] = true; 
            ll.add(arr[i]);
            
         
            helper(arr, ll, ans, used);
            

            ll.remove(ll.size() - 1);
            used[i] = false; 
        }
    }
}