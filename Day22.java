//Permutation in String
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) -'a']++;
        }
            if(matches(s1Count,windowCount)){
                return true;
            }
        for(int i = s1.length(); i< s2.length(); i++){
            windowCount[s2.charAt(i) - 'a']++;
            windowCount[s2.charAt(i - s1.length()) - 'a']--;
            if(matches(s1Count,windowCount)){
                return true;
            }
        }
        return false;
    }
    public boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
        if(a[i] != b[i]){
            return false;
           } 
        }
        return true;
    }
}

//Minimum Window Substring
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int[] ans = new int[126];
        for(char c: t.toCharArray()){
            ans[c]++;
        }
        int left=0, count = t.length(), minLen= Integer.MAX_VALUE, start = 0;
        for(int right = 0 ; right < s.length() ; right++){
            char r = s.charAt(right);
            if(ans[r]>0) count--;
            ans[r]--;
            while(count==0){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left; 
                }
                char l = s.charAt(left);
                ans[l]++;

                if(ans[l] > 0){
                    count++;
                }
                    left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}


//Longest Substring with K Uniques

class Solution {
    public int longestKSubstr(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        
        int left = 0, maxLen = -1;
        
        for (int right = 0; right < s.length() ; right++){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0)+1);
            
            while(map.size() > k){
                char l = s.charAt(left);
                map.put(l, map.getOrDefault(l, 0) - 1);
                
                if(map.get(l) == 0){
                map.remove(l);
            }
            left++;
        }
            if(map.size() == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
