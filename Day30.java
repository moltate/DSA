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
