class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        solve(candidates,0,target,ans,ll);
        return ans;
        

        
    }
    public void solve(int[] arr,int idx,int amount,List<List<Integer>>ans,List<Integer>ll){
        if(amount==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(amount<0||idx==arr.length){
            return;
        }
        ll.add(arr[idx]);
        solve(arr,idx,amount-arr[idx],ans,ll);
        ll.remove(ll.size()-1);
        solve(arr,idx+1,amount,ans,ll);
    }
}