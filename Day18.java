//Range Sum Query
class NumArray {

    private int[] prefixSum;
    public NumArray(int[] nums) {
        for (int i=1; i< nums.length; i++){
            nums[i] += nums[i-1];
        }
        this.prefixSum = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return prefixSum[right];
        return prefixSum[right] - prefixSum[left - 1];
    }
}

// Range Sum Query 2D
class NumMatrix {
        int[][] matrix ;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int r  = matrix.length;
        int c = matrix[0].length;

        for(int i=0; i<r;i++){
            for(int j=1; j<c; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++){
            if(col1>=1){
                sum += matrix[i][col2] - matrix[i][col1 -1];
            }else{
                sum += matrix[i][col2];
            }
        }

        return sum; 
    }
}

//Matrix Block Sum
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
           int m = mat.length;
           int n = mat[0].length;

           int[][] prefix = new int[m + 1][n + 1];
           
           for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = mat[i-1][j-1] +prefix[i-1][j] + prefix[i][j-1]  - prefix[i-1][j-1];
            }
           }

           int[][] ans = new int[m][n];

           for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                int r1 =Math.max(0, i - k);
                int c1 =Math.max(0, j - k);
                int r2 =Math.min(m-1, i + k);
                int c2 =Math.min(n-1, j + k);

                r1++;
                c1++;
                r2++;
                c2++;

                ans[i][j] = prefix[r2][c2] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1] + prefix[r1 - 1][c1 - 1];
            }
           }
           return ans;
    }
}
 
