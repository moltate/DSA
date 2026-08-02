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
