class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        
        int x = 0;
        List<int[]> lt = new ArrayList<>();
        
        // Step 1: add non-overlapping intervals before newInterval
        for(; x < intervals.length; x++) {
            if(intervals[x][0] <= newInterval[1] && newInterval[0] <= intervals[x][1]) {
                intervals[x][0] = Math.min(intervals[x][0], newInterval[0]);
                intervals[x][1] = Math.max(intervals[x][1], newInterval[1]);
                break;
            }
            lt.add(new int[]{intervals[x][0], intervals[x][1]});
        }
        
        // Step 2: if newInterval comes after all existing intervals
        if(x >= intervals.length) {
            lt.add(new int[]{newInterval[0], newInterval[1]});
            Collections.sort(lt, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });
            return lt.toArray(new int[lt.size()][]);
        }

        // Step 3: merge overlapping intervals
        int l = intervals[x][0];
        int r = intervals[x][1];
      
        for (int i = x; i < intervals.length; i++) {
            if (r >= intervals[i][0]) {
                r = Math.max(intervals[i][1], r);
            } else {
                lt.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        lt.add(new int[]{l, r});
      
        return lt.toArray(new int[lt.size()][]);
    }
}