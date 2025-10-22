class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();

        helper(nums,ll,ans);
        return ans;
        
    }
    public void helper(int[] arr,List<Integer> ll,List<List<Integer>> ans){
        if(ll.size()==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(ll.contains(arr[i])) continue;
            
            ll.add(arr[i]);
            helper(arr,ll,ans);
            ll.remove(ll.size()-1);
            
            
        }
        
    
    }
}