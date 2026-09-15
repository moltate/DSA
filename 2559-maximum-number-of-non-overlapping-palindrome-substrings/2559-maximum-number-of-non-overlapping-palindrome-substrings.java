class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(k == 1) return n;
        int ans = 0, i = 0;
        while(i<=n-k){
            if(check(s,i,i+k-1)){
                ans++;
                i += k;
            }else if(i < n-k && check(s,i,i+k)){
                ans++; 
                i += k + 1;
            }else{
                i++;
            }
        }
        return ans;
    }
    boolean check(String s, int l, int r){
       while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}