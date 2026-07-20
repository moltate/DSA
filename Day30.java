//String to Integer
class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            if (result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                return sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;

            i++;
        }

        return sign * result;
    }
}

//Find the Index of First Occurrence in the String


class Solution {

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m &&
                   haystack.charAt(i + j) == needle.charAt(j)) {

                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}

//Generate Parentheses

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack("",0,0,n);
        return ans;
    }
    public void backtrack(String curr, int open, int close, int n){
        if(curr.length() == 2*n){
            ans.add(curr);
            return;
        }
        if(open < n){
            backtrack(curr + "(", open + 1, close, n);
        }
        if(close < open){
            backtrack(curr + ")" , open, close + 1, n);
        }
    }
}

//Check if a Parentheses String Can Be Valid

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 != 0) return false;
        int balance = 0;

        for (int i = 0; i < n ; i++){
            if(locked.charAt(i) == '0' || s.charAt(i) == '('){
                balance++;
            }else{
                balance--;
            }
            if(balance<0) return false;
        }
        balance = 0;
        for(int i = n -1 ; i >= 0 ; i--){
            if(locked.charAt(i) == '0' || s.charAt(i) == ')'){
                balance++;
            }else{
                balance--;
            }
            if(balance < 0) return false;
        }
        return true;
    }
}
