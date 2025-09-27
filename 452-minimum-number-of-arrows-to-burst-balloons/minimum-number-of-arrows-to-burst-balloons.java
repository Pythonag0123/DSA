class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int prevSp = points[0][0];
        int prevEp = points[0][1];

        
        for (int i = 1; i < points.length; i++) {
            int currSp = points[i][0];
            int currEp = points[i][1];

            
            if (currSp <= prevEp) {
                prevSp = Math.max(prevSp, currSp);
                prevEp = Math.min(prevEp, currEp); 
            } 
            
            else {
                arrows++;
                prevSp = currSp;
                prevEp = currEp;
            }
        }

        return arrows;
    }
}
