class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>(); 
        helper(candidates,target,0,ll,ans);
        return ans;
        
    }
    public void helper(int[] arr,int target,int idx,List<Integer> ll,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(target<0||idx==arr.length){
            return;
        }
        ll.add(arr[idx]);
        helper(arr,target-arr[idx],idx+1,ll,ans);
        ll.remove(ll.size()-1);
        int next=idx+1;
        while(next<arr.length && arr[next]==arr[idx]){
            next++;
        }
        helper(arr,target,next,ll,ans);
    
    }
}