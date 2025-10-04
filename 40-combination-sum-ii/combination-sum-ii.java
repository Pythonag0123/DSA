class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        solve(candidates,target,0,ans,ll);
        return ans;

        
    }
    public static void solve(int[] arr,int target,int idx,List<List<Integer>> ans,List<Integer> ll){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx==arr.length||target<0){
            return;
        }
        ll.add(arr[idx]);
        solve(arr,target-arr[idx],idx+1,ans,ll);
        ll.remove(ll.size()-1);
        int next=idx+1;
        while(next<arr.length && arr[idx]==arr[next]){
            next++;
        }
        solve(arr,target,next,ans,ll);

        

    }

}