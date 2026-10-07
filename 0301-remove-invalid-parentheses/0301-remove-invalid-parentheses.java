class Solution {
    Set<String> result = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        dfs(s, 0, left, right, 0, new StringBuilder());
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int leftRemove, int rightRemove, int balance, StringBuilder current) {
        if (balance < 0) {
            return;
        }
        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                result.add(current.toString());
            }
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(' && leftRemove > 0) {
            dfs(s, index + 1,
                leftRemove - 1,
                rightRemove,
                balance,
                current);
        }

        if (ch == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftRemove, rightRemove - 1, balance, current);
        }
        current.append(ch);

        if (ch == '(') {

            dfs(s, index + 1, leftRemove, rightRemove, balance + 1, current);

        } else if (ch == ')') {

            dfs(s, index + 1, leftRemove, rightRemove, balance - 1, current);

        } else {
            dfs(s, index + 1, leftRemove, rightRemove, balance, current);
        }
        current.deleteCharAt(current.length() - 1);
    }
}