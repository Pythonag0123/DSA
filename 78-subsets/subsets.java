class Solution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        solve(0,nums,ans,ll);
        return ans;


    }
    public static void solve(int idx,int[] nums,List<List<Integer>>ans,List<Integer> ll){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        ll.add(nums[idx]);
        solve(idx+1,nums,ans,ll);
        ll.remove(ll.size()-1);
        solve(idx+1,nums,ans,ll);
    }
    
        

        
    
    
}