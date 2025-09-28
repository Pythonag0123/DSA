

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] stops = new int[1001]; 

        
        for (int i = 0; i < trips.length; i++) {
            int numPass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            stops[from] += numPass;
            stops[to] -= numPass;
        }

        
        int curr = 0;
        for (int i = 0; i < 1001; i++) {
            curr += stops[i];
            if (curr > capacity) return false;
        }

        return true;
    }
}
