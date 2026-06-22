//Valid Palindrome II
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
     public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//Longest Palindromic Substring
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end=0;
        for(int i = 0 ; i < n; i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1, len2);

            if(len> (end - start)){
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }
        return  s.substring(start,end+1);
    }

    public int expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}

//Palindromic Substrings
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i =0 ; i < s.length() ; i ++){
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }
       return count;
    }
    
    public int expand(String s, int left, int right){
        int count =0; 
          while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
          }
          return count;
    }
}
