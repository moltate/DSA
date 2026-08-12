class Solution {
    public int maxSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < r -2; i++){
            for(int j = 0; j < c - 2; j++){
                int sum = 0;
                sum += grid[i][j];
                sum += grid[i][j+1];
                sum += grid[i][j+2];

                sum += grid[i+1][j+1];

                sum += grid[i+2][j];
                sum += grid[i+2][j+1];
                sum += grid[i+2][j+2];

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}