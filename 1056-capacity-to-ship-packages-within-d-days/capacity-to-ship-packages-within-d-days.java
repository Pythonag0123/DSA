class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int hi=0;
        int lo=weights[0];
        for(int i=0;i<weights.length;i++){
            lo=Math.max(weights[i],lo);
            hi+=weights[i];
        }
        int ans=hi;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(canShip(weights,days,mid)){
                ans=mid;
                hi=mid-1;
            
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
        
    }
    public boolean canShip(int[] weights,int day,int cap){
        int load=0;
        int d=1;
        for(int i=0;i<weights.length;i++){
            if((load+weights[i])>cap){
                d++;
                load = weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return d<=day;
    }
}