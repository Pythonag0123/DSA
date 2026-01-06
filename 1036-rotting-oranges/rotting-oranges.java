class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        int time=0;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }    
        }
        while(!q.isEmpty() && fresh>0){
           int size=q.size();
           time++;
           while(size-->0){
            int[] curr=q.poll();
            for(int k=0;k<4;k++){
                int r=curr[0]+dr[k];
                int c=curr[1]+dc[k];
                if(r>=0&&c>=0&&r<n&&c<m&& grid[r][c]==1){
                    grid[r][c]=2;
                    fresh--;
                    q.add(new int[]{r,c});
                }
            }
           }
           
        }
        return fresh==0?time:-1;
        
    }
}