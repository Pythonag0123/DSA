class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        int[] arr=new int[9];
        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
        solve(arr,k,n,0,ans,ll);
        return ans;
        
    }
    public void solve(int[] arr,int k,int n,int idx,List<List<Integer>> ans,List<Integer> ll){
            if(k==0 && n==0){
                ans.add(new ArrayList<>(ll));
                return;
            }
            if(idx==arr.length){
                return;
            }
            if(k==0 || n==0){
                return;
            }
            ll.add(arr[idx]);
            solve(arr,k-1,n-arr[idx],idx+1,ans,ll);
            ll.remove(ll.size()-1);
            solve(arr,k,n,idx+1,ans,ll);
        }
        
}