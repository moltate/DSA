//Edit Distance

class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],   
                            Math.min(
                                    dp[i - 1][j], 
                 dp[i][j - 1]  
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }
}

//FizzBuzz

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}

//Stone Game II

class Solution {

    int remainingStones[];

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        remainingStones = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            remainingStones[i] = piles[i] + remainingStones[i + 1];

        }

        int dp[][] = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {

                for (int k = 1; k <= 2*j; k++) {

                    if (i + k <= n) {

                        dp[i][j] = Math.max(dp[i][j], remainingStones[i] - dp[i + k][Math.max(k, j)]);
                    }

                }

            }
        }

        return dp[0][1];

    }
}

//Sum Game

class Solution {
    public boolean sumGame(String A) {
        int[] sum = {0, 0}, q = {0, 0};
        int n = A.length();

        for (int i = 0; i < n; i++) {
            int j = i / (n >> 1);
            if (A.charAt(i) == '?')
                q[j]++;
            else
                sum[j] += A.charAt(i) - '0';
        }

        return ((q[0] + q[1]) % 2 == 1) ||
               ((sum[0] - sum[1]) << 1) != (q[1] - q[0]) * 9;
    }
}