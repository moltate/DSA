//Smallest Palindromic Rearrangement 1

class Solution {
    public String smallestPalindrome(String s) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;

        for (int i = 0; i < 26; i++) {

            while (count[i] >= 2) {
                ans[left] = (char) ('a' + i);
                ans[right] = (char) ('a' + i);

                left++;
                right--;
                count[i] -= 2;
            }

            if (count[i] == 1) {
                ans[s.length() / 2] = (char) ('a' + i);
            }
        }

        return new String(ans);
    }
}