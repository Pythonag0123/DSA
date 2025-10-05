class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        solve(candidates,target,0,ans,ll);
        return ans;

        
    }
    public void solve(int[] arr,int amount,int idx,List<List<Integer>> ans,List<Integer>ll){
        if(amount==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx==arr.length||amount<0){
            return;
        }
        ll.add(arr[idx]);
        solve(arr,amount-arr[idx],idx+1,ans,ll);
        ll.remove(ll.size()-1);
        int next=idx+1;
        while(next<arr.length && arr[next]==arr[idx]){
            next++;
        }
        solve(arr,amount,next,ans,ll);
    }
}