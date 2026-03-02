class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] diff = new int[1001]; // locations 0 to 1000

        for(int i = 0; i < trips.length; i++){
            int passengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            diff[start] += passengers;
            diff[end] -= passengers;  // note: end is exclusive
        }

        int currPassengers = 0;

        for(int i = 0; i <= 1000; i++){
            currPassengers += diff[i];
            if(currPassengers > capacity){
                return false;
            }
        }

        return true;
    }
}