class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        int oneD=0;
        int noD=arr[0];
        int ans=arr[0];
        for(int i=1;i<n;i++){
            
            oneD=Math.max(noD,arr[i]+oneD);
            noD=Math.max(arr[i],arr[i]+noD);
            ans=Math.max(ans,Math.max(noD,oneD));
        }
        return ans;

        
    }
}