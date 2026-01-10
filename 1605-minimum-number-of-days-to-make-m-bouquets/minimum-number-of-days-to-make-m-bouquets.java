class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long flowerNeeded=(long) m*k;
        if(flowerNeeded>n) return -1;
        int hi=Integer.MIN_VALUE;
        int lo=Integer.MAX_VALUE;
        for (int day : bloomDay) {
            lo = Math.min(lo, day);
            hi = Math.max(hi, day);
        }

        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(canMakeBouquets(bloomDay,m,k,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
        
    }
    public boolean canMakeBouquets(int[] bloomDay, int m, int k,int days){
        int flowers=0;
        int bouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            if(days>=bloomDay[i]){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;
                }
            }
            else{
                flowers=0;

            }
        }
        return bouquets>=m;
    }
}