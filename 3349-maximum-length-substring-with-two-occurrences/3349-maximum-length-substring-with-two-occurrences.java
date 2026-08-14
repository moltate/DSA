class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0, maxLen = 0;
        int[] freq = new int[26];
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right)- 'a']++;
        while(freq[s.charAt(right)-'a'] > 2){
            freq[s.charAt(left) - 'a']--;
            left++;
        }
          maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}