class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr=new int[9];
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ll=new ArrayList<>();

        for(int i=1;i<=arr.length;i++){
            arr[i-1]=i;
        }
        combination(arr,0,k,n,ans,ll);
        return ans;
        
    }
    public static void combination(int[] arr,int idx,int k,int n,List<List<Integer>> ans,List<Integer> ll){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx==arr.length){
            return;
        }
        if(k==0||n==0){
            return;
        }
        
        ll.add(arr[idx]);
        combination(arr,idx+1,k-1,n-arr[idx],ans,ll);
        ll.remove(ll.size()-1);
        combination(arr,idx+1,k,n,ans,ll);
        
    }
}