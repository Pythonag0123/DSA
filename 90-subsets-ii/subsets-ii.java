class Solution {
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        solve(nums,0,ans,ll);
        if(!set.contains(new ArrayList<>())){
            ans.add(new ArrayList<>());
        }
        return ans;
        

        

    }
    public void solve(int[] arr,int idx,List<List<Integer>> ans,List<Integer> ll){
        if(idx==arr.length){
            if(!set.contains(ll)){
                set.add(new ArrayList<>(ll));
                ans.add(new ArrayList<>(ll));
            }
            return;
        }
        solve(arr,idx+1,ans,ll);
        ll.add(arr[idx]);
        solve(arr,idx+1,ans,ll);
        ll.remove(ll.size()-1);


    }
}