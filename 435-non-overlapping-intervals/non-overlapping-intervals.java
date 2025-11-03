class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Handle the edge case of an empty array
        if (intervals.length == 0) return 0;

        // 1. Sort by end time (Correct!)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Count of intervals to REMOVE
        
        // 2. Initialize lastEnd with the end of the first interval
        int lastEnd = intervals[0][1]; 

        // 3. Loop from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // 4. Check for overlap with the last *kept* interval
            if (intervals[i][0] < lastEnd) {
                // Overlap found, this interval must be removed
                count++;
            } else {
                // 5. No overlap! "Keep" this interval by updating lastEnd
                lastEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}