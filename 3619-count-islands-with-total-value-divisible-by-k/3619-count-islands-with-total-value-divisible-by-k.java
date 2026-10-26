class Solution {
    int ans = 0;
    public int countIslands(int[][] grid, int k) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    long s = dfs(grid, i, j);
                    if (s % k == 0) ans++;
                }
            }
        }
        return ans;
    }
    static long dfs(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        long sum = grid[i][j];
        grid[i][j] = 0;
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i - 1, j);
        sum += dfs(grid, i, j + 1);
        sum += dfs(grid, i, j - 1);
        return sum;
    }
}