//Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n= s.length();
        int m = p.length();
        List<Integer> list = new ArrayList<>();
        if (m>n) return list;
        int sCount[] = new int[26];
        int pCount[] = new int[26];
        for (int i = 0 ; i < m; i++){
            int si = s.charAt(i) - 'a';
            int pi = p.charAt(i) - 'a';
            sCount[si]++;
            pCount[pi]++;
        }
        if(Arrays.equals(sCount,pCount)){
            list.add(0);
        }
         for(int i = 1; i <= n-m ; i++){
             int prev = s.charAt(i-1) - 'a';
            int next = s.charAt(i+m-1) - 'a';
            sCount[prev]--;
            sCount[next]++;
            if(Arrays.equals(sCount,pCount)){
                list.add(i);
            }
         }    
         return list;
    }
}

//Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        while(end<n){
          char ch = s.charAt(end);
          if(map.containsKey(ch) && map.get(ch)>=start){
                start = map.get(ch)+1;
            }
          map.put(ch,end);
          maxLen = Math.max(maxLen, end - start + 1);
          end++;
        }
        return (maxLen==Integer.MIN_VALUE)?0:maxLen;        
    }
}
