class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(ls,ans,candidates,0,target);
        return ans;    
    }
    public void helper(List<Integer> ls,List<List<Integer>> ans,int[] candidates,int idx,int target){
        if(target==0){
            ans.add(new ArrayList(ls));
            return;
        }
        if(target<0||idx==candidates.length){
            return;
        }
        ls.add(candidates[idx]);
        helper(ls,ans,candidates,idx,target-candidates[idx]);
        ls.remove(ls.size()-1);
        helper(ls,ans,candidates,idx+1,target);
    }
}