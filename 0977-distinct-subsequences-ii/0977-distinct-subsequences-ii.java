class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_00_00_00_007;
        int total = 0;
        int[] dp = new int[26];
        for(int i = 0; i < s.length(); i++){
           int c = s.charAt(i) - 97;
           int ans = (total - dp[c] + MOD) % MOD;
           dp[c] = total + 1;
           total = (dp[c] + ans) % MOD;
        }
        return total;
    }
}