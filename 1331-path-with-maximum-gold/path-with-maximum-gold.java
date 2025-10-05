class Solution {
    int maxGold = 0; 

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return maxGold;
    }

    public void dfs(int[][] grid, int i, int j, int currGold) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return;

        
        int gold = grid[i][j];
        currGold += gold;
        maxGold = Math.max(maxGold, currGold);

        
        grid[i][j] = 0;

        
        dfs(grid, i + 1, j, currGold);
        dfs(grid, i - 1, j, currGold);
        dfs(grid, i, j + 1, currGold);
        dfs(grid, i, j - 1, currGold);

        
        grid[i][j] = gold;
    }
}
