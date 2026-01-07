class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int oldcolor=image[sr][sc];
        dfs(image,sr,sc,color,oldcolor);
        return image;
        
    }
    public void dfs(int[][] grid,int i,int j,int color,int oldcolor){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!=oldcolor){
            return;
        }
        grid[i][j]=color;
        dfs(grid,i-1,j,color,oldcolor);
        dfs(grid,i+1,j,color,oldcolor);
        dfs(grid,i,j-1,color,oldcolor);
        dfs(grid,i,j+1,color,oldcolor);
    }
}