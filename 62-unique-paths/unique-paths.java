class Solution {
    public int uniquePaths(int m, int n) {
        //backtracking+memorization
        boolean[][] grid=new boolean[m][n];
        int[][] memo=new int[m][n];
        for(int[] row:memo)Arrays.fill(row,-1);
        return paths(0,0,grid,m,n,memo);
    }
    public int paths(int row,int col,boolean[][] grid,int m,int n,int[][] memo){
        if(row==m-1 && col==n-1)return 1;
        if(memo[row][col]!=-1)return memo[row][col];
        grid[row][col]=true;
        int left=0,right=0;
        //down
        if(row!=m-1)
        left=paths(row+1,col,grid,m,n,memo);
        //right
        if(col!=n-1)
        right=paths(row,col+1,grid,m,n,memo);
        grid[row][col]=false;
        return memo[row][col]=left+right;
    }
}