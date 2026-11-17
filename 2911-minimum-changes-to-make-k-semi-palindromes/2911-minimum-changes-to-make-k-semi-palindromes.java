class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = n;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0 || d * 2 > len) continue;
                    int changes = 0;
                    for (int x = 0; x < d; x++) {
                        for (int a = i + x, b = j - d + 1 + x;
                             a < b; a += d, b -= d) {
                            if (s.charAt(a) != s.charAt(b)) changes++;
                        }
                    }
                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1000000);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= k; p++) {
                for (int j = 0; j <= i - 2; j++) {
                    dp[i][p] = Math.min(dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]);
                }
            }
        }
        return dp[n][k];
    }
}