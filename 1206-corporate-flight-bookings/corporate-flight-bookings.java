class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];
        for(int i=0;i<bookings.length;i++){
            int l=bookings[i][0]-1;
            int r=bookings[i][1]-1;
            int val=bookings[i][2];
            
            ans[l]+=val;
            if(r+1<n){
                ans[r+1]-=val;
            }
                
            
        }
        for(int i=1;i<n;i++){
            ans[i]=ans[i]+ans[i-1];
        }
        return ans;
        
    }
}