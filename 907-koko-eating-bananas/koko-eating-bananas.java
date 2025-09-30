class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int p:piles) hi=Math.max(p,hi);
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(canEat(piles,h,mid)){
                hi=mid;
            }
            else{
                lo=mid+1;
            }

        }
        return lo;



        
    }
    public boolean canEat(int[] piles,int h,int s){
        int time=0;
        for(int p:piles){
            time+=(p+s-1)/s;
            if(time>h) return false;
        }
        return true;

    }
}