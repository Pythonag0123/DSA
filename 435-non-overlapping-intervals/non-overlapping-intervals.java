

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int n = intervals.length;
        int count = 0;
        
        int prevEnd = intervals[0][1]; // keep first interval
        
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prevEnd) {
                
                count++;
            } else {
                
                prevEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}
