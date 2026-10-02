class Solution {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return list;
    }
    private void backtrack(String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            list.add(curr);
            return;
        }
        if(open < n){
            backtrack(curr + "(", open + 1, close, n);
        }
        if(close < open){
            backtrack(curr + ")", open, close + 1, n);
        }
    }
}