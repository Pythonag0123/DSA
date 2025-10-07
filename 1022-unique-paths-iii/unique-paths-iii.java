class Solution {
    int res = 0, empty = 1;
    public int uniquePathsIII(int[][] g) {
        int sx = 0, sy = 0;
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) empty++;
                else if (g[i][j] == 1) { sx = i; sy = j; }
            }
        dfs(g, sx, sy);
        return res;
    }

    void dfs(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == -1) return;
        if (g[i][j] == 2) { if (empty == 0) res++; return; }
        g[i][j] = -1; empty--;
        dfs(g, i+1, j); dfs(g, i-1, j); dfs(g, i, j+1); dfs(g, i, j-1);
        g[i][j] = 0; empty++;
    }
}