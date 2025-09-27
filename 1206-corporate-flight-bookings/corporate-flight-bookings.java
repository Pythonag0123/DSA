class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flight = new int[n];
        int m = bookings.length;

        for(int i=0;i<m;i++){
            int s = bookings[i][0] - 1; 
            int e = bookings[i][1];    
            int se = bookings[i][2];

            flight[s] += se;
            if(e < n){
                flight[e] -= se;
            }
        }

        for(int i=1;i<n;i++){
            flight[i] += flight[i-1];
        }
        return flight;
    }
}
