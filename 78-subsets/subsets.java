class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        helper(nums,0,ll,ans);
        return ans;
        
    }
    public void helper(int[] arr,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(idx==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        ll.add(arr[idx]);
        helper(arr,idx+1,ll,ans);
        ll.remove(ll.size()-1);
        helper(arr,idx+1,ll,ans);

    }
}