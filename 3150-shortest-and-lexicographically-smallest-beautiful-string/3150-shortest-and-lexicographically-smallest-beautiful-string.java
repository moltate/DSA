class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> value = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='1'){
                value.add(i);
            }
        }
        if(value.size() < k) return "";
        String ans = "";
        for(int i = 0; i + k - 1< value.size(); i++){
            int start = value.get(i);
            int end = value.get(i + k - 1);
            String curr = s.substring(start,end+1);
            if(ans == "" || curr.length()<ans.length() || (curr.length() == ans.length() && curr.compareTo(ans)<0)){
                ans = curr;
            }
        }
        return ans;
    }
}