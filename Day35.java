//N-Queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2  = new boolean[2 * n - 1];
        backtrack(result, new ArrayList<>(), n, 0, columns, diag1, diag2);
        return result;
    }
    private void backtrack(List<List<String>> result, List<String> temp, int n , int row, boolean[] columns, boolean[] diag1, boolean[] diag2){
        if(row == n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int col = 0; col < n; col++){
            if(columns[col] || diag1[row - col + n - 1] || diag2[row + col]) continue;

            char[] boardRow = new char[n];
            Arrays.fill(boardRow, '.');
            boardRow[col] = 'Q';
            temp.add(new String(boardRow));

            columns[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            backtrack(result, temp, n , row+1, columns, diag1, diag2);
            temp.remove(temp.size() - 1);

            columns[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;

        }
    }
}

//Sudoku Solver

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board){
        for(int row = 0 ; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    for(char num = '1'; num<='9'; num++ ){
                        if(isValid(board, row, col, num){
                            board[row][col] = num;
                            if(backtrack(board)){
                                return true;
                            }
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char num){
        for(int i = 0 ;i < 9; i++){
            if (board[row][i] == num || board[i][col] == num ||
                board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num){
                return false;
            }
        }
        return true;
    }
}

//Stone Game

class Solution {

    public boolean stoneGame(int[] piles) {

        int n = piles.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                int left = piles[i] - dp[i + 1][j];

                int right = piles[j] - dp[i][j - 1];

                dp[i][j] = Math.max(left, right);
            }
        }

        return dp[0][n - 1] > 0;
    }
}

//Stone Game III

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for(int i = n - 1; i >= 0; i--){
             dp[i] = Integer.MIN_VALUE;
             int sum = 0 ;
             for(int k = 0; k < 3 && i + k < n ; k++){
                sum += stoneValue[i + k];
                dp[i] = Math.max(dp[i] , sum - dp[i + k + 1]);
             }
        }
        if (dp[0] > 0)
            return "Alice";

        if (dp[0] < 0)
            return "Bob";

        return "Tie";
    }
}


//Find Missing Elements

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}

//Smallest Divisible Digit Product I

class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int product = digitProduct(n);
            if(product % t == 0){
                return n++;
            }
             n++;
        }
    }
    private int digitProduct(int num){
        int product = 1;
        while(num > 0){
           product *= num % 10;
           num /= 10;
        }
        return product;
    }
}
